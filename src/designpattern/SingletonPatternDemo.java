package designpattern;

/*
 * Stellt sicher, dass eine Klasse nur eine Instanz hat und bietet einen globalen Zugriffspunkt darauf.
 * In einem Logging-System wird oft das Singleton-Muster verwendet, um sicherzustellen,
 * dass nur ein Logger existiert, der von verschiedenen Teilen der Anwendung verwendet werden.
 * */
public class SingletonPatternDemo {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("First log message");
        logger2.log("Second log message");

        System.out.println(logger1 == logger2); // true
    }
}

class Logger {
    private static Logger instance;

    private Logger() {
        // Private constructor to prevent instantiation from outside this class
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("Logger: " + message);
    }
}
