package org.dev.scheduler;

import lombok.Data;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

@Data
public class DelayedJob implements Delayed {

    private final ScheduledJob scheduledJob;

    public DelayedJob(ScheduledJob scheduledJob) {
        this.scheduledJob = scheduledJob;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(scheduledJob.startTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return Long.compare(this.getDelay(TimeUnit.MILLISECONDS), o.getDelay(TimeUnit.MILLISECONDS));
    }
}
