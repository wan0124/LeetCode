package wan.leetcode.linkedlist;

import wan.leetcode.linkedlist.datastructure.ListNode;

public class Merge_Two_Sorted_Lists_21 {
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

		// check if one of list is null
		if (list1 == null) {
			return list2;
		}

		if (list2 == null) {
			return list1;
		}

		// which node is the head
		ListNode head = null;
		if (list1.val > list2.val) {
			head = list2;
			list2 = list2.next;
		} else {
			head = list1;
			list1 = list1.next;
		}
		// save the head for return
		ListNode returnHead = head;

		while (list1 != null && list2 != null) {
			if (list1.val > list2.val) {
				head.next = list2;
				head = head.next;
				list2 = list2.next;
			} else {
				head.next = list1;
				head = head.next;
				list1 = list1.next;
			}
		}

		// check if any list has last node
		if (list1 != null) {
			head.next = list1;
		} else {
			head.next = list2;
		}

		return returnHead;
	}
}
