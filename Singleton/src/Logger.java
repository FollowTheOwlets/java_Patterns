import java.util.Date;

public class Logger {
    protected int num = 1;
    protected Date date = new Date();
    private static Logger logger;


    private Logger() {
    }

    public static Logger getInstance() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }

    public void log(String msg) {
        System.out.println("[" + date.toString() + "  " + num++ + "] " + msg);
    }
}
