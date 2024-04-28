package wan.leetcode.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Evaluate_Reverse_Polish_Notation_150 {
	public int evalRPN(String[] tokens) {
		Stack<String> stack = new Stack<String>();
		List<String> operators = Arrays.asList(new String[] { "+", "-", "*", "/" });
		for (String s : tokens) {
			if (operators.contains(s)) {
				stack.push(String.valueOf(this.calculate(stack, s)));
			} else {
				stack.push(s);
			}
		}
		return Integer.parseInt(stack.pop());
	}

	private int calculate(Stack<String> stack, String operator) {
		int num2 = Integer.parseInt(stack.pop());
		int num1 = Integer.parseInt(stack.pop());
		int result = 0;
		switch (operator) {
		case "+":
			result = num1 + num2;
			break;
		case "-":
			result = num1 - num2;
			break;
		case "*":
			result = num1 * num2;
			break;
		default:
			result = num1 / num2;
			break;
		}

		return result;
	}
}
