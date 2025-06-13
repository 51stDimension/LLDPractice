package org.dev.scheduler;

import java.util.*;

public class TimeWheel {

    private final List<Set<ScheduledJob>> jobQueue = new ArrayList<>();
    private final Long tickDuration;
    private final int totalSlots;
    private final TimeWheel nextTimeWheel;

    private int currentTick = 0;

    public TimeWheel(Long tickDuration, int totalSlots, TimeWheel timeWheel) {
        this.tickDuration = tickDuration;
        this.totalSlots = totalSlots;
        this.nextTimeWheel = timeWheel;

        for (int i = 0; i < totalSlots; i++) jobQueue.add(new HashSet<>());
    }

    public boolean scheduleJob(ScheduledJob jobScheduleRequest) {

        long milliSecondsDifference = jobScheduleRequest.getStartTime() - System.currentTimeMillis();
        if (milliSecondsDifference < tickDuration) {
            System.out.println("This job is eligible for next time wheel!");
            if (Objects.isNull(nextTimeWheel)) return false;
            return nextTimeWheel.scheduleJob(jobScheduleRequest);
        }

        long numberOfTicketAhead = milliSecondsDifference / tickDuration;
        if (numberOfTicketAhead >= totalSlots) {
            if (Objects.isNull(nextTimeWheel)) return false;
            return nextTimeWheel.scheduleJob(jobScheduleRequest);
        }

        int assignedSlot = (currentTick + 1) % totalSlots;
        jobQueue.get(assignedSlot).add(jobScheduleRequest);
        return true;
    }

    public List<ScheduledJob> advanceClock() {
        List<ScheduledJob> readyJobs = new ArrayList<>();
        Set<ScheduledJob> bucket = jobQueue.get(currentTick);
        for (ScheduledJob job : bucket) {
            if (!addToLowerLevel(job)) {
                readyJobs.add(job);
            }
        }
        bucket.clear();
        currentTick = (currentTick + 1) % totalSlots;
        return readyJobs;
    }

    private boolean addToLowerLevel(ScheduledJob job) {
        return nextTimeWheel != null && nextTimeWheel.scheduleJob(job);
    }
}
