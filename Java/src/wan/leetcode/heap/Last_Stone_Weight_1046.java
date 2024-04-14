package wan.leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Last_Stone_Weight_1046 {
	public int lastStoneWeight(int[] stones) {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		for (int stone : stones) {
			queue.add(stone);
		}

		while (queue.size() > 1) {
			int stone1 = queue.poll();
			int stone2 = queue.poll();

			int newStone = this.smashStones(stone1, stone2);
			if (newStone != 0) {
				queue.add(newStone);
			}
		}
		// maybe there is no stone in the queue
		if (queue.isEmpty()) {
			return 0;
		}

		return queue.poll();
	}

	private int smashStones(int stone1, int stone2) {
		if (stone1 == stone2) {
			return 0;
		}

		return Math.abs(stone1 - stone2);
	}
}
