package org.dev.logger;

import lombok.extern.java.Log;
import org.dev.logger.logappender.LogAppender;
import org.dev.logger.models.LogLevel;
import org.dev.logger.models.LogMessage;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultLogger extends Logger{

    private static final ConcurrentHashMap<String, DefaultLogger> loggerInstances = new ConcurrentHashMap<>();

    private DefaultLogger(LogLevel logLevel, LogAppender logAppender) {
        super(logLevel, logAppender);
    }

    public static DefaultLogger getInstance(LogLevel logLevel, LogAppender logAppender){
        String key = logLevel.name() + "_" + logAppender.getClass().getName();
        return loggerInstances.computeIfAbsent(key, k -> new DefaultLogger(logLevel, logAppender));
    }

    private boolean log(String message, LogLevel logLevel){
        LogMessage logMessage = new LogMessage(logLevel, message, new HashMap<>());
        if(getLogLevel().getLevel()<=logLevel.getLevel()){
            return getLogAppender().appendLog(logMessage);
        }
        return false;
    }

    @Override
    boolean error(String message) {
        return log(message, LogLevel.ERROR);
    }

    @Override
    boolean debug(String message) {
        return log(message, LogLevel.DEBUG);
    }

    @Override
    boolean info(String message) {
        return log(message, LogLevel.INFO);
    }
}
