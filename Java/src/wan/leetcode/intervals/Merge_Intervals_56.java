package wan.leetcode.intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class Merge_Intervals_56 {
	public int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}

		});

		Stack<int[]> stack = new Stack<int[]>();
		stack.push(intervals[0]);

		for (int i = 1; i < intervals.length; i++) {
			int[] preInterval = stack.peek();
			int[] nowInterval = intervals[i];
			if (checkMerge(preInterval, nowInterval)) {
				stack.pop(); // remove nowInterval
				// merge
				nowInterval[0] = Math.min(preInterval[0], nowInterval[0]);
				nowInterval[1] = Math.max(preInterval[1], nowInterval[1]);
			}
			stack.push(nowInterval);
		}
		int[][] result = new int[stack.size()][];
		for (int i = stack.size() - 1; i >= 0; i--) {
			result[i] = stack.pop();
		}
		return result;
	}

	private boolean checkMerge(int[] preInterval, int[] nowInterval) {
		// need merge if preEnd is bigger than now start
		if (nowInterval[0] <= preInterval[1]) {
			return true;
		}
		return false;
	}
}
