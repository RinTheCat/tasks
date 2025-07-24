package ru.tasks.demo.task9;

import java.util.HashMap;
import java.util.Map;

public class MySemaphore {

    private volatile int permits;

    private final Map<Thread, Integer> threadHoldCounts = new HashMap<>();

    public MySemaphore(int permits) {
        this.permits = permits;
    }

    public synchronized void acquire() throws InterruptedException {
        final Thread current = Thread.currentThread();
        if (threadHoldCounts.containsKey(current)) {
            threadHoldCounts.put(current, threadHoldCounts.get(current) + 1);
            return;
        }
        while (permits < 1) {
            wait();
        }
        permits--;
        threadHoldCounts.put(current, 1);
    }

    public synchronized void release() {
        final Integer currentCount = threadHoldCounts.get(Thread.currentThread());
        if (currentCount != null) {
            if (currentCount > 1) {
                threadHoldCounts.put(Thread.currentThread(), currentCount - 1);
            } else {
                threadHoldCounts.remove(Thread.currentThread());
                permits++;
                this.notify();
            }
        } else {
            throw new IllegalStateException("Thread hasn't acquired lock");
        }
    }

}
