package wan.leetcode.slidingwindow;

public class Best_Time_to_Buy_and_Sell_Stock_121 {
	public int maxProfit(int[] prices) {
		if (prices.length == 1) {
			return 0;
		}
		int minPrice = prices[0];
		int maxProfit = 0;

		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < minPrice) {
				minPrice = prices[i];
			} else {
				maxProfit = Math.max(maxProfit, prices[i] - minPrice);
			}
		}

		return maxProfit;
	}
}
