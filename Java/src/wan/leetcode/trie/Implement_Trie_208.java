package wan.leetcode.trie;

import java.util.HashMap;
import java.util.Map;

public class Implement_Trie_208 {
	public static class Trie {
		private TrieNode head;

		public Trie() {
			head = new TrieNode();
		}

		public void insert(String word) {
			char[] chars = word.toCharArray();
			TrieNode node = this.head;
			for (int i = 0; i < chars.length; i++) {
				char c = chars[i];
				Map<Character, TrieNode> childMap = node.childMap;
				if (childMap.containsKey(c)) {// if contains the char
					node = childMap.get(c);
				} else {
					TrieNode newNode = new TrieNode();
					childMap.put(c, newNode);
					node = newNode;
				}
			}
			node.endOfAWord = true;

		}

		public boolean search(String word) {
			char[] chars = word.toCharArray();
			TrieNode node = this.head;
			for (int i = 0; i < chars.length; i++) {
				char c = chars[i];
				Map<Character, TrieNode> childMap = node.childMap;
				if (!childMap.containsKey(c)) {
					return false;
				}
				node = childMap.get(c);
			}
			return node.endOfAWord;
		}

		public boolean startsWith(String prefix) {
			char[] chars = prefix.toCharArray();
			TrieNode node = this.head;
			for (int i = 0; i < chars.length; i++) {
				char c = chars[i];
				Map<Character, TrieNode> childMap = node.childMap;
				if (!childMap.containsKey(c)) {
					return false;
				}
				node = childMap.get(c);
			}
			return true;
		}

		private class TrieNode {

			Map<Character, TrieNode> childMap = null;// mapping the children node with the next charactor
			boolean endOfAWord = false;;

			public TrieNode() {
				this.childMap = new HashMap<Character, TrieNode>();
			}

		}

	}
}
