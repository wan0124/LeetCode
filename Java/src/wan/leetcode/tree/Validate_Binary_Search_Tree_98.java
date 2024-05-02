package wan.leetcode.tree;

import wan.leetcode.tree.datastructure.TreeNode;

public class Validate_Binary_Search_Tree_98 {
	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}

		return this.validBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	private boolean validBST(TreeNode root, long minValue, long maxValue) {
		if (root == null) {
			return true;
		}

		if (root.val > minValue && root.val < maxValue) {
			// check leftChild and rightChild
			// for leftChild, is must less than root, and greater than minValue
			// for rightChild, is must greater than root, and less than maxValue
			return this.validBST(root.left, minValue, root.val) && this.validBST(root.right, root.val, maxValue);
		}

		return false;
	}

}
