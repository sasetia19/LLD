package Implementations;

import Interfaces.IProduct;

public class Product implements IProduct {
    String name;
    Integer id;

    public Product(String name, Integer id){
        this.name = name;
        this.id = id;
    }
}
