package wan.leetcode.binarysearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Time_Based_Key_Value_Store_981 {

	public static class TimeMap {

		class Pair {
			String value;
			int timestamp;

			public Pair(String value, int timestamp) {
				this.value = value;
				this.timestamp = timestamp;
			}
		}

		Map<String, List<Pair>> map = new HashMap<String, List<Pair>>();

		public TimeMap() {
		}

		public void set(String key, String value, int timestamp) {
			List<Pair> pairList = map.get(key);
			if (pairList == null) {
				pairList = new ArrayList<Pair>();
				map.put(key, pairList);
			}
			pairList.add(new Pair(value, timestamp));
		}

		public String get(String key, int timestamp) {
			List<Pair> pairList = map.get(key);

			if (pairList == null) {
				return "";
			}

			int left = 0;
			int right = pairList.size() - 1;
			int index = 0;
			while (left <= right) {
				index = (left + right) / 2;
				Pair pair = pairList.get(index);
				// we find the timestamp
				if (pair.timestamp == timestamp) {
					return pair.value;
				}

				if (pair.timestamp > timestamp) {
					right = index - 1;
				} else {
					left = index + 1;
				}
			}

			// if we are at this position, it means that no pair's timestamp match the input
			// timestamp
			// and the left/right is the closest pair
			if (pairList.get(index).timestamp < timestamp) {
				return pairList.get(index).value;
			}
			// left is bigger than input, so check if it has the prePair
			if (index - 1 >= 0) {
				return pairList.get(index - 1).value;
			}
			// left is the first element, and it is bigger than timestamp, so there is on
			// match timestamp
			return "";
		}

	}

	/**
	 * Your TimeMap object will be instantiated and called as such: TimeMap obj =
	 * new TimeMap(); obj.set(key,value,timestamp); String param_2 =
	 * obj.get(key,timestamp);
	 */

}
