
import java.util.ArrayList;
import java.util.List;

public class InfoLogger extends AbstractLogger {


    public InfoLogger(int level){
        this.level = level;
    }
    @Override
    protected void display(String msg) {
        System.out.println("INFO: " + msg);

    }
}
