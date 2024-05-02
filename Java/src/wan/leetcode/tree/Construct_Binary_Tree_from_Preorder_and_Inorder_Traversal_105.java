package wan.leetcode.tree;

import wan.leetcode.tree.datastructure.TreeNode;

public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal_105 {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return this.buildRoot(0, 0, preorder.length - 1, preorder, inorder);
	}

	public TreeNode buildRoot(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
		// preStart is the index in preorder where the root is
		if (preStart > preorder.length - 1 || inStart > inEnd) {
			return null;
		}

		TreeNode root = new TreeNode(preorder[preStart]);

		int index = 0;
		for (int i = inStart; i <= inEnd; i++) {
			if (root.val == inorder[i]) {// find the same value in inorder
				index = i;
				break;
			}
		}
		// the node between inorder start and index -1 is the left subtree
		root.left = buildRoot(preStart + 1, inStart, index - 1, preorder, inorder);
		// the node between inorder end and index - inStart + 1 is the right subtree
		root.right = buildRoot(preStart + index - inStart + 1, index + 1, inEnd, preorder, inorder);

		return root;
	}
}
