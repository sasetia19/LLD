public class EspressoCoffee implements ICoffee{
    @Override
    public int calculateCost() {
        System.out.println("Latte coffee price is 250");
        return 250;
    }
}
