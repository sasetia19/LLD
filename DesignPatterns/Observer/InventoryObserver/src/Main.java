//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //InventoryNotifySystem

        //Creating Observers (different users who might have opted for email or notification)
        Observer observer1 = new EmailObserver();
        Observer observer2 = new NotificationObserver();

        //create Iphone observable
        InventoryObservable iphoneStock = new IphoneObservable();

        //create Pixel observable
        InventoryObservable pixelStock = new PixelObservable();

        iphoneStock.addObserver(observer1);
        pixelStock.addObserver(observer2);

        System.out.println("Current Stock present "+ iphoneStock.getValue());
        iphoneStock.setValue(10);
        System.out.println("Current Stock present "+ iphoneStock.getValue());

        System.out.println("Current Stock present "+ pixelStock.getValue());
        pixelStock.setValue(1);
        System.out.println("Current Stock present "+ pixelStock.getValue());

    }
}