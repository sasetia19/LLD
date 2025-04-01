public class Logger {
    private static Logger logger;
    private static AbstractLogger chainOfLogger;

    private Logger(){
        if(logger != null){
            throw new IllegalStateException("Object already created");
        }
    }

    public static synchronized Logger getLogger(){
        if (logger == null){
            logger = new Logger();
            chainOfLogger = LogManager.buildChainOfLogger();
        }
        return logger;
    }

    private void createLog(int level, String msg){
        chainOfLogger.logMessage(level,msg);
    }

    public void info(String msg){
        createLog(1,msg);
    }
    public void debug(String msg){
        createLog(2,msg);
    }
    public void error(String msg){
        createLog(3,msg);
    }

    
}
