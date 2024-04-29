package wan.leetcode.binarysearch;

public class Binary_Search_704 {
	public int search(int[] nums, int target) {
		return this.binarySearch(nums, 0, nums.length - 1, target);
	}

	private int binarySearch(int[] nums, int start, int end, int target) {
		if (start == end) {
			return nums[start] == target ? start : -1;
		}
		int index = (start + end) / 2;

		if (nums[index] == target) {
			return index;
		} else if (nums[index] < target) {
			return this.binarySearch(nums, index + 1 > end ? end : index + 1, end, target);
		} else {
			return this.binarySearch(nums, start, index - 1 < start ? start : index - 1, target);
		}
	}

}
