package v22_chain_of_responsibility.java;

class Logger {
    public static final int ERROR = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
    private int level;

    public Logger(int level) {
        this.level = level;
    }

    public void logMessage(int logLevel, String message) {
        if (logLevel == ERROR && logLevel <= level) {
            System.out.println("Error: " + message);
        } else if (logLevel == DEBUG && logLevel <= level) {
            System.out.println("Debug: " + message);
        } else if (logLevel == INFO && logLevel <= level) {
            System.out.println("Info: " + message);
        }
    }
}

public class LoggerDemo1 {
    public static void main(String[] args) {
        Logger logger = new Logger(Logger.INFO);

        logger.logMessage(Logger.ERROR, "This is an error message");
        logger.logMessage(Logger.DEBUG, "This is a debug message");
        logger.logMessage(Logger.INFO, "This is an info message");
    }
}

