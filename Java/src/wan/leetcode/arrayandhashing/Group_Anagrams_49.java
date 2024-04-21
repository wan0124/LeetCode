package wan.leetcode.arrayandhashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Group_Anagrams_49 {
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (String str : strs) {
			String groupKey = this.getGroupKey(str);
			List<String> groupList = map.get(groupKey);
			if (groupList == null) {
				groupList = new ArrayList<String>();
				map.put(groupKey, groupList);
			}
			groupList.add(str);
		}

		List<List<String>> result = new ArrayList<List<String>>();
		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
			result.add(entry.getValue());
		}

		return result;
	}

	private String getGroupKey(String s) {
		char[] charArray = s.toCharArray();
		Arrays.sort(charArray);
		return new String(charArray);
	}

}
