package ru.tasks.demo.task6;

public class HanoiTowerProblem {

    public static void solveHanoi(int disks, char source, char additional, char target) {
        if (disks == 1) {
            System.out.println("Переместить диск 1 с " + source + " на " + target);
            return;
        }

        // Шаг 1: Переместить (n-1) дисков на вспомогательный стержень
        solveHanoi(disks - 1, source, target, additional);

        // Шаг 2: Переместить самый большой диск на целевой стержень
        System.out.println("Переместить диск " + disks + " с " + source + " на " + target);

        // Шаг 3: Переместить (n-1) дисков с вспомогательного на целевой стержень
        solveHanoi(disks - 1, additional, source, target);
    }

    public static void main(String[] args) {
        int numberOfDisks = 3;
        solveHanoi(numberOfDisks, 'A', 'B', 'C');
    }
}
