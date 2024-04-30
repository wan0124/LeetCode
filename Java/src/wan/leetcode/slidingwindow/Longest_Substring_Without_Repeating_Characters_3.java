package wan.leetcode.slidingwindow;

public class Longest_Substring_Without_Repeating_Characters_3 {
	public int lengthOfLongestSubstring(String s) {
		if (s.length() == 0) {
			return 0;
		}

		int left = 0;

		int maxLength = 0;

		for (int right = 0; right < s.length(); right++) {
			char c = s.charAt(right);
			// without repeating
			if (s.indexOf(c, left, right) == -1) {
				maxLength = Math.max(maxLength, right - left + 1);
			} else {
				// because the repeating character may not the first character in the substring
				// so we have to skip the character until we ensure we pass the repeating
				// character
				while (s.indexOf(c, left, right) != -1) {
					left++;
				}
			}
		}

		return maxLength;
	}
}
