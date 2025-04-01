
public abstract class AbstractLogger {
    protected int level;
    AbstractLogger nextLoggingLevel;

    public void setNextLoggingLevel(AbstractLogger abstractLogger){
        nextLoggingLevel = abstractLogger;
    }

    void logMessage(int level, String msg){
        if(this.level <= level){
            display(msg);
        }
        if(nextLoggingLevel != null){
            nextLoggingLevel.logMessage(level,msg);
        }
    }

    protected abstract void display(String msg);

}
