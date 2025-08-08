package zuochengyun;

// 二叉树算法
// 递归遍历：前序遍历、中序遍历、后序遍历
// 非递归遍历：前序遍历、中序遍历、后序遍历

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    // 前序遍历迭代实现
    // https://leetcode.cn/problems/binary-tree-preorder-traversal
    public static List<Integer> preOrderTraversalIteration(TreeNode head) {
        List<Integer> ans = new ArrayList<>();
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(head);

            while (!stack.isEmpty()) {
                head = stack.pop();
                ans.add(head.val);
                if (head.right != null) stack.push(head.right);  // 先右后左
                if (head.left != null) stack.push(head.left);
            }
        }
        return ans;
    }

    // 中序遍历迭代实现
    // https://leetcode.cn/problems/binary-tree-inorder-traversal
    public static List<Integer> inOrderTraversalIteration(TreeNode head) {
        List<Integer> ans = new ArrayList<>();
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();

            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    ans.add(head.val);
                    head = head.right;
                }
            }
        }
        return ans;
    }

    // 后序遍历迭代实现 方法一：使用两个栈
    // https://leetcode.cn/problems/binary-tree-postorder-traversal
    public static List<Integer> postOrderTraversalIteration(TreeNode head) {
        List<Integer> ans = new ArrayList<>();
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            Stack<TreeNode> collect = new Stack<>();

            stack.push(head);

            while (!stack.isEmpty()) {
                head = stack.pop();
                collect.push(head);

                if (head.left != null) stack.push(head.left);  // 先左后右
                if (head.right != null) stack.push(head.right);
            }

            while (!collect.isEmpty()) {ans.add(collect.pop().val);}
        }
        return ans;
    }

    // 后序遍历迭代实现 方法一：使用一个栈
    // https://leetcode.cn/problems/binary-tree-postorder-traversal
    public static List<Integer> postOrderTraversalIteration(TreeNode head) {
        List<Integer> ans = new ArrayList<>();
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(head);

            while (!stack.isEmpty()) {
                TreeNode cur = stack.peek();

                if (cur.left != null && head != cur.left && head != cur.right) stack.push(cur.left);
                else if (cur.right != null && head != cur.right) stack.push(cur.right);
                else {
                    ans.add(cur.val);
                    head = stack.pop();
                }
            }
        }
        return ans;
    }
}