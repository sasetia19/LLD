public interface InventoryObservable {
    public void addObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyAllObservers();
    public void setValue(int value);
    public int getValue();
}
