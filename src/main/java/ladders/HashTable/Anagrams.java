package main.java.ladders.HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 171. Anagrams - Medium
e
Given an array of strings, return all groups of strings that are anagrams.

 Notice
All inputs will be in lower-case

Example
Given ["lint", "intl", "inlt", "code"], return ["lint", "inlt", "intl"].

Given ["ab", "ba", "cd", "dc", "e"], return ["ab", "ba", "cd", "dc"].

Challenge 
What is Anagram?
- Two strings are anagram if they can be the same after change the order of characters.

Tags: Hash Table String Facebook Uber

Related Problems 
Easy Find Anagram Mappings 59 %
Medium Group Anagrams 38 %
Easy Strings Homomorphism 29 %
Easy Substring Anagrams 24 %
Easy Two Strings Are Anagrams 31 %
 * */
public class Anagrams {
	 /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
	public List<String> anagrams(String[] strs) {
		HashMap<Integer, List<String>> dic = new HashMap<>();
        List<String> res = new ArrayList<>();
        for(String crt: strs){
            int[] ct = new int[26];
            for(char a : crt.toCharArray()){
                ct[a-'a']++;
            }
            int hash = getHashKey(ct);
            if(dic.containsKey(hash)){
               dic.get(hash).add(crt);
            }else{
                List<String> path = new ArrayList<>();
                path.add(crt);
                dic.put(hash,path);
            }
        }
        for(List<String> path: dic.values()){
            if(path.size()>1){
                res.addAll(path);
            }

        }
        return  res;
	}

	private int  getHashKey(int []ct){
	    int hash = 0;
        int a = 378551;
        int b = 63689;
        for (int num : ct) {
            hash = hash * a + num;
            a = a * b;
        }
        return hash;
    }

}
