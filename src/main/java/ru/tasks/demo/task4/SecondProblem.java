package ru.tasks.demo.task4;

/**
 * source:<a href="https://stepik.org/lesson/784946/step/7?unit=787536">stepik</a>
 *
 *      Входные данные
 * В первой строке входных данных содержатся числа NN и KK (0<N,K<1000010<N,K<100001).
 * Во второй строке задаются N чисел первого массива, отсортированного по неубыванию,
 * а в третьей строке – K чисел второго массива. Каждое число в обоих массивах
 * по модулю не превосходит 2⋅1092⋅109.
 *
 *      Выходные данные
 * Для каждого из KK чисел выведите в отдельную строку число из первого массива,
 * наиболее близкое к данному. Если таких несколько, выведите меньшее из них.
 *
 * Sample Input:
 *
 * 5 5
 * 1 3 5 7 9
 * 2 4 8 1 6
 */
public class SecondProblem {

    private static int getTheClosestInt(int targetValue, int[] array) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (array[middle] == targetValue) return targetValue;
            if (targetValue > array[middle]) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        // не нашли число, но знаем границы в виде start и end
        // на этом этапе start > end
        return targetValue - array[end] > array[start] - targetValue ? array[start] : array[end];
    }

    public static void main(String[] args) {
        // без ввода строк, входные данные уже заполнены
        int[] firstArray = new int[] {1, 3, 5, 7, 9};
        int[] secondArray = new int[] {2, 4, 8, 1, 6};

        for (int value : secondArray) {
            System.out.println(getTheClosestInt(value, firstArray));
        }
    }
}
