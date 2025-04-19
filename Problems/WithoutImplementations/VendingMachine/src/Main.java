//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        /*
        Vending machine (DAO)
        Map<Product,Quantity(int)> listOfProducts
        List<Money>

        VendingMachineService
        getProduct(Product,List<Money>){return change}
        getPriceOfProduct(Product)
        getInstance() (singleton)

        VendingMachineManager
        addProduct(Product,int quantity),
        hasProduct(Product) (called by getProduct)
        getAvailableProducts();
        getMoney();
        addMoney(money)

        Product
        int price, String name
        getPrice()

        Money
        Coin -> int value
        Notes -> int value


        Main
        //admin work
        Product lays = new Product("lays", 10)
        Product coke = new Product("coke", 35)
        Money 5 = new Coin(5);
        Money 20 = new Coin(20);
        VendingMachineManager vm = VendingMachineManager.getInstance();
        vm.addProduct(lays,2);
        vm.addProduct(coke,1);
        vm.addMoney(5);
        vm.addMoney(20);


        VendingMachineService vs = VendingMachineService.getInstance();
        vs.getProductPrice(coke);
        vs.getProduct(coke,[new Coin(5),new Note(30)]

        DP
        Singleton


         */
        /*
        if you want to have specific values of coins and notes, then declare these as enums and
        keep an attribute value in it -> https://github.com/ashishps1/awesome-low-level-design/tree/main/solutions/java/src/vendingmachine

         */
    }
}