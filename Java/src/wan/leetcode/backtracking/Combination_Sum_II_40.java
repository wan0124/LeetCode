package wan.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum_II_40 {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		this.backtrack(result, new ArrayList<Integer>(), 0, 0, target, candidates);
		return result;
	}

	private void backtrack(List<List<Integer>> result, List<Integer> tempList, int index, int sum, int target,
			int[] nums) {
		if (sum == target) {
			result.add(new ArrayList<Integer>(tempList));
			return;
		}

		if (sum > target) {
			return;
		}

		for (int i = index; i < nums.length; i++) {
			if (i != index && nums[i] == nums[i - 1]) {
				continue;
			}
			tempList.add(nums[i]);
			sum += nums[i];
			this.backtrack(result, tempList, i + 1, sum, target, nums);
			tempList.remove(tempList.size() - 1);
			sum -= nums[i];
		}
	}
}
