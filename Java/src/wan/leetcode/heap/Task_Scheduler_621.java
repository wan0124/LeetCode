package wan.leetcode.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Task_Scheduler_621 {
	public int leastInterval(char[] tasks, int n) {
		// calculate the frequence of different task
		Map<Character, Integer> frequencyMap = new HashMap<Character, Integer>();
		for (char task : tasks) {
			frequencyMap.put(task, frequencyMap.getOrDefault(task, 0) + 1);
		}

		// split the all time into several slot, which the width is n + 1
		// n means if a task is executed, the same task must wait for n times
		// and the plus one means it self
		// if n = 4 -> A**** A**** -> every slot might be 4 + 1 = 5

		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});

		for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
			queue.add(entry.getValue());
		}

		int totalTime = 0;
		int slot = n + 1;
		while (!queue.isEmpty()) {
			int spendTime = 0;
			List<Integer> doList = new ArrayList<Integer>();
			// we do the high frequency first
			// if dont, there will be more idles
			// ex : if A has frequency 4 and B has 3 and C has 2 with n = 1
			// do low frequency first -> CB CB *B *A *A *A *A
			// do high frequency first -> AB AB AB AC *C
			for (int i = 0; i < slot; i++) {
				if (!queue.isEmpty()) {
					doList.add(queue.poll());
					spendTime++;
				}
			}
			for (Integer doTask : doList) {
				if (doTask - 1 > 0) {
					queue.add(doTask - 1);
				}
			}
			//if the queue is empty at the end of the loop
			//it means that all tasks have been done
			//so maybe the final slot is not as long as the slot
			
			//if is not empty, then the spend time must be the same as slot
			totalTime += queue.isEmpty() ? spendTime : slot;
		}

		return totalTime;

	}

}
