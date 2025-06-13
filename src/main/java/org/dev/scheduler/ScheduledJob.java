package org.dev.scheduler;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ScheduledJob {

    private String jobId;

    private Job job;

    private JobType jobType;

    long startTime;

    long recurringInterval;
}
