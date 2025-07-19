package ru.tasks.demo.task7;

public class LongestPalindromeProblem {

    private static String longestPalindrome(String s) {
        int max = 0;
        int maxStart = 0;
        int maxEnd = 0;
        for (int i = 0; i < s.length(); i++) {
            int even = growPalindrome(s, i, i + 1);
            int odd = growPalindrome(s, i, i);
            int currentMax = Math.max(even, odd);
            if (currentMax > max) {
                max = currentMax;
                maxStart = i - (currentMax - 1) / 2;
                maxEnd = i + currentMax / 2 + 1;
            }
        }
        return s.substring(maxStart, maxEnd);
    }

    private static int growPalindrome(String s, int start, int end) {
        // "bcbabaab"
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return end - start - 1;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("ab"));
    }
}
