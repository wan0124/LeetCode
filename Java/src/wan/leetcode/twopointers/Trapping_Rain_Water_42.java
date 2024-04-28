package wan.leetcode.twopointers;

public class Trapping_Rain_Water_42 {
	public int trap(int[] height) {
		if (height.length == 1) {
			return 0;
		}

		int left = 0;
		int total = 0;
		int temp = 0;
		// from left to right, if we find a wall equal or higher than the wall we save,
		// than it can trap water
		for (int i = 1; i < height.length; i++) {
			if (height[left] <= height[i]) {
				total += temp;
				temp = 0;
				left = i;
			} else {// sum the water first, but we not sure if it will be added to total because of
					// the missing of the right wall
				temp += (height[left] - height[i]);
			}
		}
		// we should do again from right to left to avoid some situation
		// like this [ 9, 1, 8 ] -> if only the first step, we only get zero because no
		// wall is higher than 9
		// but it exact we can get 7
		int right = height.length - 1;
		temp = 0;
		for (int i = height.length - 2; i >= 0; i--) {
			if (height[right] < height[i]) {// here we have to pass equals, because it has been calculate
				total += temp;
				temp = 0;
				right = i;
			} else {
				temp += height[right] - height[i];
			}
		}

		return total;
	}
}
