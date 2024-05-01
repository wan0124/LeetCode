package wan.leetcode.linkedlist;

import wan.leetcode.linkedlist.datastructure.ListNode;

public class Remove_Nth_Node_From_End_of_List_19 {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode fastNode = head;
		for (int i = 0; i < n; i++) {
			fastNode = fastNode.next;
		}

		// if fastNode is null, it means we should remove the head
		if (fastNode == null) {
			return head.next;
		}

		// use slow node to find the node before target node
		ListNode slowNode = head;
		while (fastNode.next != null) {
			slowNode = slowNode.next;
			fastNode = fastNode.next;
		}

		// remove the target node
		slowNode.next = slowNode.next.next;

		return head;

	}
}
