import ObserverSinkClasses.ConsoleObserver;
import ObserverSinkClasses.FileObserver;

public class LogManager {
    private static AbstractLogger infoLogger;
    private static AbstractLogger debugLogger;
    private static AbstractLogger errorLogger;

    public static void subscribe(){


        ConsoleObserver consoleObserver = new ConsoleObserver();
        FileObserver fileObserver = new FileObserver();

        infoLogger.addObserver(consoleObserver);
        errorLogger.addObserver(consoleObserver);
        errorLogger.addObserver(fileObserver);
    }

    protected static AbstractLogger buildChainOfLogger(){
        infoLogger = new InfoLogger(1);
        debugLogger = new DebugLogger(2);
        errorLogger = new ErrorLogger(3);

        infoLogger.setNextLoggingLevel(debugLogger);
        debugLogger.setNextLoggingLevel(errorLogger);

        return infoLogger;
    }
}
