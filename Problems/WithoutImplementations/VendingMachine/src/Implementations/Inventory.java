package Implementations;

import Interfaces.IInventory;
import Interfaces.IProduct;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Inventory implements IInventory {
    Map<IProduct,Integer> products;
    private static IInventory inventory;

    public Inventory(){
        products = new ConcurrentHashMap<IProduct,Integer>();
    }

    public synchronized static IInventory getInstance(){
        //lazy loading
        if(inventory == null){
            inventory = new Inventory();
        }
        return inventory;
    }

    @Override
    public Boolean hasProduct(IProduct product, Integer quantity) {
        return null;
    }

    @Override
    public void addProduct(IProduct product, Integer quantity) {

    }

    @Override
    public void getProduct(IProduct product, Integer quantity) {

    }
}
