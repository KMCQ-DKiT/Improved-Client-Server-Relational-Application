package Comparators;

import DTOs.Products;

import java.util.Comparator;

public class ProductComparator implements Comparator<Products> {
    private SortType sortType;

    public ProductComparator()
    {
        this.sortType = sortType;
    }


    @Override
    public int compare(Products p1, Products p2)
    {
        int direction = sortType.getValue();
        return direction * (p1.getSortCode() - p2.getSortCode());
    }




}
