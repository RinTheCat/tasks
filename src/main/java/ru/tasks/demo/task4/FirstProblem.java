package ru.tasks.demo.task4;

/**
 * source:<a href="https://stepik.org/lesson/784946/step/4?unit=787536">stepik</a>
 *
 *      Входные данные
 *
 *   В первой строке входных данных содержатся натуральные числа NN и KK (0<N,K≤1000000<N,K≤100000).
 *   Во второй строке задаются NN элементов первого массива, отсортированного по возрастанию, а
 *   в третьей строке – KK элементов второго массива. Элементы обоих массивов - целые числа,
 *   каждое из которых по модулю не превосходит 109
 *
 *      Выходные данные
 *   Требуется для каждого из K чисел вывести в отдельную строку "YES",
 *   если это число встречается в первом массиве, и "NO" в противном случае.
 *
 *      Sample Input:
 *
 * 10 10
 * 1 61 126 217 2876 6127 39162 98126 712687 1000000000
 * 100 6127 1 61 200 -10000 1 217 10000 1000000000
 */
public class FirstProblem {

    private static final String NO = "NO";
    private static final String YES = "YES";

    /**
     * Простой бинарный поиск числа в массиве
     * @return наличие / отсутствие
     */
    private static boolean isExists(int targetValue, int[] array) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (targetValue == array[middle]) {
                return true;
            }
            if (targetValue > array[middle]) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // без ввода строк, входные данные уже заполнены
        int[] firstArray = new int[] {1, 61, 126, 217, 2876, 6127, 39162, 98126, 712687, 1000000000};
        int[] secondArray = new int[] {100, 6127, 1, 61, 200, -10000, 1, 217, 10000, 1000000000};

        for (int value : secondArray) {
            if (isExists(value, firstArray)) {
                System.out.println(YES);
            } else {
                System.out.println(NO);
            }
        }
        // итоговая сложность: n*log(n)
    }
}
