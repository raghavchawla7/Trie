public class TrieNode {
	Boolean isEndOfWord;
	TrieNode nodeArr[];
	public TrieNode() {
		this.isEndOfWord = false;
		this.nodeArr = new TrieNode[26];
		for(int i=0;i<26;i++) {
			nodeArr[i]=null;
		}
	}
	
}
