package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 108. 将有序数组转换为二叉搜索树
 * <p>
 * 给你一个整数数组 nums，其中元素已经按升序排列，请你将其转换为一棵高度平衡的二叉搜索树。
 * 高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 思路：有序数组的中位数就是根，左右两半分别递归建左右子树。
 * 每次取中点即保证了「左右子树节点数相差不超过 1」，因而天然高度平衡，
 * 时间 O(n)、递归栈 O(log n)。
 * <p>
 * 注：本文件原本放的是 98. 验证二叉搜索树 的一份错误实现（只比较了父子节点，
 * 没有传递上下界，对 [5,1,4,null,null,3,6] 会误判为 true），且与 no_98.java 重复。
 * 98 的正确实现（中序遍历）在 no_98.java 里，这里改回文件名对应的 108。
 *
 * @author wjh
 * @date 2024/1/23 16:40
 */
public class no_108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    /**
     * 闭区间 [left, right] 建树。
     */
    private TreeNode build(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        // 等价于 (left + right) / 2，但避免了 left + right 溢出
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums, left, mid - 1);
        root.right = build(nums, mid + 1, right);
        return root;
    }

    // ---------------- 自测 ----------------

    /**
     * 中序遍历应还原成原来的升序数组 —— 同时验证了「是 BST」。
     */
    private static void inorder(TreeNode root, List<Integer> out) {
        if (root == null) {
            return;
        }
        inorder(root.left, out);
        out.add(root.val);
        inorder(root.right, out);
    }

    private static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    private static boolean balanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(height(root.left) - height(root.right)) <= 1
                && balanced(root.left)
                && balanced(root.right);
    }

    private static String levelOrder(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        List<String> out = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                out.add("null");
                continue;
            }
            out.add(String.valueOf(node.val));
            queue.offer(node.left);
            queue.offer(node.right);
        }
        // 去掉尾部多余的 null
        while (!out.isEmpty() && out.get(out.size() - 1).equals("null")) {
            out.remove(out.size() - 1);
        }
        return out.toString();
    }

    public static void main(String[] args) {
        int[][] cases = {
                {-10, -3, 0, 5, 9},
                {1, 3},
                {},
                {1},
                {0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
        };
        no_108 solver = new no_108();
        for (int[] nums : cases) {
            TreeNode root = solver.sortedArrayToBST(nums);
            List<Integer> inorder = new ArrayList<>();
            inorder(root, inorder);

            List<Integer> expect = new ArrayList<>();
            for (int n : nums) {
                expect.add(n);
            }

            boolean isBst = inorder.equals(expect);
            boolean isBalanced = balanced(root);
            String status = isBst && isBalanced ? "PASS" : "FAIL";
            System.out.printf("%s nums=%s -> 层序=%s | 中序一致=%s | 平衡=%s%n",
                    status, java.util.Arrays.toString(nums), levelOrder(root), isBst, isBalanced);
        }
    }
}
