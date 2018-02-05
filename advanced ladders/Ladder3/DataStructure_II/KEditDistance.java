package Ladder3.DataStructure_II;
/**
 * 623. K Edit Distance - Hard - Optional
 * Given a set of strings which just has lower case letters and a target string, 
 * output all the strings for each the edit distance with the target no greater than k.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character

Example
Given words = ["abc", "abd", "abcd", "adc"] and target = "ac", k = 1
Return ["abc", "adc"]

Tags: Trie Airbnb Google

Related Problems 
Hard Boggle Game 18 %
Hard Word Squares 31 %
Medium Add and Search Word 23 %
Medium Implement Trie 32 %
Medium Edit Distance 31 %
 * */

//Note to Emine: this is Juizhang solution, i didnt like it; provide your own; i just run to pass the level
//you need to review trie 
class TrieNode {
 // Initialize your data structure here.
 public TrieNode[] children;
 public boolean hasWord;
 public String str;
 
 // Initialize your data structure here.
 public TrieNode() {
     children = new TrieNode[26];
     for (int i = 0; i < 26; ++i)
         children[i] = null;
     hasWord = false;
 }

 // Adds a word into the data structure.
 static public void addWord(TrieNode root, String word) {
     TrieNode now = root;
     for(int i = 0; i < word.length(); i++) {
         Character c = word.charAt(i);
         if (now.children[c - 'a'] == null) {
             now.children[c - 'a'] = new TrieNode();
         }
         now = now.children[c - 'a'];
     }
     now.str = word;
     now.hasWord = true;
 }
}
public class KEditDistance {
	
	 /**
     * @param words a set of stirngs
     * @param target a target string
     * @param k an integer
     * @return output all the strings that meet the requirements
     */
    public List<String> kDistance(String[] words, String target, int k) {
        // Write your code here
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++)
            TrieNode.addWord(root, words[i]);

        List<String> result = new ArrayList<String>();

        int n = target.length();
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; ++i)
            dp[i] = i;

        find(root, result, k, target, dp);
        return result;
    }

    public void find(TrieNode node, List<String> result, int k, String target, int[] dp) {
        int n = target.length();
        // dp[i] 表示从Trie的root节点走到当�?node节点，形�?的Prefix
        // 和 target的�?i个字符的最�?编辑�?离
        if (node.hasWord && dp[n] <= k) {
            result.add(node.str);
        }
        int[] next = new int[n + 1];
        for (int i = 0; i <= n; ++i)
            next[i] = 0;

        for (int i = 0; i < 26; ++i)
            if (node.children[i] != null) {
                next[0] = dp[0] + 1;
                for (int j = 1; j <= n; j++) {
                    if (target.charAt(j - 1) - 'a' == i) {
                        next[j] = Math.min(dp[j - 1], Math.min(next[j - 1] + 1, dp[j] + 1));
                    } else {
                        next[j] = Math.min(dp[j - 1] + 1, Math.min(next[j - 1] + 1, dp[j] + 1));
                    }
                }
                find(node.children[i], result, k, target, next);
            }
    }

}
