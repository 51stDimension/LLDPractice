package org.dev.logger;


import lombok.Getter;
import org.dev.logger.logappender.LogAppender;
import org.dev.logger.models.LogLevel;
import org.dev.logger.models.LogMessage;

@Getter
public abstract class Logger {

    //Both of these can be merged to a LogConfig
    private final LogLevel logLevel;
    private final LogAppender logAppender;

    protected Logger(LogLevel logLevel, LogAppender logAppender) {
        this.logLevel = logLevel;
        this.logAppender = logAppender;
    }

    abstract boolean error(String logMessage);

    abstract boolean debug(String logMessage);

    abstract boolean info(String logMessage);
}
