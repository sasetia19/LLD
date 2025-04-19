import Implementations.TrafficSignalSystem;
import Interfaces.ITrafficSignalSystem;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ITrafficSignalSystem trafficSignalSystem = TrafficSignalSystem.getInstance();

        initialize(trafficSignalSystem);
        //Cannot call non static method from static method, you need to declare initialize as static

        /*
        DP
        1. singleton
        2. State Pattern
        3. Observer can be used
         */

        //some reference
        //https://github.com/ashishps1/awesome-low-level-design/blob/main/solutions/java/src/trafficsignalsystem/TrafficSignalSystemDemo.java



    }

    public static void initialize(ITrafficSignalSystem trafficSignalSystem){

    }
}