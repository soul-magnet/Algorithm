package main.java.ladders.DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * 10. String Permutation II - Medium - Related

Given a string, find all permutations of it without duplicates.

Have you met this question in a real interview? 
Example
Given "abb", return ["abb", "bab", "bba"].

Given "aabb", return ["aabb", "abab", "baba", "bbaa", "abba", "baab"].

Tags 
Permutation String Recursion
Related Problems 
Easy String Permutation 29 %
 * 
 * */
public class StringPermutation2 {
	public List<String> stringPermutation2(String str) {
        List<String> res = new ArrayList<>();
        if(str.equals(null)){
            return res;
        }
        char[] dic = str.toCharArray();
        Arrays.sort(dic);
        boolean [] visited = new boolean[str.length()];
        dfs(dic, visited, res, new String() );
        return res;
    }

    private void dfs(char[] dic, boolean[] visited, List<String> res, String s) {
        if(s.length()==dic.length){
            res.add(new String (s));
            return;
        }
        for (int i=0; i< dic.length;i++){
            if(visited[i]==true||(i!=0&& dic[i]==dic[i-1]&& visited[i-1]==false)){
                continue;
            }
            visited[i]=true;
            s=s+dic[i];
            dfs(dic,visited,res,s);
            //backtracking
            visited[i]=false;
            s=s.substring(0,s.length()-1);
        }
    }

}
