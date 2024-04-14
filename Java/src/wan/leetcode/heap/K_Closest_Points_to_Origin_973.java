package wan.leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class K_Closest_Points_to_Origin_973 {

	private class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public int[][] kClosest(int[][] points, int k) {
		PriorityQueue<Point> queue = new PriorityQueue<Point>(new Comparator<Point>() {

			@Override
			public int compare(Point point1, Point point2) {
				return (point2.x * point2.x) - (point1.x * point1.x) + (point2.y * point2.y) - (point1.y * point1.y);
			}

		});

		for (int i = 0; i < points.length; i++) {
			queue.add(new Point(points[i][0], points[i][1]));
			if (queue.size() > k) {
				queue.poll();
			}
		}

		int[][] result = new int[k][2];

		int count = 0;
		while (!queue.isEmpty()) {
			Point point = queue.poll();
			result[count][0] = point.x;
			result[count][1] = point.y;
			count++;
		}

		return result;

	}
}
