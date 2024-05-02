package wan.leetcode.tree;

import wan.leetcode.tree.datastructure.TreeNode;

public class Maximum_Depth_of_Binary_Tree_104 {
	public int maxDepth(TreeNode root) {
		return this.travel(root);
	}

	private int travel(TreeNode root) {
		if (root == null) {
			return 0;
		}

		return Math.max(this.travel(root.left), this.travel(root.right)) + 1;
	}
}
