package ru.tasks.demo.task1;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RateLimiterImpl implements RateLimiter {

    private final Map<String, double[]> tasks = new ConcurrentHashMap<>();

    @Override
    public boolean createNewTask(String task1, double permitsPerSec) {
        if (permitsPerSec <= 0) return false;
        tasks.put(task1, new double[] {permitsPerSec, 0});
        return true;
    }

    @Override
    public boolean register(String taskId) {
        final long currentTime = System.currentTimeMillis();
        final double[] result = tasks.computeIfPresent(taskId, (k, v) -> {
            double permitsPerSec = v[0];
            double lastProcessed = v[1];
            if (currentTime - lastProcessed > permitsPerSec * 1000) {
                return new double[] {permitsPerSec, currentTime};
            } else {
                System.out.println("RateLimiter exceeded");
                return v;
            }
        });
        return result != null && result[1] != currentTime;
    }
}
