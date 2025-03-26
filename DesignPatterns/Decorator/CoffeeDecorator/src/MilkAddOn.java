public class MilkAddOn implements IAddOns{
    private ICoffee coffee;
    public MilkAddOn(ICoffee coffee){
        this.coffee = coffee;
    }
    @Override
    public int calculateCost() {
        System.out.println("Extra milk added for 50");
        return coffee.calculateCost() + 50;
    }
}
