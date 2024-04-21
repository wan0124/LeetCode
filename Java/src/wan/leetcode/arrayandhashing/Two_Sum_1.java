package wan.leetcode.arrayandhashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Two_Sum_1 {

	private class Pair {
		int val;
		int pos;

		public Pair(int val, int pos) {
			this.val = val;
			this.pos = pos;
		}
	}

	public int[] twoSum(int[] nums, int target) {
		List<Pair> pairList = new ArrayList<Pair>();
		for (int i = 0; i < nums.length; i++) {
			pairList.add(new Pair(nums[i], i));
		}

		Collections.sort(pairList, new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {

				return o1.val - o2.val;
			}

		});

		int i = 0;
		int j = nums.length - 1;

		while (i < j) {
			int sum = pairList.get(i).val + pairList.get(j).val;
			if (sum == target) {
				return new int[] { pairList.get(i).pos, pairList.get(j).pos };
			}
			if (sum < target) {
				i++;
			}
			if (sum > target) {
				j--;
			}
		}

		return new int[] { -1, -1 };
	}
}
