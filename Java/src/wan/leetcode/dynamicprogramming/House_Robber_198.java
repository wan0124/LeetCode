package wan.leetcode.dynamicprogramming;

public class House_Robber_198 {
	public int rob(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}

		if (nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}

		int[] maxAmount = new int[nums.length];

		maxAmount[0] = nums[0];
		maxAmount[1] = Math.max(nums[0], nums[1]);

		for (int i = 2; i < nums.length; i++) {
			maxAmount[i] = Math.max(nums[i] + maxAmount[i - 2], maxAmount[i - 1]);
		}

		return maxAmount[maxAmount.length - 1];
	}
}
