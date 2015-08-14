/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
Calling next() will return the next smallest number in the BST.
Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
*/

public class BSTIterator {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    Stack<TreeNode> st = new Stack<>();
 
    public void df(TreeNode root) {
        while(root != null) {
            st.push(root);
            root = root.left;
        }
    }
 
    public BSTIterator(TreeNode root) {
        df(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !st.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = st.pop();
        df(node.right);
        return node.val;
    }
}
