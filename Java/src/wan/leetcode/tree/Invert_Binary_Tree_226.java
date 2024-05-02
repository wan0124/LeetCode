package wan.leetcode.tree;

import wan.leetcode.tree.datastructure.TreeNode;

public class Invert_Binary_Tree_226 {
	public TreeNode invertTree(TreeNode root) {
		this.swapBinaryTree(root);
		return root;
	}

	private void swapBinaryTree(TreeNode root) {
		if (root == null) {
			return;
		}

		TreeNode leftChild = root.left;
		TreeNode rightChild = root.right;

		this.swapBinaryTree(leftChild);
		this.swapBinaryTree(rightChild);

		root.left = rightChild;
		root.right = leftChild;
	}
}
