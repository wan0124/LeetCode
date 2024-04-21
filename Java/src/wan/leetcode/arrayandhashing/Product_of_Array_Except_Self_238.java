package wan.leetcode.arrayandhashing;

public class Product_of_Array_Except_Self_238 {
	public int[] productExceptSelf(int[] nums) {
		int[] result = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			result[i] = 1;
		}

		int count = 1;
		// every answer[i] is 1 * answer[0] * .... * answer[i - 1](start from left)
		for (int i = 0; i < nums.length; i++) {
			result[i] = result[i] * count;
			count = count * nums[i];
		}

		count = 1;
		// now let us from right
		for (int i = nums.length - 1; i >= 0; i--) {
			result[i] = result[i] * count;
			count = count * nums[i];
		}

		return result;
	}
}
