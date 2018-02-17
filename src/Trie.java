import java.util.Scanner;

public class Trie {
	TrieNode root;
	public Trie() {
		root=new TrieNode();
	}
	public void insert(String word) throws Exception {
		TrieNode curNode=root;
		for(int i=0;i<word.length();i++) {
			if(curNode.nodeArr[word.charAt(i)-'a']==null) {
				curNode.nodeArr[word.charAt(i)-'a']=new TrieNode();
			}
			curNode=curNode.nodeArr[word.charAt(i)-'a'];
		}
		curNode.isEndOfWord=true;
	}
	public boolean search(String word) throws Exception{
		boolean isPresent=true;
		TrieNode curNode=root;
		for(int i=0;i<word.length();i++) {
			if(curNode.nodeArr[word.charAt(i)-'a']==null) {
				isPresent=false;
				return isPresent;
			}
			else{
				curNode=curNode.nodeArr[word.charAt(i)-'a'];
			}
		}
		if(curNode.isEndOfWord==false) {
			isPresent=false;
			return isPresent;
		}
		return isPresent;
	}
	public static void main(String args[]) {
		Trie trieObj=new Trie();
		int n,q;
		System.out.println("Enter number of words and number of queries");
		Scanner input=new Scanner(System.in);
		n=input.nextInt();
		q=input.nextInt();
		System.out.println("Enter words to be stored");
		input.nextLine();
		for(int i=0;i<n;i++) {
			String word;
			word=input.nextLine();
			try {
				trieObj.insert(word);
			}
			catch(Exception e) {
				System.out.println("Enter alphabets in smalls only as input");
				i--;
			}
		}
		System.out.println("Enter words to be searched");
		for(int i=0;i<q;i++) {
			String word;
			word=input.nextLine();
			try {
				boolean isPresent;
				isPresent=trieObj.search(word);
				System.out.println(word+" is present: "+isPresent);
			}
			catch(Exception e) {
				System.out.println("Enter alphabets in smalls only as input");
			}
		}
	}
}
