public class BinaryTreeBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1;
    }

    public int getHeight(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return Math.max(getHeight(root.left)+1, getHeight(root.right)+1);
    }


    public int computeAndCheckHeight(TreeNode root){
     /* Base case - Tree is empty */
     if(root == null)
          return 0;
     /* Height of left subtree */
     int leftSubTreeHeight = computeAndCheckHeight(root.left);
     /* Left subtree is not balanced */
     if(leftSubTreeHeight == -1)
          return -1;  

     /* Height of right subtree */
     int rightSubTreeHeight = computeAndCheckHeight(root.right);
     /* Right subtree is not balanced */
     if(rightSubTreeHeight == -1)
          return -1;

     /* Difference in height */
     int heightDifference = Math.abs(leftSubTreeHeight - rightSubTreeHeight);
     /* Root node is not balanced */
     if(heightDifference > 1)
          return -1;
     else
          /* Height of the root node */
          return Math.max(leftSubTreeHeight, rightSubTreeHeight) + 1;
 }
}
