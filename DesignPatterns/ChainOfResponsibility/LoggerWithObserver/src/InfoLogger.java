import Interfaces.ObserverInterface;

import java.util.ArrayList;
import java.util.List;

public class InfoLogger extends AbstractLogger {
    private List<ObserverInterface> observerList;


    public InfoLogger(int level){
        this.level = level;
        observerList = new ArrayList<ObserverInterface>();
    }
    @Override
    protected void display(String msg) {
//        System.out.println("INFO: " + msg);
        msg += ": INFO";
        notifyAllObservers(msg);
    }

    @Override
    public void addObserver(ObserverInterface observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(ObserverInterface observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyAllObservers(String msg) {
        for (ObserverInterface observer: observerList){
            observer.update(msg);
        }
    }
}
