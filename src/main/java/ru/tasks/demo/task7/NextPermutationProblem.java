package ru.tasks.demo.task7;

import java.util.Arrays;

public class NextPermutationProblem {

    /**
     * Алгоритм нахождения следующей перестановки
     *     Найти первый убывающий элемент справа (пивот):
     *         Идём с конца, ищем i, где nums[i] < nums[i+1].
     *         Для [1, 3, 2] это 1 (индекс 0).
     *     Найти элемент для обмена (больше пивота):
     *         Ищем j, где nums[j] > nums[i] (справа от пивота).
     *         Для [1, 3, 2] это 2 (индекс 2).
     *     Поменять местами nums[i] и nums[j]:
     *         [1, 3, 2] → [2, 3, 1].
     *     Развернуть правую часть (после i):
     *         [2, 3, 1] → [2, 1, 3].
     * Итог: Следующая перестановка для [1, 3, 2] → [2, 1, 3].
     */
    public static void nextPermutation(int[] nums) {
        int pivotIndex = -1;
        int buf;
        // ищем пивот
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pivotIndex = i;
                break;
            }
        }
        // в случае убывающего массива его надо полностью развернуть, скипаем нахождение замены
        if (pivotIndex != -1) {
            int substitutionIndex = 0;
            // ищем элемент для обмена (первый справа)
            for (int i = pivotIndex + 1; i < nums.length; i++) {
                if (nums[i] > nums[pivotIndex]) {
                    substitutionIndex = i;
                }
            }
            buf = nums[pivotIndex];
            nums[pivotIndex] = nums[substitutionIndex];
            nums[substitutionIndex] = buf;
        }
        // перестановка после pivotIndex
        int start = pivotIndex + 1;
        int end = nums.length - 1;
        while (start < end) {
            buf = nums[start];
            nums[start] = nums[end];
            nums[end] = buf;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] task1 = new int[] {1, 3, 2};
        nextPermutation(task1);
        System.out.println(Arrays.toString(task1));
    }
}
