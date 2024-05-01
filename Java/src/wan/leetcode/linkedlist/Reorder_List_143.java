package wan.leetcode.linkedlist;

import wan.leetcode.linkedlist.datastructure.ListNode;

public class Reorder_List_143 {
	public void reorderList(ListNode head) {
		ListNode firstHalfHead = head;
		// split the list into first half and second half
		// and reverse the second half
		ListNode secondHalfHead = this.reverse(this.findTheSecondHalfHead(head));

		ListNode firstHalfNodeNext;
		ListNode secondHalfNodeNext;
		while (firstHalfHead != null && secondHalfHead != null) {
			firstHalfNodeNext = firstHalfHead.next;
			secondHalfNodeNext = secondHalfHead.next;

			firstHalfHead.next = secondHalfHead;
			secondHalfHead.next = firstHalfNodeNext;

			firstHalfHead = firstHalfNodeNext;
			secondHalfHead = secondHalfNodeNext;
		}

	}

	// find the second half head by finding the middle node
	private ListNode findTheSecondHalfHead(ListNode head) {
		ListNode slowNode = head;
		ListNode fastNode = head;

		while (fastNode != null && fastNode.next != null) {
			slowNode = slowNode.next;
			fastNode = fastNode.next.next;
		}

		ListNode secondHalfHead = slowNode.next;
		slowNode.next = null;
		return secondHalfHead;

	}

	// reverse the list
	private ListNode reverse(ListNode head) {
		ListNode preNode = null;
		ListNode nextNode = null;

		ListNode newHead = head;

		while (newHead != null) {
			nextNode = newHead.next;
			newHead.next = preNode;
			preNode = newHead;
			newHead = nextNode;
		}

		return preNode;
	}
}
