package wan.leetcode.dynamicprogramming;

import java.util.Arrays;
import java.util.List;

public class Word_Break_139 {
	public boolean wordBreak(String s, List<String> wordDict) {
		// check every length of the substrings of s can be made
		// so the index is from 0 to s.length
		// compareResult[0] - > empty string can be made ? Of course.
		// compaterResult[s.length] -> the whole string can be made ?
		boolean[] compareResult = new boolean[s.length() + 1];
		Arrays.fill(compareResult, false);
		compareResult[0] = true;

		for (int i = 1; i <= s.length(); i++) {
			for (String word : wordDict) {
				// if the word length is greater than the substring length, we pass
				if (word.length() > i) {
					continue;
				}
				// the the first part of substring can be made, then we check the second part is
				// equals to word or not
				// "leetcode" -> when we are checking compareResult[8]
				// if compareResult[i - word.length] = compareResult[8 - 4] = = compareResult[4]
				// is true
				// then we check s.substring(4 -> i) can be made
				if (compareResult[i - word.length()] && word.equals(s.substring(i - word.length(), i))) {
					compareResult[i] = true;
					break;
				}
			}
		}

		return compareResult[s.length()];
	}
}
