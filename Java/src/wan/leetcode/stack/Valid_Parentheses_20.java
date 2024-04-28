package wan.leetcode.stack;

import java.util.Stack;

public class Valid_Parentheses_20 {
	public boolean isValid(String s) {
		if (s.length() == 1) {
			return false;
		}

		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			switch (c) {
			case ')':
				if (stack.isEmpty() || stack.pop() != '(') {
					return false;
				}
				break;
			case ']':
				if (stack.isEmpty() || stack.pop() != '[') {
					return false;
				}
				break;
			case '}':
				if (stack.isEmpty() || stack.pop() != '{') {
					return false;
				}
				break;
			default:
				stack.push(c);
				break;
			}
		}

		return stack.isEmpty();
	}

}
