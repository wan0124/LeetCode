package wan.leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Course_Schedule_II_210 {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		Map<Integer, Integer> preClassCountMap = new HashMap<Integer, Integer>();
		Map<Integer, List<Integer>> afterClassMap = new HashMap<Integer, List<Integer>>();

		for (int i = 0; i < prerequisites.length; i++) {
			Integer preClass = prerequisites[i][1];
			Integer afterClass = prerequisites[i][0];

			preClassCountMap.put(afterClass, preClassCountMap.getOrDefault(afterClass, 0) + 1);
			List<Integer> afterClassList = afterClassMap.getOrDefault(preClass, new ArrayList<Integer>());
			afterClassList.add(afterClass);
			afterClassMap.put(preClass, afterClassList);
		}

		Queue<Integer> queue = new LinkedList<Integer>();

		for (int i = 0; i < numCourses; i++) {
			if (!preClassCountMap.containsKey(i)) {
				queue.add(i);
			}
		}
		List<Integer> takenClassList = new ArrayList<Integer>();
		while (true) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Integer takenClass = queue.poll();
				takenClassList.add(takenClass);
				List<Integer> afterClassList = afterClassMap.get(takenClass);
				if (afterClassList != null) {
					for (Integer afterClass : afterClassList) {
						Integer preClassCount = preClassCountMap.get(afterClass) - 1;
						if (preClassCount == 0) {
							queue.add(afterClass);
							preClassCountMap.remove(afterClass);
						} else {
							preClassCountMap.put(afterClass, preClassCount);
						}
					}
				}
			}
			if (queue.isEmpty()) {
				break;
			}
		}

		if (takenClassList.size() != numCourses) {
			return new int[] {};
		}

		int[] result = new int[numCourses];
		for (int i = 0; i < numCourses; i++) {
			result[i] = takenClassList.get(i);
		}

		return result;

	}
}
