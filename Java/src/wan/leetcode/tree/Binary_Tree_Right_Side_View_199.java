package wan.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import wan.leetcode.tree.datastructure.TreeNode;

public class Binary_Tree_Right_Side_View_199 {
	public List<Integer> rightSideView(TreeNode root) {

		List<Integer> result = new ArrayList<Integer>();

		if (root == null) {
			return result;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int currentLevelSize = queue.size();
			for (int i = 0; i < currentLevelSize; i++) {
				TreeNode currentNode = queue.poll();
				if (i == currentLevelSize - 1) {
					result.add(currentNode.val);
				}
				if (currentNode.left != null) {
					queue.add(currentNode.left);
				}
				if (currentNode.right != null) {
					queue.add(currentNode.right);
				}
			}
		}

		return result;
	}
}
