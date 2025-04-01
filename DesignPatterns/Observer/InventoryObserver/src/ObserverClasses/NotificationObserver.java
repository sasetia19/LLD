public class NotificationObserver implements Observer{
    @Override
    public void update(String data) {
        sendNotification(data);
    }
    private void sendNotification(String data){
        System.out.println("Push Notification sent as stock for " + data + " is now available");
    }
}
