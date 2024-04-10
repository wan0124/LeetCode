package wan.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import wan.leetcode.datastructure.TreeNode;

public class Binary_Tree_Right_Side_View_199 {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}

		TreeNode node = root;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(node);

		while (!queue.isEmpty()) {
			int parentSize = queue.size();
			int index = 0;
			TreeNode rightNode = null;
			while (index < parentSize) {
				rightNode = queue.poll();
				// put every child node into the queue
				if (rightNode.left != null) {
					queue.add(rightNode.left);
				}
				if (rightNode.right != null) {
					queue.add(rightNode.right);
				}
				index++;
			}
			// at the end of the while loop, the rightNode must be the real rightNode
			result.add(rightNode.val);

		}

		return result;
	}
}
