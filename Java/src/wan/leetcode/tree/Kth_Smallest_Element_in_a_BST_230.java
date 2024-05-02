package wan.leetcode.tree;

import java.util.Stack;

import wan.leetcode.tree.datastructure.TreeNode;

public class Kth_Smallest_Element_in_a_BST_230 {
	public int kthSmallest(TreeNode root, int k) {

		Stack<TreeNode> stack = new Stack<TreeNode>();

		while (root != null || !stack.isEmpty()) {
			// put all left children of this node in stack
			while (root != null) {
				stack.push(root);
				root = root.left;
			}

			root = stack.pop();
			if (--k == 0) {
				return root.val;
			}

			root = root.right;
		}

		return -1;
	}
}
