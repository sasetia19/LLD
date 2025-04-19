package Implementations;

import Enums.Coin;
import Enums.Note;
import Interfaces.*;

public class VendingMachineService implements IVendingMachineService {

    IInventory inventory;
    IState state;

    public VendingMachineService(){
        state = new IdleState();
    }


    @Override
    public void selectProduct(IProduct product) {

    }

    @Override
    public void dispenseProduct(IProduct product) {

    }

    @Override
    public void reset() {

    }

    @Override
    public void addCoin(Coin coin, IUser user) {
        //if admin change state to admin state
    }

    @Override
    public void addNote(Note note, IUser user) {

    }

    @Override
    public void addProduct(IProduct product, Integer quantity, IUser user) {

    }
}
