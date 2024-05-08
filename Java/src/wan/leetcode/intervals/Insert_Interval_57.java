package wan.leetcode.intervals;

import java.util.ArrayList;
import java.util.List;

public class Insert_Interval_57 {
	public int[][] insert(int[][] intervals, int[] newInterval) {

		if (intervals.length == 0) {
			return new int[][] { newInterval };
		}

		List<int[]> intervalList = new ArrayList<int[]>();

		int index = 0;

		// the whole interval is on the left side of new interval
		while (index < intervals.length && intervals[index][1] < newInterval[0]) {
			intervalList.add(intervals[index]);
			index++;
		}

		while (index < intervals.length && intervals[index][0] <= newInterval[1]) {
			newInterval[0] = Math.min(intervals[index][0], newInterval[0]);
			newInterval[1] = Math.max(intervals[index][1], newInterval[1]);
			index++;
		}
		intervalList.add(newInterval);

		// the whole interval is on the right side of new interval
		while (index < intervals.length) {
			intervalList.add(intervals[index]);
			index++;
		}

		int[][] result = new int[intervalList.size()][];
		for (int i = 0; i < intervalList.size(); i++) {
			result[i] = intervalList.get(i);
		}

		return result;

	}
}
