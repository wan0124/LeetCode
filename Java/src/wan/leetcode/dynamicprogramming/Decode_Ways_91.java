package wan.leetcode.dynamicprogramming;

public class Decode_Ways_91 {
	public int numDecodings(String s) {
		if (s.charAt(0) == '0') {
			return 0;
		}
		if (s.length() == 1) {
			return 1;
		}
		if (s.length() == 2) {
			if (s.charAt(1) == '0') {
				return this.checkIsTwoCharLetter(s, 0, 1) ? 1 : 0;
			}
			return this.checkIsTwoCharLetter(s, 0, 1) ? 2 : 1;
		}

		int[] ways = new int[s.length()];
		ways[0] = 1;
		ways[1] = s.charAt(1) == '0' ? this.checkIsTwoCharLetter(s, 0, 1) ? 1 : 0
				: this.checkIsTwoCharLetter(s, 0, 1) ? 2 : 1;

		for (int i = 2; i < s.length(); i++) {
			if (s.charAt(i) == '0') {
				if (!this.checkIsTwoCharLetter(s, i - 1, i)) {
					return 0;
				}
				ways[i] += ways[i - 2];
			} else {
				ways[i] += ways[i - 1];
				if (this.checkIsTwoCharLetter(s, i - 1, i)) {
					ways[i] += ways[i - 2];
				}
			}
		}

		return ways[ways.length - 1];
	}

	private boolean checkIsTwoCharLetter(String s, int start, int end) {
		int value = Integer.valueOf(s.substring(start, end + 1));
		if (value < 10) {
			return false;
		}
		if (value > 26) {
			return false;
		}

		return true;

	}
}
