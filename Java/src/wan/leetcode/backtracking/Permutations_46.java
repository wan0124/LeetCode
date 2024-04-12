package wan.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations_46 {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		this.backtrack(result, new ArrayList<Integer>(), nums);
		return result;
	}

	private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
		if (tempList.size() == nums.length) {
			result.add(new ArrayList<Integer>(tempList));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (tempList.contains(nums[i])) {
				continue;
			}
			tempList.add(nums[i]);
			this.backtrack(result, tempList, nums);
			tempList.remove(tempList.size() - 1);
		}
	}
}
