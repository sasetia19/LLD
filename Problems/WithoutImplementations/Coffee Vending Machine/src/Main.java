//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        /*
        ICoffee -> getCost(), getIngredients
        espresso, cappuccino, and latte -> Map<String,Integer> recipe (ingredients and their quantities)

        ICoffeeMachine -> getAvailableCoffee(),checkIngredientsAvailability(), getInstance()
        selectCoffee(ICoffee){currState.selectCoffee(ICoffee)}, makePayment(Integer), dispenseCoffee(),
        setState(IState)
        CoffeeMachine -> IState, List<ICoffee>, Map<String,Integer> availableIngredients, ICoffee currSelectedCoffee

        IState -> (keep CoffeeMachine in every implementation)
        IdleState -> selectCoffee(),
        PaymentState -> makePayment(),
        DispenseState -> dispenseCoffee(), returnChange()


        Main

        ICoffeeMachine coffeeMachine = CoffeeMachine.getInstance();
        //Show options
        coffeeMachine.getAvailableCoffee();

        //select coffee
        coffeeMachine.selectCoffee(new Cappucino());
        coffeeMachine.makePayment(25);
        coffeeMachine.dispenseCoffee();

         */
        /*
        DP
        singleton
        Coffee Factory
        State Pattern
         */
    }
}