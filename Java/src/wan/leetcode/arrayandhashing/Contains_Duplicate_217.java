package wan.leetcode.arrayandhashing;

import java.util.HashSet;
import java.util.Set;

public class Contains_Duplicate_217 {
	public boolean containsDuplicate(int[] nums) {
		Set<Integer> hashSet = new HashSet<Integer>();

		for (int num : nums) {
			if (!hashSet.add(num)) {
				return true;
			}
		}

		return false;
	}
}
