package ObserverSinkClasses;

import Interfaces.ObserverInterface;

public class ConsoleObserver implements ObserverInterface {
    @Override
    public void update(String msg) {
        writeToConsole(msg);
    }

    private void writeToConsole(String msg){
        System.out.println("Writing to Console: "+ msg);
    }
}
