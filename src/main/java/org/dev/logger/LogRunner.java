package org.dev.logger;

import org.dev.logger.logappender.ConsoleAppender;
import org.dev.logger.models.LogLevel;

public class LogRunner {
    public static void main(String[] args) {
        System.out.println("This is the main log runner class!");
        DefaultLogger defaultLogger = DefaultLogger.getInstance(LogLevel.INFO, new ConsoleAppender());
        defaultLogger.info("Hello world");
    }
}
