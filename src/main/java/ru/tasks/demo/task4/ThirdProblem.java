package ru.tasks.demo.task4;

/**
 * source:<a href="https://stepik.org/lesson/784946/step/9?unit=787536">stepik</a>
 *
 * Дано два списка чисел, числа в первом списке упорядочены по неубыванию.
 * Для каждого числа из второго списка определите номер первого и последнего появления этого числа в первом списке.
 *
 * Входные данные
 * В первой строке входных данных записано два числа N и M (1≤N,M≤200001≤N,M≤20000).
 * Во второй строке записано N упорядоченных по неубыванию целых чисел — элементы первого списка.
 * В третьей строке записаны M целых неотрицательных чисел - элементы второго списка.
 * Все числа в списках - целые 32-битные знаковые.
 *
 * Выходные данные
 * Программа должна вывести MM строчек.
 * Для каждого числа из второго списка нужно вывести номер его первого
 * и последнего вхождения в первый список.
 * Если число не входит в первый список, нужно вывести -1.
 */
public class ThirdProblem {

    private static int findEntry(int targetValue, int[] array, boolean isFirst) {
        int start = 0;
        int end = array.length - 1;
        int index = -1;

        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (array[middle] == targetValue) {
                index = middle;
            }
            if ((targetValue > array[middle] && isFirst) || (!isFirst && targetValue >= array[middle])) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] firstArray = new int[] {1, 1, 3, 3, 5, 7, 9, 18, 18, 57};
        int[] secondArray = new int[] {57, 3, 9, 1, 179};
        for (int value : secondArray) {
            System.out.println(findEntry(value, firstArray, true) + " " + findEntry(value, firstArray, false));
        }
    }
}
