package wan.leetcode.graph;

public class Redundant_Connection_684 {
	public int[] findRedundantConnection(int[][] edges) {
		int[] parent = new int[2001];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}

		for (int[] e : edges) {
			int from = e[0];
			int to = e[1];
			if (this.find(from, parent) == this.find(to, parent)) {
				return e;
			}
			this.union(from, to, parent);
		}
		return new int[2];
	}

	private int find(int node, int[] parent) {
		while (node != parent[node]) {
			node = parent[node];
		}
		return node;
	}

	private void union(int a, int b, int[] parent) {
		int aRoot = find(a, parent);
		int bRoot = find(b, parent);
		if (aRoot == bRoot) {
			return;
		}
		parent[aRoot] = bRoot;
	}
}
