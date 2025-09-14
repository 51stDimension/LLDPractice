package org.dev.logger.logappender;

import org.dev.logger.models.LogMessage;

public class ConsoleAppender implements LogAppender{

    @Override
    public boolean appendLog(LogMessage logMessage) {
        System.out.println(logMessage.toString());
        return true;
    }
}
