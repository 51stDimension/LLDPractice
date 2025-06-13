package org.dev.scheduler;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JobRecurrenceRequest {

    private JobType jobType;

    private long startTimeInMillis;

    private long recurringInterval;
}
