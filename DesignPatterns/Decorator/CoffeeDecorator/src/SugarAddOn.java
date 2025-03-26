public class SugarAddOn implements IAddOns{
    private ICoffee coffee;

    public SugarAddOn(ICoffee coffee){
        this.coffee = coffee;
    }
    @Override
    public int calculateCost() {
        System.out.println("Extra sugar added for 10");
        return coffee.calculateCost() + 10;
    }
}
