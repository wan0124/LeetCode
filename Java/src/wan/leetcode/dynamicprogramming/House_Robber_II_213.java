package wan.leetcode.dynamicprogramming;

public class House_Robber_II_213 {
	public int rob(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}

		if (nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}

		return Math.max(this.robWithinTheRange(0, nums.length - 1, nums), this.robWithinTheRange(1, nums.length, nums));
	}

	private int robWithinTheRange(int start, int end, int[] nums) {
		int[] maxAmount = new int[end - start + 1];
		maxAmount[start] = nums[start];
		maxAmount[start + 1] = Math.max(nums[start], nums[start + 1]);
		for (int i = start + 2; i < end; i++) {
			maxAmount[i] = Math.max(nums[i] + maxAmount[i - 2], maxAmount[i - 1]);
		}
		return maxAmount[end - 1];
	}
}
