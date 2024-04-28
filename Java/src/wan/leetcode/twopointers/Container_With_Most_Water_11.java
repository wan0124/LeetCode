package wan.leetcode.twopointers;

public class Container_With_Most_Water_11 {
	public int maxArea(int[] height) {
		int left = 0;
		int right = height.length - 1;
		int maxArea = 0;
		while (left < right) {
			int bound = Math.min(height[left], height[right]);
			maxArea = Math.max(maxArea, bound * (right - left));

			while (right > left && height[right] <= bound) {
				right--;
			}
			while (right > left && height[left] <= bound) {
				left++;
			}
		}
		return maxArea;
	}
}
