package org.dev.scheduler;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DelayQueueWorker implements Runnable {

    private final DelayQueue<DelayedJob> delayedJobs;
    private final ExecutorService executorService = Executors.newFixedThreadPool(20);

    public DelayQueueWorker(DelayQueue<DelayedJob> delayedJobs) {
        this.delayedJobs = delayedJobs;
    }

    @Override
    public void run() {
        while (true) {
            try {
                DelayedJob delayedJob = delayedJobs.take();
                executorService.submit(delayedJob.getScheduledJob().getJob()::run);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
