package wan.leetcode.tree;

import wan.leetcode.tree.datastructure.TreeNode;

public class Count_Good_Nodes_in_Binary_Tree_1448 {

	int goodNodeCount = 0;

	public int goodNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}

		this.travel(root, root.val);

		return goodNodeCount;
	}

	private void travel(TreeNode root, int maxValue) {
		if (root == null) {
			return;
		}
		// if this node's value isn't less than the maxValue, we add the count
		if (root.val >= maxValue) {
			this.goodNodeCount++;
			maxValue = root.val;
		}

		this.travel(root.left, maxValue);
		this.travel(root.right, maxValue);

	}

}
