//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger();

        logger.info("this is info");
//        logger.debug("this is debug");
//        logger.error("this is error");


    }
}


/*

interface -> logger
implementation -> 4 types of loggers (CATEGORY)(info, debug, error, warn)

loggerManager class to perform chaining

Single instance of loggers

Observable -> all 3 types of loggers
Observers -> (SINK)Console output, File output, Database output

 we can also use factory for creating SINk, or abstract factory
 */

// https://youtu.be/RljSBrZeJ3w very good video explaining this problem



/*
Q) why are we not using Factory pattern here to just get objects of different classes?
A) then we will need to maintain 3 diff objects in main method, but here we just have one object
and call same method on that

Q) So do like this, in the Factory class, initialise 3 objects for 3 loggers (get using singleton)
and then return based on factory (input from main class), then it could be called in the same way from main
class as we are doing now. So what is the use of Chain Of Responsibility.
A) The problem this Chain Of Responsibility pattern comes in handy is like when you have to call a method
of one class and then the method of other classes in chain.
For eg in the actual world logger, lets say the flow is like this INFO -> DEBUG -> ERROR (there will be much
more in real world), so the thing is when ERROR is logged, it is logged in INFO, DEBUG and ERROR all 3 places.
when DEBUG is logged it is logged in INFO and DEBUG.
This type of functionality cannot be achieved from Factory pattern as there is no relation or chain between
classes. So Chain Of Responsibility comes in handy here.
Another example is ATM machine, withdrawing some amount, it will first check with 500rs notes, then with
200rs note, then with 100rs note and so on.
So, flow / sequence of this chain is also very important.

 */