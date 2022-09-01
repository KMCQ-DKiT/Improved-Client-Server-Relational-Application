package DAOs;

import Comparators.ProductComparator;
import DTOs.Products;
import Exceptions.DaoException;

import java.util.List;

public interface ProductDaoInterface {
    public List<Products> findAllProducts() throws DaoException;
    public Products findProductsByID(int SORT_CODE) throws DaoException;
    public Products DeleteProductByID(int SORT_CODE) throws DaoException;
    public void addProduct(int sort_code ,String product_name, String product_desc,double productPrice, String productType) throws DaoException;

    public List<Products> filterMySQL(int g, ProductComparator productComparator) throws DaoException;

    public String findAllProductsJson() throws DaoException;
    public String findProductsByIDGson(int sort_code) throws DaoException;
}
