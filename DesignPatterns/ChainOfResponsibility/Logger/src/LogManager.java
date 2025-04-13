

public class LogManager {
    private static AbstractLogger infoLogger;
    private static AbstractLogger debugLogger;
    private static AbstractLogger errorLogger;


    protected static AbstractLogger buildChainOfLogger(){
        infoLogger = new InfoLogger(1);
        debugLogger = new DebugLogger(2);
        errorLogger = new ErrorLogger(3);

        infoLogger.setNextLoggingLevel(debugLogger);
        debugLogger.setNextLoggingLevel(errorLogger);

        return infoLogger;
    }
}
