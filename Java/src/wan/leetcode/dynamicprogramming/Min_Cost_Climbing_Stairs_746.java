package wan.leetcode.dynamicprogramming;

public class Min_Cost_Climbing_Stairs_746 {
	public int minCostClimbingStairs(int[] cost) {
		// why the length is cost.length + 1
		// because the top of the stairs is cost.length + 1;
		int[] minCost = new int[cost.length + 1];
		minCost[0] = 0;
		minCost[1] = 0;
		for (int i = 2; i < minCost.length; i++) {
			minCost[i] = Math.min(minCost[i - 1] + cost[i - 1], minCost[i - 2] + cost[i - 2]);
		}

		return minCost[minCost.length - 1];
	}
}
