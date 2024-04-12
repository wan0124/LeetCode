package wan.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum_39 {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		this.backtrack(result, new ArrayList<Integer>(), target, 0, 0, candidates);
		return result;
	}

	public void backtrack(List<List<Integer>> result, List<Integer> tempList, int target, int sum, int index,
			int[] candidates) {
		if (sum == target) {
			result.add(new ArrayList<Integer>(tempList));
			return;
		} else if (sum > target) {
			return;
		}

		for (int i = index; i < candidates.length; i++) {
			tempList.add(candidates[i]);
			sum += candidates[i];
			this.backtrack(result, tempList, target, sum, i, candidates);
			tempList.remove(tempList.size() - 1);
			sum -= candidates[i];
		}
	}
}
