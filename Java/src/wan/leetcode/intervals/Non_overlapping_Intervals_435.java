package wan.leetcode.intervals;

import java.util.Arrays;
import java.util.Comparator;

public class Non_overlapping_Intervals_435 {
	public int eraseOverlapIntervals(int[][] intervals) {

		if (intervals.length == 1) {
			return 0;
		}

		Arrays.sort(intervals, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}

		});

		int[] preInterval = intervals[0];

		int count = 0;

		for (int i = 1; i < intervals.length; i++) {
			int[] nowInterval = intervals[i];
			if (this.checkMerge(preInterval, nowInterval)) {
				count++;
				// remove nowInterval if nowInterval end is greater than preInterval
				if (nowInterval[1] >= preInterval[1]) {
					continue;
				}
			}
			preInterval = nowInterval;
		}

		return count;

	}

	private boolean checkMerge(int[] preInterval, int[] nowInterval) {
		if (preInterval[1] > nowInterval[0]) {
			return true;
		}
		return false;
	}
}
