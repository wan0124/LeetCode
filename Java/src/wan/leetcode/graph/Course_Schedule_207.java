package wan.leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Course_Schedule_207 {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		// cal the number of classes that if we want to take i class, we need to take
		// first
		Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
		// preClass <-> all after class
		Map<Integer, List<Integer>> afterClassMap = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < prerequisites.length; i++) {
			int afterClass = prerequisites[i][0];
			indexMap.put(afterClass, indexMap.getOrDefault(afterClass, 0) + 1);
			int preClass = prerequisites[i][1];
			List<Integer> afterClassList = afterClassMap.getOrDefault(preClass, new ArrayList<Integer>());
			afterClassList.add(afterClass);
			afterClassMap.put(preClass, afterClassList);
		}

		Queue<Integer> queue = new LinkedList<Integer>();

		for (int i = 0; i < numCourses; i++) {
			if (!indexMap.containsKey(i)) {
				queue.add(i);
			}
		}

		while (true) {
			int size = queue.size();
			while (size > 0) {
				int takenClass = queue.poll();
				List<Integer> afterClassList = afterClassMap.get(takenClass);
				if (afterClassList != null) {
					for (int afterClass : afterClassMap.get(takenClass)) {
						int preClassCount = indexMap.get(afterClass) - 1;
						if (preClassCount == 0) {
							queue.add(afterClass);
							indexMap.remove(afterClass);
						} else {
							indexMap.put(afterClass, preClassCount);
						}
					}
				}

				size--;
			}

			if (queue.isEmpty()) {
				break;
			}
		}

		return indexMap.isEmpty() ? true : false;

	}
}
