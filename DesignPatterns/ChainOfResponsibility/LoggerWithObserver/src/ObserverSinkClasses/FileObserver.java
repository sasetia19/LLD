package ObserverSinkClasses;

import Interfaces.ObserverInterface;

public class FileObserver implements ObserverInterface {
    @Override
    public void update(String msg) {
        writeToFile(msg);
    }
    private void writeToFile(String msg){
        System.out.println("Writing to file: "+ msg);
    }
}
