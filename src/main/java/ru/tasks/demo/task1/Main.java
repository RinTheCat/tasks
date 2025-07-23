package ru.tasks.demo.task1;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final RateLimiter rateLimiter = new RateLimiterImpl();
        rateLimiter.createNewTask("task1", 1);

        // сообщает каждый раз, когда итераця отбракована
        // при 1 permitsPerSec пускает поток каждые 10 итераций (так как спим 100мс)
        for (int i = 0; i < 100; i++) {
            rateLimiter.register("task1");
            Thread.sleep(100);
        }
    }
}
