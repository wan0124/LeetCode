package wan.leetcode.arrayandhashing;

import java.util.HashSet;
import java.util.Set;

public class Longest_Consecutive_Sequence_128 {
	public int longestConsecutive(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		Set<Integer> set = new HashSet<Integer>();
		for (int num : nums) {
			set.add(num);
		}

		int maxLength = 0;

		for (Integer num : set) {
			if (!set.contains(num - 1)) {
				int count = 0;
				int now = num;
				while (set.contains(now)) {
					count++;
					num++;
				}
				maxLength = Math.max(count, maxLength);
			}
		}

		return maxLength;
	}
}
