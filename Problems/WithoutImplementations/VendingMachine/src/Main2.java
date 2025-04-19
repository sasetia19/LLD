public class Main2 {
    public static void main(String[] args) {
        /*
        Reference good designs
        https://github.com/ashishps1/awesome-low-level-design/blob/main/solutions/java/src/vendingmachine/Inventory.java
        https://medium.com/swlh/vending-machine-design-a-state-design-pattern-approach-5b7e1a026cd2
         */
        /*
        //Vending Machine with State Pattern

        VendingMachineService
        IState state, Inventory inventory
        selectProduct(), dispenseProduct(),reset()
        addCoin(),addNote(),addProduct() -> check if admin user or normal
        (if admin first change the state to admin then work)
        make all these methods synchronized

        Inventory
        Map<Product,Integer(quantity)>


        Product
        String name, Integer price


        IState interface -> selectProduct(Product),insertCoin(Coin),insertNote(Note),dispach()
        Idle State -> selectProduct
        Ready State -> insertCoin
        Dispaching State -> dispense and return change
        Admin State -> to avoid usage of vending machine when admin methods are working
                    addProduct(Product,int quantity),addCoin(Coin),addNote(Note)

        IUser interface
        NormalUser
        AdminUser

        UserFactory

        Enum Coin
        Enum Note

        DP
        Factory pattern on User object
        Singleton on Inventory, VMService, VMManager

        synchronization in addProduct(VMManager), selectProduct
         */
    }
}
