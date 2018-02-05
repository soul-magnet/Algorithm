package Ladder1.FollowupCodingInt;
/**
 * Given a string source and a string target, find the minimum window in source which will contain all the characters in target.

 Notice: If there is no such window in source that covers all characters in target, return the empty string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in source.

Clarification: Should the characters in minimum window has the same order in target?

Not necessary.
Example
For source = "ADOBECODEBANC", target = "ABC", the minimum window is "BANC"

Challenge: Can you do it in time complexity O(n) ?

Tags: Hash Table LinkedIn Facebook
1 - Related Problems 
2 - Easy Window Sum
 * 
 * */

public class MinimumWindowSubstring {
    public String minWindow(String Source, String Target) {
		int dic[] = new int [256];
		for(char i : Target.toCharArray()){
			dic[i ]++;
		}
		int l=0, r=0,ct=Target.length(),res = Integer.MAX_VALUE;
		char [] s =Source.toCharArray(); String ans ="";
		while(r<s.length){
			if(dic[s[r++]]-->0){
				ct--;
			}
			while(l<s.length&&ct==0){
			    if(r-l<res){
					res=r-l;
					ans = Source.substring(l,r);
				}
				if(dic[s[l++]]++==0){
					ct++;
				}
			}
		}
		return ans;
	}
    	boolean valid(int[] sourcehash, int[] targethash) {

		for (int i = 0; i < 256; i++) {
			if (targethash[i] > sourcehash[i]) {
				return false;
			}
		}
		return true;
	}
    /**
     * @param source: A string
     * @param target: A string
     * @return: A string denote the minimum window
     *          Return "" if there is no such a string
     */
    public String minWindow1(String source, String target) {
        //global minwindow size 
		 int slen= source.length(); int tlen= target.length();int min=Integer.MAX_VALUE;
		// 2 pointer
		int slow=0; int fast =0; String ans="";
		//map 
		int[] sourcehash= new int [256]; int[] targethash= new int [256];
		for(char i: target.toCharArray()){
			targethash[i]++;
		}
			for (; fast < slen; fast++) {
			sourcehash[source.charAt(fast)]++;
			while (fast - slow + 1 >= tlen && fast - slow + 1 < min
					&& valid(sourcehash, targethash)) {
				ans = source.substring(slow, fast + 1);
				min = fast - slow + 1;
				sourcehash[source.charAt(slow)]--;
				slow++;
			}
		}
		return ans;
		
    }
}
