package wan.leetcode.dynamicprogramming;

public class Coin_Change_322 {
	public int coinChange(int[] coins, int amount) {
		int[] maxCoins = new int[amount + 1];

		for (int i = 1; i < maxCoins.length; i++) {
			// the min coin is 1, so the max coins count for this amount is amount
			// so there is no number less than this
			// but maybe will overflow?
			maxCoins[i] = amount + 1;
		}

		for (int i = 1; i <= amount; i++) {
			for (int coin : coins) {
				if (coin > i) {
					continue;
				}
				// if we want to pick up this coin
				// we have to check the maxCoins of (i-coin)
				// then plus one
				// also we need to check the min
				maxCoins[i] = Math.min(maxCoins[i], maxCoins[i - coin] + 1);

			}
		}
		// if nothing change, it means we can't find the coins pattern
		return maxCoins[amount] == amount + 1 ? -1 : maxCoins[amount];
	}
}
