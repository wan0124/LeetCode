package wan.leetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LRU_Cache_146 {
	public static class LRUCache {
		class LinkedListNode {
			int key;
			int val;
			LinkedListNode pre;
			LinkedListNode next;

			public LinkedListNode(int key, int val) {
				this.key = key;
				this.val = val;
			}
		}

		// for finding
		Map<Integer, LinkedListNode> indexMap;

		int capacity;
		LinkedListNode head;
		LinkedListNode tail;

		public LRUCache(int capacity) {
			this.indexMap = new HashMap<Integer, LinkedListNode>();
			this.capacity = capacity;
			this.head = new LinkedListNode(-1, -1);
			this.tail = new LinkedListNode(-1, -1);

			this.head.next = tail;
			this.tail.pre = head;
		}

		public int get(int key) {
			if (!this.indexMap.containsKey(key)) {
				return -1;
			}
			int returnVal = this.indexMap.get(key).val;
			this.remove(key);
			this.add(key, returnVal);
			return returnVal;
		}

		public void put(int key, int value) {
			if (this.indexMap.containsKey(key)) {
				this.remove(key);
			}
			this.add(key, value);
			if (this.indexMap.size() > this.capacity) {
				this.remove(head.next.key);
			}
		}

		private void remove(int key) {
			LinkedListNode targetNode = this.indexMap.get(key);
			if (targetNode == null) {
				return;
			}

			LinkedListNode preNode = targetNode.pre;
			LinkedListNode nextNode = targetNode.next;

			preNode.next = nextNode;
			nextNode.pre = preNode;

			this.indexMap.remove(key);

		}

		private void add(int key, int value) {
			LinkedListNode preNode = tail.pre;
			LinkedListNode newNode = new LinkedListNode(key, value);
			preNode.next = newNode;
			newNode.pre = preNode;
			newNode.next = tail;
			tail.pre = newNode;
			indexMap.put(key, newNode);
		}
	}
}
