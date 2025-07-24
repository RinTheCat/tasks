package ru.tasks.demo.task9;

/**
 * Условие:
 * Реализуйте класс MySemaphore, который имитирует работу стандартного java.util.concurrent.Semaphore, используя только synchronized, wait() и notify().
 * Требования:
 *     Класс должен иметь конструктор MySemaphore(int permits), где permits — начальное количество разрешений.
 *     Метод acquire():
 *         Если есть доступные разрешения (permits > 0), уменьшает их количество на 1.
 *         Если разрешений нет, блокирует поток до их появления.
 *     Метод release():
 *         Увеличивает количество разрешений на 1.
 *         Будит один из ожидающих потоков (аналог notify()).
 *     Должна поддерживаться реентерабельность (один поток может захватывать семафор несколько раз, если хватает permits).
 */
public class SemaphoreProblem {

    public static void main(String[] args) {
        MySemaphore semaphore = new MySemaphore(1); // До 2 потоков одновременно

        Runnable task = () -> {
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + " вошёл в критическую секцию");
                Thread.sleep(1000); // Имитация работы
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
                System.out.println(Thread.currentThread().getName() + " вышел из критической секции");
            }
        };

        // Запускаем 10 потоков
        for (int i = 0; i < 10; i++) {
            new Thread(task).start();
        }
    }
}
