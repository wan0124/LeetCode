package wan.leetcode.linkedlist;

import wan.leetcode.linkedlist.datastructure.ListNode;

public class Reverse_Linked_List_206 {
	public ListNode reverseList(ListNode head) {

		if (head == null) {
			return null;
		}

		ListNode nextNode = null;
		ListNode preNode = null;

		while (head != null) {
			nextNode = head.next;
			head.next = preNode;
			preNode = head;
			head = nextNode;
		}
		// if we leave the while loop, it means now head is null
		// then the new head is preNode
		return preNode;

	}
}
