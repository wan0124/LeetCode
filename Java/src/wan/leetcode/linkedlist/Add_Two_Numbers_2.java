package wan.leetcode.linkedlist;

import wan.leetcode.linkedlist.datastructure.ListNode;

public class Add_Two_Numbers_2 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		boolean hasCarry = false;

		ListNode result = new ListNode();
		ListNode preNode = result;

		while (l1 != null && l2 != null) {
			int sum = l1.val + l2.val;
			if (hasCarry) {
				sum++;
			}
			if (sum > 9) {
				sum -= 10;
				hasCarry = true;
			} else {
				hasCarry = false;
			}

			ListNode newNode = new ListNode(sum);
			preNode.next = newNode;
			preNode = newNode;

			l1 = l1.next;
			l2 = l2.next;
		}

		while (l1 != null) {
			int sum = l1.val;
			if (hasCarry) {
				sum++;
			}
			if (sum > 9) {
				sum -= 10;
				hasCarry = true;
			} else {
				hasCarry = false;
			}
			ListNode newNode = new ListNode(sum);
			preNode.next = newNode;
			preNode = newNode;

			l1 = l1.next;
		}

		while (l2 != null) {
			int sum = l2.val;
			if (hasCarry) {
				sum++;
			}
			if (sum > 9) {
				sum -= 10;
				hasCarry = true;
			} else {
				hasCarry = false;
			}
			ListNode newNode = new ListNode(sum);
			preNode.next = newNode;
			preNode = newNode;

			l2 = l2.next;
		}

		if (hasCarry) {
			ListNode newNode = new ListNode(1);
			preNode.next = newNode;
		}

		return result.next;

	}
}
