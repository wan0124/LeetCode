package wan.leetcode.tree;

import wan.leetcode.tree.datastructure.TreeNode;

public class Same_Tree_100 {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		return this.isSame(p, q);
	}

	private boolean isSame(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		}

		if ((root1 == null && root2 != null) || (root1 != null && root2 == null)) {
			return false;
		}

		if (root1.val != root2.val) {
			return false;
		}

		return this.isSame(root1.left, root2.left) && this.isSame(root1.right, root2.right);
	}
}
