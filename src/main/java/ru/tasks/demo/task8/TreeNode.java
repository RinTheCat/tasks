package ru.tasks.demo.task8;

public class TreeNode {
    int val;          // значение узла
    TreeNode left;    // левый потомок
    TreeNode right;   // правый потомок

    // Конструкторы
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}