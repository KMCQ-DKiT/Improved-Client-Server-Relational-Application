package MainApp;

import Comparators.ProductComparator;
import DAOs.MySqlProductDao;
import DAOs.ProductDaoInterface;
import DTOs.Products;
import Exceptions.DaoException;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class Server
{

    public ProductDaoInterface IUserDao = new MySqlProductDao();
    ProductComparator productComparator = new ProductComparator();

    public static void main(String[] args)
    {
        Server server = new Server();
        server.start();

    }

    public void start()
    {
        try
        {
            ServerSocket ss = new ServerSocket(8080);  // set up ServerSocket to listen for connections on port 8080

            System.out.println("Server: Server started. Listening for connections on port 8080...");

            int clientNumber = 0;  // a number for clients that the server allocates as clients connect

            while (true)    // loop continuously to accept new client connections
            {
                Socket socket = ss.accept();    // listen (and wait) for a connection, accept the connection,
                // and open a new socket to communicate with the client
                clientNumber++;

                System.out.println("Server: Client " + clientNumber + " has connected.");

                System.out.println("Server: Port# of remote client: " + socket.getPort());
                System.out.println("Server: Port# of this server: " + socket.getLocalPort());

                Thread t = new Thread(new ClientHandler(socket, clientNumber)); // create a new ClientHandler for the client,
                t.start();                                                  // and run it in its own thread

                System.out.println("Server: ClientHandler started in thread for client " + clientNumber + ". ");
                System.out.println("Server: Listening for further connections...");
            }
        } catch (IOException e)
        {
            System.out.println("Server: IOException: " + e);
        }
        System.out.println("Server: Server exiting, Goodbye!");
    }

    public class ClientHandler implements Runnable   // each ClientHandler communicates with one Client
    {
        BufferedReader socketReader;
        PrintWriter socketWriter;
        Socket socket;
        int clientNumber;

        public ClientHandler(Socket clientSocket, int clientNumber)
        {
            try
            {
                InputStreamReader isReader = new InputStreamReader(clientSocket.getInputStream());
                this.socketReader = new BufferedReader(isReader);

                OutputStream os = clientSocket.getOutputStream();
                this.socketWriter = new PrintWriter(os, true); // true => auto flush socket buffer

                this.clientNumber = clientNumber;  // ID number that we are assigning to this client

                this.socket = clientSocket;  // store socket ref for closing

            } catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }

        @Override
        public void run()
        {
            String message;
            try
            {
                while ((message = socketReader.readLine()) != null)
                {
                    System.out.println("Server: (ClientHandler): Read command from client " + clientNumber + ": " + message);


                    if (message.startsWith("DisplayProductsById"))
                    {
                        String[] tokens = message.split(" ");
                        int id = Integer.parseInt(tokens[1]);
                        Products player = IUserDao.findProductsByID(id);
                        socketWriter.println(player);
                    }
                    else if(message.startsWith("DisplayAllProducts"))
                    {
                        List playerList = IUserDao.findAllProducts();
                        socketWriter.println(playerList);
                    }
                    else if(message.startsWith("Add"))
                    {
                        String[] tokens = message.split(" ");
                        int sort_code = Integer.parseInt(tokens[1]);
                        String productName = (tokens[2]);
                        String productDesc = (tokens[3]);
                        double productPrice = Double.parseDouble(tokens[4]);
                        String productType = (tokens[5]);
                        IUserDao.addProduct(sort_code,productName,productDesc,productPrice,productType);
                        Products p = IUserDao.findProductsByID(sort_code);
                        socketWriter.println("Product added: " + p);
                    }
                    else if (message.startsWith("DeleteProductById"))
                    {
                        String[] tokens = message.split(" ");
                        int id = Integer.parseInt(tokens[1]);
                        IUserDao.DeleteProductByID(id);
                        Products x = IUserDao.findProductsByID(id);
                        if(x!= null){
                            socketWriter.println("Not deleted");
                        }
                        else
                        {
                            socketWriter.println("Product deleted");
                        }

                    }
                    else if (message.startsWith("SortCodeFilter"))
                    {
                        String[] tokens = message.split(" ");
                        int sortCode = Integer.parseInt(tokens[1]);
                        List pList = IUserDao.filterMySQL(sortCode, productComparator);
                        if(pList.size() > 0){
                            socketWriter.println(pList);
                        }
                        else
                        {
                            socketWriter.println("No products have " + sortCode + " sortCode");
                        }

                    }


                }

                socket.close();

            } catch (IOException ex)
            {
                ex.printStackTrace();
            } catch (DaoException e) {
                e.printStackTrace();
            }
            System.out.println("Server: (ClientHandler): Handler for Client " + clientNumber + " is terminating .....");
        }
    }

}