package ru.tasks.demo.task8;

import java.util.ArrayList;
import java.util.List;

/**
 * Напишите метод List<Integer> inorderTraversal(TreeNode root),
 * который возвращает значения узлов двоичного дерева в порядке in-order (левый → корень → правый).
 */
public class TreeOrderProblem {

    public static List<Integer> inorderTraversal(TreeNode root) {
        final List<Integer> result = new ArrayList<>();
        addValues(root, result);
        return result;
    }

    private static void addValues(TreeNode root, List<Integer> values) {
        if (root == null) return;
        addValues(root.left, values);
        values.add(root.val);
        addValues(root.right, values);
    }

}
