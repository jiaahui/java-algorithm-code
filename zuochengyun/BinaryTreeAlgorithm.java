package zuochengyun;

// 二叉树算法
// 递归遍历：前序遍历、中序遍历、后序遍历
// 非递归遍历：前序遍历、中序遍历、后序遍历

public class BinaryTreeAlgorithm {
    public static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int v) {this.val = v;}
    }

    // 前序遍历递归实现
    public static void preOrderTraversalRecursion(TreeNode head) {
        if (head == null) return;

        System.out.print(head.val + " ");
        preOrderTraversalRecursion(head.left);
        preOrderTraversalRecursion(head.right);
    }

    // 中序遍历递归实现
    public static void inOrderTraversalRecursion(TreeNode head) {
        if (head == null) return;

        preOrderTraversalRecursion(head.left);
        System.out.print(head.val + " ");
        preOrderTraversalRecursion(head.right);
    }

    // 后序遍历递归实现
    public static void postOrderTraversalRecursion(TreeNode head) {
        if (head == null) return;

        preOrderTraversalRecursion(head.left);
        preOrderTraversalRecursion(head.right);
        System.out.print(head.val + " ");
    }
}