package wan.leetcode.dynamicprogramming;

public class Climbing_Stairs_70 {
	public int climbStairs(int n) {
		// if there is only one stair, only one way
		// if there are two stais, two way -> 1 + 1 / 2
		if (n <= 2) {
			return n;
		}
		int[] steps = new int[n];
		steps[0] = 1;
		steps[1] = 2;

		for (int i = 2; i < n; i++) {
			steps[i] = steps[i - 1] + steps[i - 2];
		}

		return steps[n - 1];
	}
}
