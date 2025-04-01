import java.util.ArrayList;
import java.util.List;

public class IphoneObservable implements InventoryObservable {

    private List<Observer> observersList;
    private int data;

    public IphoneObservable(){
        data=0;
        observersList = new ArrayList<Observer>();
    }
    
    @Override
    public void addObserver(Observer observer) {
        observersList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observersList.remove(observer);
    }

    @Override
    public void notifyAllObservers() {
        for (Observer observer: observersList) {
            observer.update("Iphone");
        }
    }

    @Override
    public void setValue(int value) {
        data = value;
        if(data>0){
            notifyAllObservers();
        }
    }

    @Override
    public int getValue() {
        return data;
    }
}
