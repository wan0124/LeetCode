package wan.leetcode.arrayandhashing;

public class Valid_Anagram_242 {
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		/*
		 * Map<Character, Integer> map = new HashMap<Character, Integer>();
		 * 
		 * for (int i = 0; i < s.length(); i++) { char c = s.charAt(i); int cnt =
		 * map.getOrDefault(c, 0); map.put(c, ++cnt); }
		 * 
		 * for (int i = 0; i < s.length(); i++) { char c = t.charAt(i); int cnt =
		 * map.getOrDefault(c, 0); if (--cnt < 0) { return false; } map.put(c, cnt); }
		 * 
		 * return true;
		 */

		int[] hashTable = new int[26];
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			hashTable[c - 'a']++;
		}

		for (int i = 0; i < s.length(); i++) {
			char c = t.charAt(i);
			hashTable[c - 'a']--;
			if (hashTable[c - 'a'] < 0) {
				return false;
			}
		}

		return true;
	}

}
