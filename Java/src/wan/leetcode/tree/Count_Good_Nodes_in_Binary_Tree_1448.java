package wan.leetcode.tree;

import wan.leetcode.datastructure.TreeNode;

public class Count_Good_Nodes_in_Binary_Tree_1448 {

	// because the root is always the good node(with no ancestor), so the initial
	// value is 1
	int answer = 1;

	public int goodNodes(TreeNode root) {
		if (root == null) {// if there is no root, then return 0
			return 0;
		}

		this.travel(root.left, root.val);
		this.travel(root.right, root.val);

		return this.answer;
	}

	private void travel(TreeNode childNode, int max) {
		if (childNode == null) {
			return;
		}

		if (childNode.val >= max) {
			max = childNode.val;
			this.answer++;
		}

		this.travel(childNode.left, max);
		this.travel(childNode.right, max);
	}
}
