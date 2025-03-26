import java.util.ArrayList;
import java.util.List;

public class PixelObservable implements InventoryObservable{

    private List<Observer> observerList;
    int data;

    public PixelObservable(){
        observerList = new ArrayList<Observer>();
        data=0;
    }
    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyAllObservers() {
        for(Observer observer: observerList){
            observer.update("Pixel 9");
        }
    }

    @Override
    public void setValue(int value) {
        data = value;
        if(data>0)notifyAllObservers();
    }

    @Override
    public int getValue() {
        return data;
    }
}
