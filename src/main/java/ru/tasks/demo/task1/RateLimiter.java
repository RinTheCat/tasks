package ru.tasks.demo.task1;

/**
 * Написать RateLimiter, который будет выдавать информацию о тех,
 * кто превысил лимит (+ чтобы амортизированная асимптотика была околоконстантной)
 */
public interface RateLimiter {

    boolean createNewTask(String task1, double permitsPerSec);

    boolean register(String taskId);

}
