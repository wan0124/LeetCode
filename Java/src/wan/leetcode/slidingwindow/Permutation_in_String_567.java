package wan.leetcode.slidingwindow;

public class Permutation_in_String_567 {
	public boolean checkInclusion(String s1, String s2) {
		if (s1.length() > s2.length()) {
			return false;
		}

		int[] hashTable = new int[26];

		for (int i = 0; i < s1.length(); i++) {
			hashTable[s1.charAt(i) - 'a']++;
		}

		int left = 0;
		int right = 0;

		while (right < s2.length()) {
			char c = s2.charAt(right);
			// if hashTable's value less than 0, it means c is not the correct character
			if (--hashTable[c - 'a'] < 0) {
				// we should recover all the character count we minus one before
				while (++hashTable[s2.charAt(left++) - 'a'] != 0) {
				}
			} else {
				if (right - left + 1 == s1.length()) {
					return true;
				}
			}
			right++;
		}

		return false;
	}
}
