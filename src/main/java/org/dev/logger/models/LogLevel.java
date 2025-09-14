package org.dev.logger.models;

import lombok.Getter;

@Getter
public enum LogLevel {
    DEBUG(0),
    INFO(1),
    WARN(2),
    ERROR(3),
    FATAL(4);

    private final int level;

    LogLevel(int level) {
        this.level = level;
    }

}
