package wan.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import wan.leetcode.datastructure.TreeNode;

public class Binary_Tree_Level_Order_Traversal_102 {

	public List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int parentSize = queue.size();
			List<Integer> layerList = new ArrayList<Integer>();
			for (int i = 0; i < parentSize; i++) {
				TreeNode node = queue.poll();
				layerList.add(node.val);
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
			result.add(layerList);

		}

		return result;
	}
}
