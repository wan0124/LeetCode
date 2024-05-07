package wan.leetcode.dynamicprogramming;

public class Maximum_Product_Subarray_152 {
	public int maxProduct(int[] nums) {

		if (nums.length == 1) {
			return nums[0];
		}

		int maxValue = nums[0];

		int[] max = new int[nums.length];
		// because of the negative number, so we need to remember the min value
		int[] min = new int[nums.length];

		max[0] = nums[0];
		min[0] = nums[0];

		for (int i = 1; i < nums.length; i++) {

			// first check if the preMax * nums[i] or the preMin * nums[i] is bigger
			// then compare with itself to ensure we need to open a new substring or not
			max[i] = Math.max(Math.max(nums[i] * max[i - 1], nums[i] * min[i - 1]), nums[i]);
			min[i] = Math.min(Math.min(nums[i] * max[i - 1], nums[i] * min[i - 1]), nums[i]);
			maxValue = Math.max(maxValue, max[i]);
		}

		return maxValue;
	}
}
