package wan.leetcode.stack;

import java.util.Stack;

public class Daily_Temperatures_739 {

	class DailyTemperature {
		int day;
		int temperature;

		public DailyTemperature(int day, int temperature) {
			this.day = day;
			this.temperature = temperature;
		}
	}

	public int[] dailyTemperatures(int[] temperatures) {

		if (temperatures.length == 1) {
			return new int[] { 0 };
		}

		int[] result = new int[temperatures.length];

		Stack<DailyTemperature> stack = new Stack<DailyTemperature>();

		for (int i = 0; i < temperatures.length; i++) {
			while (!stack.isEmpty() && stack.peek().temperature < temperatures[i]) {
				DailyTemperature pastDay = stack.pop();
				result[pastDay.day] = i - pastDay.day;
			}
			stack.push(new DailyTemperature(i, temperatures[i]));
		}

		return result;
	}
}
