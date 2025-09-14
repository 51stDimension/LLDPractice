package org.dev.logger.models;

import java.util.Date;
import java.util.Map;

public class LogMessage {

    private final Date date;
    private final LogLevel logLevel;
    private final String message;
    private final Map<String, Object> context;

    public LogMessage(LogLevel logLevel, String message, Map<String, Object> context) {
        this.date = new Date();
        this.logLevel = logLevel;
        this.message = message;
        this.context = context;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(logLevel);
        sb.append(message);
        //add more context here later
        return sb.toString();
    }
}
