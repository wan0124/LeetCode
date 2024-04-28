package wan.leetcode.stack;

public class Min_Stack_155 {

	class MinStack {

		class Node {
			int min;
			int val;
			Node preNode;

			public Node(int min, int val, Node preNode) {
				this.min = min;
				this.val = val;
				this.preNode = preNode;
			}
		}

		Node head = null;

		public MinStack() {

		}

		public void push(int val) {
			if (head == null) {
				head = new Node(val, val, null);
			} else {
				head = new Node(Math.min(val, head.min), val, head);
			}
		}

		public void pop() {
			head = head.preNode;
		}

		public int top() {
			return head.val;
		}

		public int getMin() {
			return head.min;
		}
	}

	/**
	 * Your MinStack object will be instantiated and called as such: MinStack obj =
	 * new MinStack(); obj.push(val); obj.pop(); int param_3 = obj.top(); int
	 * param_4 = obj.getMin();
	 */
}
