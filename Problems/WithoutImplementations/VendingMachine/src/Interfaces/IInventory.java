package Interfaces;

public interface IInventory {
    public Boolean hasProduct(IProduct product, Integer quantity);
    public void addProduct(IProduct product, Integer quantity);
    public void getProduct(IProduct product, Integer quantity);

}
