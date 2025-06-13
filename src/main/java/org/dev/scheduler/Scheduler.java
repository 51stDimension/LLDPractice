package org.dev.scheduler;

import java.sql.Time;
import java.util.UUID;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Scheduler {

    private final TimeWheel secondBasedTimeWheel;
    private final TimeWheel minuteBasedTimeWheel;
    private final TimeWheel hourBasedTimeWheel;
    private final TimeWheel dayBasedTimeWheel;
    private final DelayQueue<DelayedJob> delayedJobs = new DelayQueue<>();

    public Scheduler(TimeWheel secondBasedTimeWheel, TimeWheel minuteBasedTimeWheel, TimeWheel hourBasedTimeWheel, TimeWheel dayBasedTimeWheel) {

        this.secondBasedTimeWheel = new TimeWheel(1000L, 60, null);
        this.minuteBasedTimeWheel = new TimeWheel(60000L, 60, secondBasedTimeWheel);
        this.hourBasedTimeWheel = new TimeWheel(3600000L, 24, minuteBasedTimeWheel);
        this.dayBasedTimeWheel = new TimeWheel(86400000L, 31, dayBasedTimeWheel);

        new Thread(new DelayQueueWorker(delayedJobs)).start();
        startTicker();
    }

    public boolean scheduleJob(Job job, JobRecurrenceRequest jobRecurrenceRequest) {
        ScheduledJob scheduledJob = ScheduledJob.builder()
                .jobId(UUID.randomUUID().toString())
                .jobType(jobRecurrenceRequest.getJobType())
                .recurringInterval(jobRecurrenceRequest.getRecurringInterval())
                .startTime(jobRecurrenceRequest.getStartTimeInMillis())
                .job(job)
                .build();
        dayBasedTimeWheel.scheduleJob(scheduledJob);

        return true;
    }

    private void startTicker() {
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(secondBasedTimeWheel::advanceClock, 0, 1, TimeUnit.SECONDS);
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(minuteBasedTimeWheel::advanceClock, 0, 1, TimeUnit.MINUTES);
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(hourBasedTimeWheel::advanceClock, 0, 1, TimeUnit.HOURS);
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(dayBasedTimeWheel::advanceClock, 0, 1, TimeUnit.DAYS);
    }
}
