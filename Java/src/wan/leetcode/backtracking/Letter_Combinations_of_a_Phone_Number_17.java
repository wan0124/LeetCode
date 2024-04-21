package wan.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Letter_Combinations_of_a_Phone_Number_17 {
	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<String>();
		if (digits.length() == 0) {
			return result;
		}

		this.backtrack(result, digits, 0, "");
		return result;
	}

	private void backtrack(List<String> result, String digits, int index, String str) {
		if (digits.length() == index) {
			result.add(str);
			return;
		}

		String mappingString = this.numberMapping(digits.charAt(index));
		for (int i = 0; i < mappingString.length(); i++) {
			str += mappingString.charAt(i);
			this.backtrack(result, digits, index + 1, str);
			str = str.substring(0, str.length() - 1);
		}
	}

	private String numberMapping(char num) {
		String mappingString = null;

		switch (num) {
		case '2':
			mappingString = "abc";
			break;
		case '3':
			mappingString = "def";
			break;
		case '4':
			mappingString = "ghi";
			break;
		case '5':
			mappingString = "jkl";
			break;
		case '6':
			mappingString = "mno";
			break;
		case '7':
			mappingString = "pqrs";
			break;
		case '8':
			mappingString = "tuv";
			break;
		case '9':
			mappingString = "wxyz";
			break;
		default:
			mappingString = "";
		}

		return mappingString;
	}
}
