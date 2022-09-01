package DTOs;

import java.util.Objects;

public class Products {

    int sortCode;
    String productName;
    String productDescription;
    double productPrice;
    String productType;


    public Products(int sortCode, String productName, String productDescription, double productPrice, String productType) {
        this.sortCode = sortCode;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productType = productType;
    }
    public Products(String productName, String productDescription, double productPrice, String productType) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productType = productType;
    }

    public int getSortCode() {
        return sortCode;
    }

    public void setSortCode(int sortCode) {
        this.sortCode = sortCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    @Override
    public String toString() {
        return "Products{" +
                "sortCode=" + sortCode +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productPrice=" + productPrice +
                ", productType='" + productType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Products)) return false;
        Products products = (Products) o;
        return sortCode == products.sortCode && Double.compare(products.productPrice, productPrice) == 0 && Objects.equals(productName, products.productName) && Objects.equals(productDescription, products.productDescription) && Objects.equals(productType, products.productType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sortCode, productName, productDescription, productPrice, productType);
    }
}


