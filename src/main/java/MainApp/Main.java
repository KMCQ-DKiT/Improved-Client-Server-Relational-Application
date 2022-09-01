package MainApp;

import Comparators.ProductComparator;
import Comparators.SortType;
import Comparators.twoProductComparator;
import DAOs.MySqlProductDao;
import DAOs.ProductDaoInterface;
import DTOs.Products;
import Exceptions.DaoException;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Main app = new Main();
        app.start();

    }
    public void start()
    {
        displayBarMenu();        // User Interface - Menu

        System.out.println("Program ending, Goodbye");
    }
    //ArrayLists
    public void arrayList(List list) {
        list.add(new Products(1196549, "Fleetwood 5L Sheen Warm Grey", "Easy Application, Quick Drying, Low Odour, Water Based " , 36.00, "Paint"));
        list.add(new Products(1096007, "Fleetwood 2.5 Litre Sheen Smithsonian", "Walls and ceilings, Stains wipe clean, Excellent coverage, Easy to apply", 22.00, "Paint"));
        list.add(new Products(375460, "Dulux Vinyl Soft Sheen Tir na nOg 5L", "Tough washable finish, Fashionable mid-sheen finish, Coverage of up to 16m2", 58.99, "Paint"));
        list.add(new Products(324900, "Dulux Easycare Kitchens Iced White 2.5L", "Stain Resistant, Withstands Scrubbing, Washable", 51.99, "Paint"));
        list.add(new Products(1145539, "Black+Decker 1600W Corded 38CM Electric Lawnmower", "Bike Handle design for improved ergonomics and even weight distribution", 199.99, "GardenTools"));
        list.add(new Products(1156976, "Black+Decker 1000W Corded 32CM Lawnmower", "1000W Mower with 32cm cutting deck, perfect for keeping your garden lawn tidy", 99.99, "GardenTools"));
        list.add(new Products(1201772, "Pro Lawn 46cm Self Propelled B&S Petrol Lawnmower", "Powerful Briggs & Stratton engine delivers effortless mowing", 379.99, "GardenTools"));
        list.add(new Products(1156605, "Black+Decker 500W Corded Hammer Drill", "Hammer action suitable for drilling into masonry", 42.99, "PowerTools"));
        list.add(new Products(1185298, "Stanley Fatmax V20 18V Brushless Hammer Drill", "No memory effect and minimal self-discharge", 129.99, "PowerTools"));
        list.add(new Products(1119995, "Black+Decker 3.6V Lithium Screwdriver", "Lithium-ion battery provides adequate power", 27.99, "PowerTools"));
    }
    public void displayArrayList(List<Products> product) {
        for (Products products : product) {
            System.out.println(products);

        }

    }
    //hashmap
    public void hashMap(Map hash) {
        String name = "paint1";
        Products product = new Products(1196549, "Fleetwood 5L Sheen Warm Grey", "\n" + "Easy Application, Quick Drying, Low Odour, Water Based ", 36.00, "Paint");
        hash.put(name, product);

        String name1 = "paint2";
        product = new Products(1096007, "Fleetwood 2.5 Litre Sheen Smithsonian", "Walls and ceilings, Stains wipe clean, Excellent coverage, Easy to apply", 22.00, "Paint");
        hash.put(name1, product);

        String name2 = "paint3";
        product = new Products(375460, "Dulux Vinyl Soft Sheen Tir na nOg 5L", "Tough washable finish, Fashionable mid-sheen finish, Coverage of up to 16m2", 58.99, "Paint");
        hash.put(name2, product);

        String name3 = "paint4";
        product = new Products(324900, "Dulux Easycare Kitchens Iced White 2.5L", "Stain Resistant, Withstands Scrubbing, Washable", 51.99, "Paint");
        hash.put(name3, product);

        String name4 = "lawnmower1";
        product = new Products(1145539, "Black+Decker 1600W Corded 38CM Electric Lawnmower", "Bike Handle design for improved ergonomics and even weight distribution", 199.99, "GardenTools");
        hash.put(name4, product);

        String name5 = "lawnmower2";
        product = new Products(1156976, "Black+Decker 1000W Corded 32CM Lawnmower", "1000W Mower with 32cm cutting deck, perfect for keeping your garden lawn tidy", 99.99, "GardenTools");
        hash.put(name5, product);

        String name6 = "lawnmower3";
        product = new Products(1201772, "Pro Lawn 46cm Self Propelled B&S Petrol Lawnmower", "Powerful Briggs & Stratton engine delivers effortless mowing", 379.99, "GardenTools");
        hash.put(name6, product);

        String name7 = "drill1";
        product = new Products(1156605, "Black+Decker 500W Corded Hammer Drill", "Hammer action suitable for drilling into masonry", 42.99, "PowerTools");
        hash.put(name7, product);

        String name8 = "drill2";
        product = new Products(1185298, "Stanley Fatmax V20 18V Brushless Hammer Drill", "No memory effect and minimal self-discharge", 129.99, "PowerTools");
        hash.put(name8, product);

        String name9 = "drill3";
        product = new Products(1119995, "Black+Decker 3.6V Lithium Screwdriver", "Lithium-ion battery provides adequate power", 27.99, "PowerTools");
        hash.put(name9, product);
    }
    //treeMap
    public void treeMap(Map tree) {

        tree.put("SoftSheen5L", new Products(1196549, "Fleetwood 5L Sheen Warm Grey", "Easy Application, Quick Drying, Low Odour, Water Based ", 36.00, "Paint"));
        tree.put("SoftSheen2.5L", new Products(1096007, "Fleetwood 2.5 Litre Sheen Smithsonian", "Walls and ceilings, Stains wipe clean, Excellent coverage, Easy to apply", 22.00, "Paint"));
        tree.put("Dulux5L", new Products(375460, "Dulux Vinyl Soft Sheen Tir na nOg 5L", "Tough washable finish, Fashionable mid-sheen finish, Coverage of up to 16m2", 58.99, "Paint"));
        tree.put("Dulux2.5L", new Products(324900, "Dulux Easycare Kitchens Iced White 2.5L", "Stain Resistant, Withstands Scrubbing, Washable", 51.99, "Paint"));
        tree.put("BD1600w", new Products(1145539, "Black+Decker 1600W Corded 38CM Electric Lawnmower", "Bike Handle design for improved ergonomics and even weight distribution", 199.99, "GardenTools"));
        tree.put("BD1000w", new Products(1156976, "Black+Decker 1000W Corded 32CM Lawnmower", "1000W Mower with 32cm cutting deck, perfect for keeping your garden lawn tidy", 99.99, "GardenTools"));
        tree.put("ProLawn", new Products(1201772, "Pro Lawn 46cm Self Propelled B&S Petrol Lawnmower", "Powerful Briggs & Stratton engine delivers effortless mowing", 379.99, "GardenTools"));
        tree.put("BD500Drill", new Products(1156605, "Black+Decker 500W Corded Hammer Drill", "Hammer action suitable for drilling into masonry", 42.99, "PowerTools"));
        tree.put("StanleyDrill", new Products(1185298, "Stanley Fatmax V20 18V Brushless Hammer Drill", "No memory effect and minimal self-discharge", 129.99, "PowerTools"));
        tree.put("BDScrewDriver", new Products(1119995, "Black+Decker 3.6V Lithium Screwdriver", "Lithium-ion battery provides adequate power", 27.99, "PowerTools"));

        System.out.print(tree);


    }
    //priorityQueue
    public void priorityQueue(Queue queue)
    {
        queue.add(new Products(1196549, "Fleetwood 5L Sheen Warm Grey", "Easy Application, Quick Drying, Low Odour, Water Based ", 36.00, "Paint"));
        queue.add(new Products(1096007, "Fleetwood 2.5 Litre Sheen Smithsonian", "Walls and ceilings, Stains wipe clean, Excellent coverage, Easy to apply", 22.00, "Paint"));
        queue.add(new Products(375460, "Dulux Vinyl Soft Sheen Tir na nOg 5L", "Tough washable finish, Fashionable mid-sheen finish, Coverage of up to 16m2", 58.99, "Paint"));
        queue.add(new Products(324900, "Dulux Easycare Kitchens Iced White 2.5L", "Stain Resistant, Withstands Scrubbing, Washable", 51.99, "Paint"));
        queue.add(new Products(1145539, "Black+Decker 1600W Corded 38CM Electric Lawnmower", "Bike Handle design for improved ergonomics and even weight distribution", 199.99, "GardenTools"));
        queue.add(new Products(1156976, "Black+Decker 1000W Corded 32CM Lawnmower", "1000W Mower with 32cm cutting deck, perfect for keeping your garden lawn tidy", 99.99, "GardenTools"));
        queue.add(new Products(1201772, "Pro Lawn 46cm Self Propelled B&S Petrol Lawnmower", "Powerful Briggs & Stratton engine delivers effortless mowing", 379.99, "GardenTools"));
        queue.add(new Products(1156605, "Black+Decker 500W Corded Hammer Drill", "Hammer action suitable for drilling into masonry", 42.99, "PowerTools"));
        queue.add(new Products(1185298, "Stanley Fatmax V20 18V Brushless Hammer Drill", "No memory effect and minimal self-discharge", 129.99, "PowerTools"));
        queue.add(new Products(1119995, "Black+Decker 3.6V Lithium Screwdriver", "Lithium-ion battery provides adequate power", 27.99, "PowerTools"));
    }
    public static void displayQueue(Queue<Products> products)
    {
        for (Products e: products) { System.out.println(e); }
    }

    public static void mySql() throws DaoException {
        ProductDaoInterface IUserDao = new MySqlProductDao();
        try {
            System.out.println("\nCall findAllProducts()");
            List<Products> products = IUserDao.findAllProducts();

            if (products.isEmpty())
                System.out.println("There are no products");
            else {
                for (Products p : products)
                    System.out.println("Products: " + p.toString());
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    public static void findByIdMySQL()throws DaoException{
        ProductDaoInterface IUserDao = new MySqlProductDao();
        Scanner k = new Scanner(System.in);
        try {
            System.out.println("\nCall: findPlayerByID()");
            System.out.println("Enter ID You Wish To Find: ");
            int SORT_CODE = k.nextInt();
            Products products = IUserDao.findProductsByID(SORT_CODE);

            if (products != null)
                System.out.println("Player found: " + products);
            else
                System.out.println("Player with that ID not found");

        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
    public static void deleteProductSQL()throws DaoException{
        ProductDaoInterface IUserDao = new MySqlProductDao();
        Scanner k = new Scanner(System.in);
        System.out.println("Select player by ID to delete: ");
        int id = k.nextInt();
        System.out.println("You Chose to Delete");
        System.out.println(IUserDao.findProductsByID(id));
        IUserDao.DeleteProductByID(id);
    }
    public static void addProduct()throws DaoException{
        ProductDaoInterface IUserDao = new MySqlProductDao();
        Scanner k = new Scanner(System.in);
        int sort_code = 0;
        System.out.println("Enter Name of Product");
        String product_name = k.nextLine();
        System.out.println("Enter Description of Product");
        String product_desc = k.nextLine();
        System.out.println("Enter Price of Product");
        Double productPrice = k.nextDouble();
        System.out.println("Enter Type of Product");
        String bug = k.nextLine();
        String productType =k.nextLine();
        IUserDao.addProduct(sort_code,product_name,product_desc,productPrice,productType);
    }

    public static void filterMySQL() throws DaoException {
        Scanner k = new Scanner(System.in);
        ProductDaoInterface IUserDao = new MySqlProductDao();
        System.out.print("Enter Trophy amount: ");
        List<Products> products = IUserDao.findAllProducts();
        int trophies = k.nextInt();
        k.nextLine();
        ProductComparator productComparator = new ProductComparator();
        products = IUserDao.filterMySQL(trophies,productComparator);
        System.out.println("Players with " + trophies + "+ trophies");
        for (Products p : products) {
            System.out.println(p.toString());
        }
    }
    public static void jsonString()throws DaoException{
        ProductDaoInterface IUserDao = new MySqlProductDao();
        try {
            System.out.println("\nCall findAllPlayers()");
            String players = IUserDao.findAllProductsJson();
            if (players.isEmpty())
                System.out.println("There are no Players");
            else {
                System.out.println(players);
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
    public static void findByIDGson() throws DaoException {
        ProductDaoInterface IUserDao = new MySqlProductDao();
        Scanner k = new Scanner(System.in);
        try {
            System.out.println("\nCall: findPlayerByID()");
            System.out.println("Enter ID You Wish To Find: ");
            int sort_code = k.nextInt();
            String products = IUserDao.findProductsByIDGson(sort_code);

            if (products != null)
                System.out.println("Player found: " + products);
            else
                System.out.println("Player with that ID not found");

        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
    private void displayBarMenu() {
        final String MENU_ITEMS = "\n*** Woodies DIY ***\n"
                + "1. Display all elements\n"
                + "2. Retrieve an object by key(Hash)\n"
                + "3. Display objects from TreeMap\n"
                + "4. PriorityQueue Sequence Simulation\n"
                + "5. “PriorityQueue Two-Field Comparison\n"
                + "6. Find all Entities\n"
                + "7. Find and display an Entity by key\n"
                + "8. Delete an entity by key\n"
                + "9. Insert an entity\n"
                + "10. List entities using a filter\n"
                + "11. Retrieve all Entities as JSON String\n"
                + "12. Find an Entity by Key as JSON String\n"
                + "13. Exit\n"
                + "Enter Option [1,13]";

        final int arrayList = 1;
        final int hashMap = 2;
        final int treeMap = 3;
        final int priorityQueue=4;
        final int twoPriorityQueue=5;
        final int mySQL=6;
        final int findByIDSQL=7;
        final int deleteByIDSQL=8;
        final int insertSQL=9;
        final int filterSQL=10;
        final int findAllGson=11;
        final int findByIDGson=12;
        final int EXIT = 13;

        Scanner keyboard = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("\n" + MENU_ITEMS);
            try {


                String usersInput = keyboard.nextLine();
                option = Integer.parseInt(usersInput);


                switch (option) {
                    case arrayList:
                        ArrayList<Products> product = new ArrayList();
                        arrayList(product);
                        displayArrayList(product);
                        break;
                    case hashMap:
                        Map<String, Products> hash = new HashMap();
                        hashMap(hash);
                        System.out.println("please enter your key");
                        String key = keyboard.nextLine();
                        Products products = hash.get(key.toLowerCase(Locale.ROOT));
                        System.out.println(key + " DTOs.Products Hashed= " + products);
                        break;
                    case treeMap:
                        Map<String, Products> tree = new TreeMap();
                        treeMap(tree);
                        break;
                    case priorityQueue:
                        Queue<Products> queue = new PriorityQueue<Products>( new ProductComparator());
                        priorityQueue(queue);
                        displayQueue(queue);
                        break;
                    case twoPriorityQueue:
                        Queue<Products> queue1 = new PriorityQueue<Products>( new twoProductComparator(SortType.Ascending));
                        priorityQueue(queue1);
                        displayQueue(queue1);
                        break;
                    case mySQL:
                        mySql();
                        break;
                    case findByIDSQL:
                        findByIdMySQL();
                        break;
                    case deleteByIDSQL:
                        deleteProductSQL();
                        break;
                    case insertSQL:
                        addProduct();
                        break;
                    case filterSQL:
                        filterMySQL();
                        break;
                    case findAllGson:
                       jsonString();
                        break;
                    case findByIDGson:
                        findByIDGson();
                        break;
                    case EXIT:
                        System.out.println("Exit Menu option chosen");
                        break;
                    default:
                        System.out.print("Invalid option - please enter number in range");
                        break;

                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.print("Invalid option - please enter number in range");
            } catch (DaoException e) {
                throw new RuntimeException(e);
            }
        } while (option != EXIT);
    }
}
