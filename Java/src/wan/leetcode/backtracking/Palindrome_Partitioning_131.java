package wan.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Palindrome_Partitioning_131 {
	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<List<String>>();
		this.backtrack(result, new ArrayList<String>(), 0, s);
		return result;
	}

	private void backtrack(List<List<String>> result, List<String> tempList, int index, String s) {
		if (index == s.length()) {
			result.add(new ArrayList<String>(tempList));
			return;
		}
		for (int i = index; i < s.length(); i++) {
			if (checkPalindrome(s, index, i)) {
				tempList.add(s.substring(index, i + 1));
				this.backtrack(result, tempList, i + 1, s);
				tempList.remove(tempList.size() - 1);
			}
		}
	}

	private boolean checkPalindrome(String s, int start, int end) {
		while (start < end) {
			if (s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
}
