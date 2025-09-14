package org.dev.logger.logappender;

import org.dev.logger.models.LogMessage;

public interface LogAppender {
    boolean appendLog(LogMessage logMessage);
}
