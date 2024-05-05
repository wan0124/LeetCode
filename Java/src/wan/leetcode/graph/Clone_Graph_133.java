package wan.leetcode.graph;

import java.util.HashMap;
import java.util.Map;

import wan.leetcode.graph.datastructure.Node;

public class Clone_Graph_133 {
	Map<Integer, Node> createdNodes = new HashMap<Integer, Node>();

	public Node cloneGraph(Node node) {
		if (node == null)
			return node;

		if (createdNodes.containsKey(node.val)) {
			return createdNodes.get(node.val);
		}

		Node newNode = new Node(node.val);
		createdNodes.put(newNode.val, newNode);
		for (Node neighbor : node.neighbors) {
			newNode.neighbors.add(cloneGraph(neighbor));
		}

		return newNode;
	}
}
