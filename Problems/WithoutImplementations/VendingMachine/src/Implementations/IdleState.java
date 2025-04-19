package Implementations;

import Enums.Coin;
import Enums.Note;
import Interfaces.IProduct;
import Interfaces.IState;

public class IdleState implements IState {
    @Override
    public void selectProduct(IProduct product) {
        //yes
    }

    @Override
    public void insertCoin(Coin coin) {
        //no
    }

    @Override
    public void insertNote(Note note) {
        //no
    }

    @Override
    public void dispach() {
        //no
    }
}
