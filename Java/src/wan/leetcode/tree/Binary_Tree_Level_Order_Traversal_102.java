package wan.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import wan.leetcode.tree.datastructure.TreeNode;

public class Binary_Tree_Level_Order_Traversal_102 {

	public List<List<Integer>> levelOrder(TreeNode root) {

		// use BFS
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (root == null) {
			return result;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			// once we come into the while loop
			// the queue size is the node counts of this level
			int currentLevelSize = queue.size();
			List<Integer> currentLevelVal = new ArrayList<Integer>();
			for (int i = 0; i < currentLevelSize; i++) {
				// we poll all nodes of this level
				TreeNode nowNode = queue.poll();
				currentLevelVal.add(nowNode.val);
				// put all child nodes of this level's node
				if (nowNode.left != null) {
					queue.add(nowNode.left);
				}
				if (nowNode.right != null) {
					queue.add(nowNode.right);
				}
			}
			result.add(currentLevelVal);
		}

		return result;
	}

}
