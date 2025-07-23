package ru.tasks.demo.task8;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Напишите метод boolean isSymmetric(TreeNode root),
 * который проверяет, является ли дерево симметричным (зеркальным относительно корня).
 *
 *      1
 *     / \
 *    2   2
 *   / \ / \
 *  3  4 4  3
 *
 * Ожидаемый вывод: true
 *
 */
public class SymmetricProblem {

    private static boolean isSymmetric(TreeNode right, TreeNode left) {
        if (right == null && left == null) return true;
        if (right == null || left == null) return false;
        return right.val == left.val
                && isSymmetric(right.right, left.left)
                && isSymmetric(right.left, left.right);
    }

    public static boolean isSymmetricRecursive(TreeNode root) {
        return isSymmetric(root.right, root.left);
    }

    public static boolean isSymmetric(TreeNode root) {
        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.right);
        queue.offer(root.left);
        boolean isSymmetric = true;
        while (!queue.isEmpty()) {
            final TreeNode right = queue.poll();
            final TreeNode left = queue.poll();
            if (right == null && left == null) continue;
            if (right != null && left != null) {
                isSymmetric = isSymmetric && right.val == left.val;
                queue.offer(right.right);
                queue.offer(left.left);
                queue.offer(left.right);
                queue.offer(right.left);
            } else {
                return false;
            }
        }
        return isSymmetric;
    }
}
