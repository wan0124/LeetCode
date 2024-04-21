package wan.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {
	private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int index) {
		result.add(new ArrayList<Integer>(tempList));
		for (int i = index; i < nums.length; i++) {
			tempList.add(nums[i]);
			this.backtrack(result, tempList, nums, i + 1);
			tempList.remove(tempList.size() - 1);
		}

	}

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		this.backtrack(result, new ArrayList<Integer>(), nums, 0);
		return result;
	}
}
