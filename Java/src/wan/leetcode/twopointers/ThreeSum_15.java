package wan.leetcode.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {
	public List<List<Integer>> threeSum(int[] nums) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		Arrays.sort(nums);
		// fix left first
		for (int left = 0; left < nums.length - 2; left++) {
			// because of the repeat value, try to skip them
			if (left != 0 && nums[left] == nums[left - 1]) {
				continue;
			}
			int complement = 0 - nums[left];
			// just like two sum
			int middle = left + 1;
			int right = nums.length - 1;

			while (middle < right) {
				if (nums[middle] + nums[right] == complement) {
					List<Integer> pair = new ArrayList<Integer>();
					pair.add(nums[left]);
					pair.add(nums[middle]);
					pair.add(nums[right]);
					result.add(pair);
					// because of the repeat value, try to skip them
					while (middle < right) {
						middle++;
						if (nums[middle] != nums[middle - 1]) {
							break;
						}
					}
					while (middle < right) {
						right--;
						if (nums[right] != nums[right + 1]) {
							break;
						}
					}
				} else if (nums[middle] + nums[right] < complement) {
					middle++;
				} else {
					right--;
				}
			}
		}

		return result;
	}
}
