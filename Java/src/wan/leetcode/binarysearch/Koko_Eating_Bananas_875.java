package wan.leetcode.binarysearch;

public class Koko_Eating_Bananas_875 {
	public int minEatingSpeed(int[] piles, int h) {
		int minSpeed = 1;
		int maxSpeed = 0;
		for (int i = 0; i < piles.length; i++) {
			maxSpeed = Math.max(maxSpeed, piles[i]);
		}
		int targetSpeed = maxSpeed;
		while (minSpeed <= maxSpeed) {
			int speed = (maxSpeed + minSpeed) / 2;
			boolean isMoreThanLimit = calDays(piles, speed, h);

			if (isMoreThanLimit) {
				minSpeed = speed + 1;
			} else {
				targetSpeed = Math.min(targetSpeed, speed);
				maxSpeed = speed - 1;
			}
		}

		return targetSpeed;

	}

	private boolean calDays(int[] piles, int speed, int limitDay) {
		for (int i = 0; i < piles.length; i++) {
			limitDay -= piles[i] / speed;
			if (piles[i] % speed > 0) {
				limitDay--;
			}
		}
		return limitDay < 0;
	}
}
