package helper.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerFactory {
    //TODO Init logger
    // Public method to get initialized reporter
    private static final ThreadLocal<Logger> logger = new ThreadLocal<>();

    public static void initialize(String name) {
        logger.set(LogManager.getLogger(name));
    }

    public static void log(String message) {
        logger.get().info(message);
    }
}
