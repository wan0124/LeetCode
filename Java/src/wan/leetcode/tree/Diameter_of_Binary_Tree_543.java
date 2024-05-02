package wan.leetcode.tree;

import wan.leetcode.tree.datastructure.TreeNode;

public class Diameter_of_Binary_Tree_543 {

	int maxLength = 0;

	public int diameterOfBinaryTree(TreeNode root) {
		this.travel(root);
		return maxLength;
	}

	private int travel(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int leftMaxLength = this.travel(root.left);
		int rightMaxLength = this.travel(root.right);

		maxLength = Math.max(maxLength, leftMaxLength + rightMaxLength);

		return Math.max(leftMaxLength, rightMaxLength) + 1;
	}
}
