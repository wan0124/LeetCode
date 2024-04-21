package wan.leetcode.tree;

import wan.leetcode.datastructure.TreeNode;

public class Validate_Binary_Search_Tree_98 {
	public boolean isValidBST(TreeNode root) {
		return validBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	private boolean validBST(TreeNode root, long min, long max) {
		if (root == null) {
			return true;
		}
		if (root.val < max && root.val > min) {
			return validBST(root.left, min, root.val) && validBST(root.right, root.val, max);
		}

		return false;
	}
}
