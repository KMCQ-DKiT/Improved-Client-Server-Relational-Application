package DAOs;

import Comparators.ProductComparator;
import DTOs.Products;
import Exceptions.DaoException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlProductDao extends MySqlDao implements ProductDaoInterface{


    @Override
    public List<Products> findAllProducts() throws DaoException
    {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<Products> playerList = new ArrayList<>();

        try
        {
            connection = this.getConnection();

            String query = "SELECT * FROM PRODUCTS";
            ps = connection.prepareStatement(query);

            resultSet = ps.executeQuery();
            while (resultSet.next())
            {
                int sortCode = resultSet.getInt("SORT_CODE");
                String productName = resultSet.getString("PRODUCT_NAME");
                String product_desc = resultSet.getString("PRODUCT_DESC");
                double productPrice = resultSet.getDouble("PRODUCT_PRICE");
                String productType = resultSet.getString("PRODUCT_TYPE");
                Products u = new Products(sortCode,productName, product_desc, productPrice, productType);
                playerList.add(u);
            }
        } catch (SQLException e)
        {
            throw new DaoException("findAllProductsResultSet() " + e.getMessage());
        } finally
        {
            try
            {
                if (resultSet != null)
                {
                    resultSet.close();
                }
                if (ps != null)
                {
                    ps.close();
                }
                if (connection != null)
                {
                    freeConnection(connection);
                }
            } catch (SQLException e)
            {
                throw new DaoException("findAllProducts() " + e.getMessage());
            }
        }
        return playerList;
    }

    @Override
    public Products findProductsByID(int userID) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Products products = null;
        try
        {
            connection = this.getConnection();

            String query = "SELECT * FROM PRODUCTS WHERE SORT_CODE = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userID);


            resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
            {
                int sortCode = resultSet.getInt("SORT_CODE");
                String productName = resultSet.getString("PRODUCT_NAME");
                String product_desc = resultSet.getString("PRODUCT_DESC");
                double productPrice = resultSet.getDouble("PRODUCT_PRICE");
                String productType = resultSet.getString("PRODUCT_TYPE");

               products = new Products(sortCode,productName, product_desc, productPrice, productType);
            }
        } catch (SQLException e)
        {
            throw new DaoException("findProductsByID() " + e.getMessage());
        } finally
        {
            try
            {
                if (resultSet != null)
                {
                    resultSet.close();
                }
                if (preparedStatement != null)
                {
                    preparedStatement.close();
                }
                if (connection != null)
                {
                    freeConnection(connection);
                }
            } catch (SQLException e)
            {
                throw new DaoException("findProductsByID() " + e.getMessage());
            }
        }
        return products;

    }

    public Products DeleteProductByID(int userID) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Products products = null;
        try
        {
            connection = this.getConnection();

            String query = "DELETE FROM PRODUCTS WHERE SORT_CODE = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userID);
            preparedStatement.executeUpdate();


        }
        catch (SQLException e)
        {
            throw new DaoException("DeleteProducts() " + e.getMessage());
        } finally
        {
            try
            {
                if (resultSet != null)
                {
                    resultSet.close();
                }
                if (preparedStatement != null)
                {
                    preparedStatement.close();
                }
                if (connection != null)
                {
                    freeConnection(connection);
                }
            } catch (SQLException e)
            {
                throw new DaoException("DeleteProducts() " + e.getMessage());
            }
        }

        return products;
    }




    public void addProduct(int sort_code, String product_name, String product_desc, double productPrice, String productType) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Products products = null;
        try {
            connection = this.getConnection();
            String query = "INSERT INTO PRODUCTS VALUES (null,?, ?, ?,?)";
            preparedStatement = connection.prepareStatement(query);


            System.out.println("Connected to the database");
            System.out.println("Building a PreparedStatement to insert a new row in database.");

            preparedStatement.setString(1, product_name);
            preparedStatement.setString(2, product_desc);
            preparedStatement.setDouble(3, productPrice);
            preparedStatement.setString(4, productType);

            preparedStatement.executeUpdate();

            {
                try {
                    if (resultSet != null) {
                        resultSet.close();
                    }
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                    if (connection != null) {
                        freeConnection(connection);
                    }
                } catch (SQLException e) {
                    throw new DaoException("addProduct() " + e.getMessage());
                }
            }} catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



    @Override
    public List<Products> filterMySQL(int g, ProductComparator productComparator) throws DaoException
    {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<Products> productList = new ArrayList<>();

        try
        {
            connection = this.getConnection();

            String query = "SELECT * FROM PRODUCTS WHERE SORT_CODE > ?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, g);
            resultSet = ps.executeQuery();
            while (resultSet.next())
            {
                int sortCode = resultSet.getInt("SORT_CODE");
                String productName = resultSet.getString("PRODUCT_NAME");
                String product_desc = resultSet.getString("PRODUCT_DESC");
                double productPrice = resultSet.getDouble("PRODUCT_PRICE");
                String productType = resultSet.getString("PRODUCT_TYPE");
                Products p = new Products(sortCode,productName,product_desc,productPrice,productType);
                productList.add(p);
            }
            productList.sort(productComparator);
        } catch (SQLException e)
        {
            throw new DaoException("FilterBySortCode() " + e.getMessage());
        } finally
        {
            try
            {
                if (resultSet != null)
                {
                    resultSet.close();
                }
                if (ps != null)
                {
                    ps.close();
                }
                if (connection != null)
                {
                    freeConnection(connection);
                }
            } catch (SQLException e)
            {
                throw new DaoException("filterBySortCode() " + e.getMessage());
            }
        }
        return productList;     // may be empty
    }
    public String findAllProductsJson() throws DaoException
    {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<Products> productsList = new ArrayList<>();

        try
        {
            connection = this.getConnection();

            String query = "SELECT * FROM PRODUCTS";
            ps = connection.prepareStatement(query);

            resultSet = ps.executeQuery();
            while (resultSet.next())
            {
                int sortCode = resultSet.getInt("SORT_CODE");
                String productName = resultSet.getString("PRODUCT_NAME");
                String product_desc = resultSet.getString("PRODUCT_DESC");
                double productPrice = resultSet.getDouble("PRODUCT_PRICE");
                String productType = resultSet.getString("PRODUCT_TYPE");
                Products p = new Products(sortCode,productName,product_desc,productPrice,productType);
                productsList.add(p);
            }
        } catch (SQLException e)
        {
            throw new DaoException("findAllProductsJsonResultSet() " + e.getMessage());
        } finally
        {
            try
            {
                if (resultSet != null)
                {
                    resultSet.close();
                }
                if (ps != null)
                {
                    ps.close();
                }
                if (connection != null)
                {
                    freeConnection(connection);
                }
            } catch (SQLException e)
            {
                throw new DaoException("findAllProductsJsonResultSet() " + e.getMessage());
            }
        }
//        Gson gsonParser = new Gson();
//        String playerJson=gsonParser.toJson(productsList);


        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        String productsJson=(gson.toJson(productsList));
        return productsJson;
    }

    public String findProductsByIDGson(int sort_code) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Products products = null;
        try
        {
            connection = this.getConnection();

            String query = "SELECT * FROM PRODUCTS WHERE SORT_CODE = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, sort_code);


            resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
            {
                int sortCode = resultSet.getInt("SORT_CODE");
                String productName = resultSet.getString("PRODUCT_NAME");
                String product_desc = resultSet.getString("PRODUCT_DESC");
                double productPrice = resultSet.getDouble("PRODUCT_PRICE");
                String productType = resultSet.getString("PRODUCT_TYPE");

                products = new Products(sortCode,productName, product_desc, productPrice, productType);
            }
        } catch (SQLException e)
        {
            throw new DaoException("findProductByIDGson() " + e.getMessage());
        } finally
        {
            try
            {
                if (resultSet != null)
                {
                    resultSet.close();
                }
                if (preparedStatement != null)
                {
                    preparedStatement.close();
                }
                if (connection != null)
                {
                    freeConnection(connection);
                }
            } catch (SQLException e)
            {
                throw new DaoException("findProductsByID() " + e.getMessage());
            }
        }
//        Gson gsonParser = new Gson();
//        String playerJson=gsonParser.toJson(products);

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        String productsJson=(gson.toJson(products));

        return productsJson;

    }


}
