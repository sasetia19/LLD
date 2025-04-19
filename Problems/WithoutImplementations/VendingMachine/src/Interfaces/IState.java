package Interfaces;

import Enums.Coin;
import Enums.Note;

public interface IState {
    //selectProduct(Product),insertCoin(Coin),insertNote(Note),dispach()
    public void selectProduct(IProduct product);
    public void insertCoin(Coin coin);
    public void insertNote(Note note);
    public void dispach();
}
