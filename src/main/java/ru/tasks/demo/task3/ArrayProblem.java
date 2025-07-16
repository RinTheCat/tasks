package ru.tasks.demo.task3;

import java.util.Arrays;

/**
 * Найти наибольший подотрезок в массиве, который является арифметической прогрессией (разница между соседними членами одинакова)
 */
public class ArrayProblem {

    public static int[] getTheLongestSublist(int[] input) {
        if (input == null || input.length == 0) {
            return new int[0];
        } else if (input.length == 1) {
            return new int[]{input[0]};
        }
        // защита от 1 элемента
        int diff = input[0] - input[1];
        int currentLength = 1;
        int maxLength = 0;
        int maxIndexEnd = 0;
        for (int i = 0; i < input.length - 1; i++) {
            if (input[i] - input[i + 1] == diff) {
                currentLength++;
            }
            else {
                diff = input[i] - input[i+1];
                if (maxLength < currentLength) {
                    maxLength = currentLength;
                    maxIndexEnd = i;
                    currentLength = 2;
                }
            }
        }
        if (maxLength < currentLength) {
            maxLength = currentLength;
            maxIndexEnd = input.length - 1;
        }
        int currentIndex = maxIndexEnd - maxLength + 1;
        final int[] slice = new int[maxLength];
        for (int j = 0; j < maxLength; j++) {
            slice[j] = input[currentIndex];
            currentIndex++;
        }
        return slice;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getTheLongestSublist(new int[] {1, 2, 3, 5, 0, -1}))); // 1, 2, 3
        System.out.println(Arrays.toString(getTheLongestSublist(new int[] {10, -1, -3, -5, 0}))); // 1, -3, -5,
        System.out.println(Arrays.toString(getTheLongestSublist(new int[] {1, 2, 3, -4, -6, -8, -10, 0}))); // -4, -6, -8, -10
        System.out.println(Arrays.toString(getTheLongestSublist(new int[] {1, 2, 2, 3, 2, 1}))); // 3, 2, 1
        System.out.println(Arrays.toString(getTheLongestSublist(new int[] {1, 2, 3, 2, 3, 4, 5}))); //  2, 3, 4, 5
        System.out.println(Arrays.toString(getTheLongestSublist(new int[] {1}))); // 1
    }
}
