package wan.leetcode.dynamicprogramming;

import java.util.Arrays;

public class Longest_Increasing_Subsequence_300 {
	public int lengthOfLIS(int[] nums) {
		int[] maxLengthOfSub = new int[nums.length];
		Arrays.fill(maxLengthOfSub, 1);

		int maxLength = 0;
		// check from start to end
		// calculate the longest increasing subsequence between this
		for (int end = 0; end < nums.length; end++) {
			for (int start = 0; start < end; start++) {
				if (nums[end] > nums[start]) {
					maxLengthOfSub[end] = Math.max(maxLengthOfSub[end], maxLengthOfSub[start] + 1);
				}
			}
			maxLength = Math.max(maxLength, maxLengthOfSub[end]);
		}

		return maxLength;
	}
}
