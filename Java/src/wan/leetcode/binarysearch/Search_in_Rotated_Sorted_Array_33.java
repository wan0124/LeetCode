package wan.leetcode.binarysearch;

public class Search_in_Rotated_Sorted_Array_33 {
	public int search(int[] nums, int target) {
		if (nums.length == 1) {
			return nums[0] == target ? 0 : -1;
		}

		int upperBound = nums[nums.length - 1];

		boolean isTargetInLeftSide = target > upperBound ? true : false;

		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int index = (left + right) / 2;
			int num = nums[index];

			if (num == target) {
				return index;
			}

			boolean isNumInLeftSide = num > upperBound ? true : false;
			// are the num and the target in the same side
			if ((isTargetInLeftSide && isNumInLeftSide) || (!isTargetInLeftSide && !isNumInLeftSide)) {
				if (num < target) {
					left = index + 1;
				} else {
					right = index - 1;
				}
			} else if (isTargetInLeftSide && !isNumInLeftSide) {// target in left side, but num in right side
				right = index - 1;
			} else if (!isTargetInLeftSide && isNumInLeftSide) {// target in right side, but num in left side
				left = index + 1;
			}
		}

		return -1;
	}
}
