package Interfaces;

import Enums.Coin;
import Enums.Note;
import Implementations.Product;

public interface IVendingMachineService {
    public void selectProduct(IProduct product);
    public void dispenseProduct(IProduct product);
    public void reset();
    public void addCoin(Coin coin, IUser user);
    public void addNote(Note note, IUser user);
    public void addProduct(IProduct product,Integer quantity, IUser user);
}
