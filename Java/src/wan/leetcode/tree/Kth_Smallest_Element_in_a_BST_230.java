package wan.leetcode.tree;

import java.util.Stack;

import wan.leetcode.datastructure.TreeNode;

public class Kth_Smallest_Element_in_a_BST_230 {
	public int kthSmallest(TreeNode root, int k) {
		/*
		 * PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(new
		 * Comparator<Integer>() {
		 * 
		 * @Override public int compare(Integer i1, Integer i2) { return i2 - i1; }
		 * 
		 * }); Queue<TreeNode> queue = new LinkedList<TreeNode>();
		 * 
		 * queue.add(root);
		 * 
		 * while (!queue.isEmpty()) { TreeNode node = queue.poll(); if
		 * (priorityQueue.size() < k) { priorityQueue.add(node.val); } else if (node.val
		 * < priorityQueue.peek()) { priorityQueue.poll(); priorityQueue.add(node.val);
		 * } if (node.left != null) { queue.add(node.left); } if (node.right != null) {
		 * queue.add(node.right); }
		 * 
		 * }
		 * 
		 * return priorityQueue.poll();
		 */

		Stack<TreeNode> stack = new Stack<TreeNode>();

		int result = 0;

		while (root != null || !stack.isEmpty()) {
			while (root != null) {//go direct to the left side until is null;
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();//this one is the smallest in the rest of tree nodes
			if (--k == 0) {//
				result = root.val;
				break;
			}
			root = root.right;
		}

		return result;

	}
}
