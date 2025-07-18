package ru.tasks.demo.task5;

import java.util.Arrays;

/**
 * source:<a href="https://krilovskiy.com/posts/algo-patterns-two-pointers/">stepik</a>
 *
 * Дан отсортированный массив чисел и заданная сумма M, найдите в массиве пару,
 * сумма которой равна заданной сумме M.
 *
 * Напишите функцию, возвращающую индексы двух чисел (т. е. пары), сумма которых равна заданной сумме М.
 */
public class FirstProblem {

    private static int[] findIndexesWithTargetSum(int targetSum, int[] array) {
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            if (array[start] + array[end] < targetSum) {
                start++;
                continue;
            }
            if (array[start] + array[end] > targetSum) {
                end--;
                continue;
            }
            return new int[] {start, end};
        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
//        int[] test1 = new int[] {1, 2, 3, 4, 6};
//        int sum = 6;

        int[] test1 = new int[] {2, 5, 9, 11};
        int sum = 11;

//        int[] test1 = new int[] {0, 1, 2, 4};
//        int sum = 8;

        System.out.println(Arrays.toString(findIndexesWithTargetSum(sum, test1)));
    }
}
