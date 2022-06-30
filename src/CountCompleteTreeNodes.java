// https://leetcode.com/problems/count-complete-tree-nodes/

public class CountCompleteTreeNodes {

    public static void main(String[] args) {

//        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null));

        TreeNode root = new TreeNode(1);

        System.out.println(new CountCompleteTreeNodes().countNodes(root));
    }

    public int countNodes(TreeNode root) {

        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
