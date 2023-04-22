package v22_chain_of_responsibility.java;

abstract class Logger {

    protected int level;
    protected Logger nextLogger;

    public void setNextLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(int logLevel, String message) {
        if (logLevel <= level) {
            write(message);
        } else if (nextLogger != null) {
            nextLogger.logMessage(logLevel, message);
        }
    }

    abstract protected void write(String message);
}

class ErrorLogger extends Logger {
    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error: " + message);
    }
}

class DebugLogger extends Logger {
    public DebugLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Debug: " + message);
    }
}

class InfoLogger extends Logger {
    public InfoLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Info: " + message);
    }
}

public class LoggerDemo2 {
    public static void main(String[] args) {
        ErrorLogger errorLogger = new ErrorLogger(1);
        DebugLogger debugLogger = new DebugLogger(2);
        InfoLogger infoLogger = new InfoLogger(3);

        errorLogger.setNextLogger(debugLogger);
        debugLogger.setNextLogger(infoLogger);

        errorLogger.logMessage(1, "This is an error message");
        errorLogger.logMessage(2, "This is a debug message");
        errorLogger.logMessage(3, "This is an info message");
    }
}





