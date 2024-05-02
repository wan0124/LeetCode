package wan.leetcode.tree;

import wan.leetcode.tree.datastructure.TreeNode;

public class Subtree_of_Another_Tree_572 {
	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
		if (root == null) {
			return false;
		}

		if (this.isSameTree(root, subRoot)) {
			return true;
		}

		return this.isSubtree(root.left, subRoot) || this.isSubtree(root.right, subRoot);
	}

	private boolean isSameTree(TreeNode root, TreeNode subRoot) {
		if (root == null && subRoot == null) {
			return true;
		}

		if ((root != null && subRoot == null) || (root == null && subRoot != null)) {
			return false;
		}

		if (root.val != subRoot.val) {
			return false;
		}

		return this.isSameTree(root.left, subRoot.left) && this.isSameTree(root.right, subRoot.right);
	}
}
