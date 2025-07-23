package ru.tasks.demo.task8;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Напишите метод int maxDepth(TreeNode root),
 * который возвращает максимальную глубину дерева (количество узлов на самом длинном пути от корня до листа).
 */
public class MaxDepthProblem {

    public static int maxDepthRecursive(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepthRecursive(root.left), maxDepthRecursive(root.right));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;

        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            depth++;
            for (int i = 0; i < levelSize; i++) {
                final TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return depth;
    }
}
