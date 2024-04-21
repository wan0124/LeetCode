package wan.leetcode.arrayandhashing;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Top_K_Frequent_Elements_347 {
	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
		for (int num : nums) {
			int cnt = countMap.getOrDefault(num, 0);
			countMap.put(num, ++cnt);
		}

		PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<Map.Entry<Integer, Integer>>(
				new Comparator<Map.Entry<Integer, Integer>>() {

					@Override
					public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
						return o2.getValue() - o1.getValue();
					}
				});

		queue.addAll(countMap.entrySet());

		int[] result = new int[k];
		for (int i = 0; i < k; i++) {
			result[i] = queue.poll().getKey();
		}

		return result;

	}
}
