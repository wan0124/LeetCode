package wan.leetcode.tree;

import wan.leetcode.datastructure.TreeNode;

public class Subtree_of_Another_Tree_572 {
	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
		//if some child node is null, then is not the subtree
		if(root == null) {
			return false;
		}
		//check if root and subRoot is the same tree
		if (isSameTree(root, subRoot)) {
			return true;
		}
		//move on the root, to check all node
		return isSubtree(root.right, subRoot) || isSubtree(root.left, subRoot);

	}

	private boolean isSameTree(TreeNode root, TreeNode subRoot) {
		// both are null means is same tree
		if (root == null && subRoot == null) {
			return true;
		}
		// only one of both us null means is different
		if (root == null || subRoot == null) {
			return false;
		}
		// of course the different value between two root means is different
		if (root.val != subRoot.val) {
			return false;
		}
		// continue compare the child
		return this.isSameTree(root.right, subRoot.right) && this.isSameTree(root.left, subRoot.left);
	}
}
