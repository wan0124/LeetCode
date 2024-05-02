package wan.leetcode.tree;

import wan.leetcode.tree.datastructure.TreeNode;

public class Balanced_Binary_Tree_110 {
	boolean isBalanced = true;

	public boolean isBalanced(TreeNode root) {
		this.travle(root);
		return isBalanced;
	}

	private int travle(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int leftChildLength = this.travle(root.left);
		int rightChildLength = this.travle(root.right);

		if (leftChildLength != rightChildLength && Math.abs(leftChildLength - rightChildLength) > 1) {
			isBalanced = false;
		}

		return Math.max(leftChildLength, rightChildLength) + 1;
	}
}
