package main.java.ladders.Trie;

import java.util.HashMap;

/**
 * 442. Implement Trie - Medium

Implement a trie with insert, search, and startsWith methods.

 Notice
You may assume that all inputs are consist of lowercase letters a-z.

Example
insert("lintcode")
search("code")
>>> false
startsWith("lint")
>>> true
startsWith("linterror")
>>> false
insert("linterror")
search("lintcode)
>>> true
startsWith("linterror")
>>> true
Tags 
Trie Google Facebook Uber
Related Problems 
Hard Word Squares 30 %
Medium Add and Search Word 23 %
 * */

/**
 * Your Trie object will be instantiated and called as such:
 * Trie trie = new Trie();
 * trie.insert("lintcode");
 * trie.search("lint"); will return false
 * trie.startsWith("lint"); will return true
 */

class TrieNode {
	// Initialize your data structure here.
	public char c;
	public boolean hasWord;
	public HashMap<Character, TrieNode> hm;
	public TrieNode() {
		hm = new HashMap<>();
	}
	public TrieNode(char c) {
		hm = new HashMap<>();
		this.c = c;
	}
}
public class Trie {
	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	// Inserts a word into the trie.
	public void insert(String word) {
		TrieNode root = this.root;
		for(char i: word.toCharArray()){
			if(!root.hm.containsKey(i)){
				TrieNode now = new TrieNode(i);
				root.hm.put(i, now);
			}
			root = root.hm.get(i);
		}
		root.hasWord = true;
	}

	// Returns if the word is in the trie.
	public boolean search(String word) {
		TrieNode root = this.root;
		for( char i : word.toCharArray()){
			if(root.hm.containsKey(i)){
				root = root.hm.get(i);
			}
			else{
				return false;
			}
		}
		return root.hasWord;
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
		TrieNode root = this.root;
		for( char i : prefix.toCharArray()){
			if(root.hm.containsKey(i)){
				root = root.hm.get(i);
			}
			else{
				return false;
			}
		}
		return true;
	}

}
