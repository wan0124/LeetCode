package wan.leetcode.linkedlist;

import wan.leetcode.linkedlist.datastructure.ListNode;

public class Linked_List_Cycle_141 {
	public boolean hasCycle(ListNode head) {
		ListNode slowNode = head;
		ListNode fastNode = head;

		while (fastNode != null && fastNode.next != null) {
			slowNode = slowNode.next;
			fastNode = fastNode.next.next;

			if (slowNode == fastNode) {
				return true;
			}
		}

		return false;
	}
}
