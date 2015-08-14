public class LCA {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        TreeNode left = (root.left, p, q);
        TreeNode right = (root.right, p, q);
        if (left != null && right != null) return root;
        if (left == null) return right;
        return left;
    }
}
