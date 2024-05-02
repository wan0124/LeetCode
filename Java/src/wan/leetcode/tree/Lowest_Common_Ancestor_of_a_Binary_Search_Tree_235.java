package wan.leetcode.tree;

import wan.leetcode.tree.datastructure.TreeNode;

public class Lowest_Common_Ancestor_of_a_Binary_Search_Tree_235 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		//the root tree is bst -> left child is smaller than parent and right child is bigger than parent
		TreeNode node = root;
		while (node != null) {
			//if this node is smaller than p, q then find the bigger child
			if (node.val < p.val && node.val < q.val) {
				node = node.right;
			} else if (node.val > p.val && node.val > q.val) {
				//if this node is bigger than p, q then find the smaller child
				node = node.left;
			} else {
				//if this node is between p, q then we find the answer
				return node;
			}
		}

		return null;
	}

}
