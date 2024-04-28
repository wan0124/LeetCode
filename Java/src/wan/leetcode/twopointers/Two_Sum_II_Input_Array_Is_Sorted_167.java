package wan.leetcode.twopointers;

public class Two_Sum_II_Input_Array_Is_Sorted_167 {
	public int[] twoSum(int[] numbers, int target) {
		int left = 0;
		int right = numbers.length - 1;

		while (left < right) {
			int sum = numbers[left] + numbers[right];
			if (sum == target) {
				return new int[] { left + 1, right + 1 };
			}
			if (sum < target) {
				left++;
			} else {
				right--;
			}

		}

		return new int[] { -1, -1 };
	}
}
