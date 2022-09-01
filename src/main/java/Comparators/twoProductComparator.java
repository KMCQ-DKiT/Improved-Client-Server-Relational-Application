package Comparators;

import DTOs.Products;

import java.util.Comparator;

public class twoProductComparator implements Comparator<Products> {

    private SortType sortType;

    public twoProductComparator(SortType sortType)
    {
        this.sortType = sortType;
    }
    @Override
    public int compare(Products p1, Products p2)
    {
        boolean nameAlphabeticalEqual =
                p1.getProductName().equalsIgnoreCase(p2.getProductName());


        if(nameAlphabeticalEqual == true)
        {
            return (p1.getSortCode() - p2.getSortCode()) * -1;
        }
        else
        {
            return p1.getProductName().compareToIgnoreCase(p2.getProductName());
        }
    }
}