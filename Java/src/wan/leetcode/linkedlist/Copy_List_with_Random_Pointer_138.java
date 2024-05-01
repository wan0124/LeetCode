package wan.leetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

import wan.leetcode.linkedlist.datastructure.Node;

public class Copy_List_with_Random_Pointer_138 {
	public Node copyRandomList(Node head) {
		// mapping the oldNode and the newNode
		Map<Node, Node> nodeMap = new HashMap<Node, Node>();

		Node oldHead = head;
		Node preNewNode = null;
		while (oldHead != null) {
			Node newNode = nodeMap.get(oldHead);
			if (newNode == null) {
				newNode = new Node(oldHead.val);
				nodeMap.put(oldHead, newNode);
			}
			if (preNewNode != null) {
				preNewNode.next = newNode;
			}
			Node oldRandomNode = oldHead.random;
			if (oldRandomNode != null) {
				Node newRandomNode = nodeMap.get(oldRandomNode);
				if (newRandomNode == null) {
					newRandomNode = new Node(oldRandomNode.val);
					nodeMap.put(oldRandomNode, newRandomNode);
				}
				newNode.random = newRandomNode;
			}

			oldHead = oldHead.next;

			preNewNode = newNode;
		}

		return nodeMap.get(head);
	}
}
