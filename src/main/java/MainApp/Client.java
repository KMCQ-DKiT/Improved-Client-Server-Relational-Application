package MainApp;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client
{
    public static void main(String[] args)
    {
        Client client = new Client();
        client.start();
    }

    public void start()
    {
        Scanner k = new Scanner(System.in);
        try {
            Socket socket = new Socket("localhost", 8080);  // connect to server socket
            System.out.println("Client: Port# of this client : " + socket.getLocalPort());
            System.out.println("Client: Port# of Server :" + socket.getPort() );

            System.out.println("Client message: The Client is running and has connected to the server");

            System.out.println("1. Find By ID");
            System.out.println("2. Display All(JSON Format)");
            System.out.println("3. Add");
            System.out.println("4. Delete");
            System.out.println("5. Trophy Comparator");
            System.out.println("6. Exit");
            System.out.println("Enter your option: [1-6]");

            String command = k.nextLine();

            OutputStream os = socket.getOutputStream();
            PrintWriter socketWriter = new PrintWriter(os, true);   // true => auto flush buffers

            socketWriter.println(command);

            Scanner socketReader = new Scanner(socket.getInputStream());  // wait for, and retrieve the reply

            boolean continueLooping = true;
            while(continueLooping==true) {
                if (command.equalsIgnoreCase("1"))   //we expect the server to return a time
                {
                    System.out.println("Enter ID: ");
                    String id = k.nextLine();
                    socketWriter.println("DisplayProductsById " + id);
                    String i = socketReader.nextLine();
                    System.out.println("Client message: Response from server: \"" + i + "\"");
                }
                else if(command.equalsIgnoreCase("2"))
                {
                    socketWriter.println("DisplayAllProducts");
                    String i = socketReader.nextLine();
                    System.out.println("Client message: Response from server: \"" + i + "\"");
                }
                else if(command.equalsIgnoreCase("3"))
                {
                    System.out.println("Enter SortCode: ");
                    String sortCode = k.nextLine();
                    System.out.println("Enter ProductName: ");
                    String productName = k.nextLine();
                    System.out.println("Enter ProductDescription: ");
                    String productDesc = k.nextLine();
                    System.out.println("Enter ProductPrice: ");
                    String productPrice = k.nextLine();
                    System.out.println("Enter ProductType: ");
                    String productType = k.nextLine();


                    socketWriter.println("Add " + sortCode + " " + productName + " " + productDesc + " " + productPrice + " " + productType);
                    String i = socketReader.nextLine();
                    System.out.println("Client message: Response from server: \"" + i + "\"");
                }
                else if (command.equalsIgnoreCase("4"))
                {
                    System.out.println("Enter ID: ");
                    String id = k.nextLine();
                    socketWriter.println("DeleteProductById " + id);
                    String i = socketReader.nextLine();
                    System.out.println("Client message: Response from server: \"" + i + "\"");
                }
                else if (command.equalsIgnoreCase("5"))
                {
                    System.out.println("Enter SortCode Filter: ");
                    String sortCode = k.nextLine();
                    socketWriter.println("FilterBySortCode " + sortCode);
                    String i = socketReader.nextLine();
                    System.out.println("Client message: Response from server: \"" + i + "\"");
                }
                else{
                    continueLooping = false;
                }

                System.out.println("1. Display All(JSON Format)");
                System.out.println("2. Find By ID");
                System.out.println("3. Add");
                System.out.println("4. Delete");
                System.out.println("5. Trophy Comparator");
                System.out.println("6. Exit");
                System.out.println("Enter your option: [1-6]");

                command = k.nextLine();
                socketWriter.println(command);
            }

            socketWriter.close();
            socketReader.close();
            socket.close();

        } catch (IOException e) {
            System.out.println("Client message: IOException: "+e);
        }
    }
}