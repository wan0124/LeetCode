package wan.leetcode.heap;

import java.util.PriorityQueue;

public class Kth_Largest_Element_in_a_Stream_703 {
	public static class KthLargest {
		int kthLarge;
		PriorityQueue<Integer> queue;

		public KthLargest(int k, int[] nums) {
			this.kthLarge = k;
			queue = new PriorityQueue<Integer>();
			for (int num : nums) {
				this.add(num);
			}
		}

		public int add(int val) {
			queue.add(val);
			if (queue.size() > this.kthLarge) {
				queue.poll();
			}
			return queue.peek();
		}
	}
}
