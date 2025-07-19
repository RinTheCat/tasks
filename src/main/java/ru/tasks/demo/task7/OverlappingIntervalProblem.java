package ru.tasks.demo.task7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OverlappingIntervalProblem {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(array -> array[0]));
        List<int[]> result = new ArrayList<>();
        int[] currentInterval = intervals[0];
        result.add(currentInterval);

        for (int i = 1; i < intervals.length; i++) {
            if (currentInterval[1] >= intervals[i][0]) {
                currentInterval[1] = Math.max(intervals[i][1], currentInterval[1]);
            } else {
                currentInterval = intervals[i];
                result.add(currentInterval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] t = new int[][] {{2,3},{1,2}};
        System.out.println(Arrays.deepToString(merge(t)));
    }
}
