package wan.leetcode.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Kth_Largest_Element_in_an_Array_215 {
	public int findKthLargest(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length - k];
	}

	public int findKthLargest2(int[] nums, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		for (int num : nums) {
			queue.add(num);
			if (queue.size() > k) {
				queue.poll();
			}
		}
		return queue.poll();
	}

	public int findKthLargest3(int[] nums, int k) {
		return this.quickSort(nums, 0, nums.length - 1, k);
	}

	public int quickSort(int[] nums, int start, int end, int k) {
		int pivot = nums[start];
		int i = start + 1;
		int j = end;
		while (true) {
			while (nums[i] < pivot && i <= end) {
				i++;
			}
			while (nums[j] >= pivot && j > start) {
				j--;
			}
			if (i > j) {
				break;
			}
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
		nums[start] = nums[j];
		nums[j] = pivot;

		if (j == nums.length - k) {
			return nums[j];
		}

		if (j < nums.length - k) {
			return quickSort(nums, j + 1, end, k);
		}

		return quickSort(nums, start, j - 1, k);

	}
}
