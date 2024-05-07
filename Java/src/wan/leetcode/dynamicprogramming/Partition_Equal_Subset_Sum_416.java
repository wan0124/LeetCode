package wan.leetcode.dynamicprogramming;

import java.util.Arrays;

public class Partition_Equal_Subset_Sum_416 {
	public boolean canPartition(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}

		// if it is odd, then it can't be split
		if (sum % 2 != 0) {
			return false;
		}

		int target = sum / 2;

		boolean[] canRepresent = new boolean[target + 1];

		Arrays.fill(canRepresent, false);

		canRepresent[0] = true;
		for (int num : nums) {
			for (int j = target; j >= num; j--) {
				if (canRepresent[j - num])
					canRepresent[j] = true;
			}
		}

		return canRepresent[target];

	}
}
