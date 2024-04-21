package wan.leetcode.trie;

public class Design_Add_and_Search_Words_Data_Structure_211 {
	public static class WordDictionary {
		Word head;

		public WordDictionary() {
			this.head = new Word();
		}

		public void addWord(String word) {
			this.addChar(word, 0, head);
		}

		private void addChar(String s, int pos, Word word) {
			if (pos == s.length()) {
				word.isWord = true;
				return;
			}
			Word nextWord = word.words[s.charAt(pos) - 'a'];
			if (nextWord == null) {
				nextWord = new Word();
				word.words[s.charAt(pos) - 'a'] = nextWord;
			}
			this.addChar(s, pos + 1, nextWord);
		}

		public boolean search(String word) {
			return this.searchChar(word, 0, head);
		}

		private boolean searchChar(String s, int pos, Word word) {

			if (pos == s.length()) {
				return word.isWord;
			}

			if ('.' == s.charAt(pos)) {
				Word[] words = word.words;
				boolean isFind = false;
				for (int i = 0; i < 26; i++) {
					if (words[i] != null) {
						isFind = isFind || this.searchChar(s, pos + 1, words[i]);
					}
				}
				return isFind;
			}

			Word[] words = word.words;
			if (words[s.charAt(pos) - 'a'] == null) {
				return false;
			}

			return this.searchChar(s, pos + 1, words[s.charAt(pos) - 'a']);
		}

		private class Word {
			boolean isWord;
			Word[] words = new Word[26];
		}
	}
}
