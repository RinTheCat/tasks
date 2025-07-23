package ru.tasks.demo.task8;

/**
 *
 * Напишите метод int sumOfLeftLeaves(TreeNode root),
 * который возвращает сумму всех левых листьев (лист — узел без потомков).
 *
 *      3
 *     / \
 *    9  20
 *      /  \
 *     15   7
 *
 * Ожидаемый вывод: 24 (9 + 15)
 *
 */
public class TreeSumProblem {

    public static int sumOfLeftLeavesRecursive(TreeNode root) {
        int sum = 0;
        if (root == null) return 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
        sum += sumOfLeftLeavesRecursive(root.left);
        sum += sumOfLeftLeavesRecursive(root.right);
        return sum;
    }

}
