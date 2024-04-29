package wan.leetcode.binarysearch;

public class Find_Minimum_in_Rotated_Sorted_Array_153 {
	public int findMin(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}

		int lowerBound = nums[0];
		int upperBound = nums[nums.length - 1];

		// no rotated
		if (lowerBound < upperBound) {
			return nums[0];
		}
		int left = 0;
		int right = nums.length - 1;
		int minimun = lowerBound;

		while (left <= right) {
			int index = (left + right) / 2;
			if (nums[index] < minimun) {
				minimun = nums[index];
			}

			if (nums[index] > upperBound) {
				left = index + 1;
			} else {
				right = index - 1;
			}
		}

		return minimun;
	}
}
