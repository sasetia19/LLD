public class EmailObserver implements Observer{
    @Override
    public void update(String data) {
        sendEmail(data);
    }
    private void sendEmail(String data){
        System.out.println("Email sent to notify stock of " + data + " is available");
    }
}
