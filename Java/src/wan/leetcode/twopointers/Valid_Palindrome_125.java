package wan.leetcode.twopointers;

public class Valid_Palindrome_125 {
	public boolean isPalindrome(String s) {
		if (s.length() == 1) {
			return true;
		}
		int left = 0;
		int right = s.length() - 1;

		s = s.toLowerCase();

		while (true) {
			// if left isn't out of bound and is not the char we care
			while (left < s.length() && !judgeTheChar(s.charAt(left))) {
				left++;
			}
			// same as right
			while (right >= 0 && !judgeTheChar(s.charAt(right))) {
				right--;
			}
			if (left > right) {
				break;
			}
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			// after check, go through
			left++;
			right--;
		}

		return true;

	}

	private boolean judgeTheChar(char c) {
		if (c >= 'a' && c <= 'z') {
			return true;
		}
		if (c >= '0' && c <= '9') {
			return true;
		}
		return false;
	}
}
