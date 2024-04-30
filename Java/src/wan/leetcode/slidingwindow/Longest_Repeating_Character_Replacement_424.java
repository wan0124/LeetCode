package wan.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class Longest_Repeating_Character_Replacement_424 {
	public int characterReplacement(String s, int k) {
		if (s.length() == 1) {
			return 1;
		}
		Map<Character, Integer> countMap = new HashMap<Character, Integer>();
		int left = 0;
		int right = 0;
		int maxCharCount = 0;
		int maxLength = 0;
		// we care about the max char count in sliding window
		// because if we want to find the max length
		// we must use the highest counts char in sliding window and plus the k times
		// 用英文太難，簡單來說我們只在意在區間內出現頻率最高的字母
		// 因為就概念上來說，我們找到此區間出現頻率最高的字母，然後把其他非字母的字母都想盡辦法換成與此字母相同
		// 用這種方式可以取得最長的長度
		while (right < s.length()) {
			char c = s.charAt(right);
			int charCount = countMap.getOrDefault(c, 0) + 1;
			countMap.put(c, charCount);
			// 用這個方式來確定此區間內出現頻率最高的字母
			maxCharCount = Math.max(charCount, maxCharCount);
			// 如果最高次數的頻率 + k 比此區間小，代表次數不夠將此區間需要變更的字母都變更
			// 我們只好將此區間縮小
			while (maxCharCount + k < right - left + 1) {
				charCount = countMap.get(s.charAt(left)) - 1;
				countMap.put(s.charAt(left), charCount);
				left++;
			}
			// 比較現在的區間是否有比曾經出現的長度
			maxLength = Math.max(maxLength, right - left + 1);
			// 右移
			right++;
		}

		return maxLength;
	}
}
