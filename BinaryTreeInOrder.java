public class BinaryTreeInOrder {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> inorderTraversal(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (null == root) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new LinkedList<>();
            while (size-- > 0) {
                TreeNode node = q.poll();
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
                list.add(node.val);
            }
            result.add(list);
        }
        return result;
    }

}
