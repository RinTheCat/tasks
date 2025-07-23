package ru.tasks.demo.task8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Напишите метод List<List<Integer>> levelOrder(TreeNode root),
 * который возвращает список списков значений узлов, сгруппированных по уровням.
 *
 *      3
 *     / \
 *    9  20
 *      /  \
 *     15   7
 *
 * Ожидаемый вывод: [[3], [9, 20], [15, 7]]
 *
 */
public class BFSOrder {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        final List<List<Integer>> result = new ArrayList<>();

        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            final List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                final TreeNode node = queue.poll();
                currentLevel.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(currentLevel);
        }
        return result;
    }
}
