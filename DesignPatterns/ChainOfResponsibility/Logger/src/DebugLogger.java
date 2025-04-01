
import java.util.ArrayList;
import java.util.List;

public class DebugLogger extends AbstractLogger {

    public DebugLogger(int level){
        this.level = level;
    }
    @Override
    protected void display(String msg) {
        System.out.println("DEBUG: " + msg);
    }
}
