package ru.tasks.demo.task1;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RateLimiterImpl implements RateLimiter {

    private final Map<String, RateLimiterTask> tasks = new ConcurrentHashMap<>();

    private static class RateLimiterTask {
        private final double permitsPerSec;
        private long lastProcessedTime;

        public RateLimiterTask(double permitsPerSec) {
            this.permitsPerSec = permitsPerSec;
            this.lastProcessedTime = System.currentTimeMillis();
        }
    }

    @Override
    public boolean createNewTask(String task1, double permitsPerSec) {
        if (permitsPerSec <= 0) return false;
        tasks.put(task1, new RateLimiterTask(permitsPerSec));
        return true;
    }

    @Override
    public boolean register(String taskId) {
        final long currentTime = System.currentTimeMillis();
        final RateLimiterTask task = tasks.get(taskId);
        if (task == null) return false;

        synchronized (task) {
            if (currentTime - task.lastProcessedTime > 1000L / task.permitsPerSec) {
                task.lastProcessedTime = currentTime;
                return true;
            }
        }
        System.out.println("RateLimiter exceeded");
        return false;
    }
}
