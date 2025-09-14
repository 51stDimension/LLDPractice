package org.dev.logger.models;

import lombok.Value;
import org.dev.logger.logappender.LogAppender;

@Value
public class LogConfig {
    //Not used now
    LogLevel logLevel;
    LogAppender logAppender;
}
