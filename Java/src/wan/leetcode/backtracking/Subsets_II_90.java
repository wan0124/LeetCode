package wan.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_II_90 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		this.backtrack(result, new ArrayList<Integer>(), 0, nums);
		return result;
	}

	private void backtrack(List<List<Integer>> result, List<Integer> tempList, int index, int[] nums) {

		result.add(new ArrayList<Integer>(tempList));

		for (int i = index; i < nums.length; i++) {
			if (i != index && nums[i - 1] == nums[i]) {
				continue;
			}
			tempList.add(nums[i]);
			this.backtrack(result, tempList, i + 1, nums);
			tempList.remove(tempList.size() - 1);
		}
	}
}
