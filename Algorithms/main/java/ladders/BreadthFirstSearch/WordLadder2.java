package main.java.ladders.BreadthFirstSearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 121. Word Ladder II - Hard - Required

Given two words (start and end), and a dictionary, 
find all shortest transformation sequence(s) from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
 Notice
All words have the same length.
All words contain only lowercase alphabetic characters.

Example
Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
Return
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
  
Tags: Backtracking Depth First Search Breadth First Search
Related Problems 
Medium Parser 23 %
Medium Word Ladder 22 %
 * */
public class WordLadder2 {
	/**
     * @param start, a string
     * @param end, a string
     * @param dict, a set of string
     * @return a list of lists of string
     */
       public List<List<String>> findLadders(String start, String end,
               Set<String> dict) {
           List<List<String>> ladders = new ArrayList<List<String>>();
           Map<String, List<String>> map = new HashMap<String, List<String>>();
           Map<String, Integer> distance = new HashMap<String, Integer>();

           dict.add(start);
           dict.add(end);
           //discover all nodes distance to start
           bfs(map, distance, start, end, dict);

           List<String> path = new ArrayList<String>();

           dfs(ladders, path, end, start, distance, map);

           return ladders;
       }

	   void dfs(List<List<String>> ladders, List<String> path, String crt,
	            String start, Map<String, Integer> distance,
	            Map<String, List<String>> map) {
	       path.add(crt);
	       if (crt.equals(start)) {
	           Collections.reverse(path);
	           ladders.add(new ArrayList<String>(path));
	           Collections.reverse(path);
	       } else {
	           for (String next : map.get(crt)) {
	               if (distance.containsKey(next) && distance.get(crt) == distance.get(next) + 1) {
	                   dfs(ladders, path, next, start, distance, map);
	               }
	           }
	       }
	       path.remove(path.size() - 1);
	   }

	   void bfs(Map<String, List<String>> map, Map<String, Integer> distance,
	            String start, String end, Set<String> dict) {
	       Queue<String> q = new LinkedList<String>();
	       q.offer(start);
	       distance.put(start, 0);
	       for (String s : dict) {
	           map.put(s, new ArrayList<String>());
	       }
	
	       while (!q.isEmpty()) {
	           String crt = q.poll();
	           //discover all of adjacent ele(dis=1)
	           List<String> nextList = expand(crt, dict);
	           //register ele to distance (current ele dis +1);
	           //added to q
	           //imp: only add ele which is not register in distance since if it is already in distance then there is already shorter degree for current ele.
	           for (String next : nextList) {
	               //imp: add current to the next ele's list, distance=1
	               map.get(next).add(crt);
	               if (!distance.containsKey(next)) {
	                   distance.put(next, distance.get(crt) + 1);
	                   q.offer(next);
	               }
	           }
	       }
	   }

	   List<String> expand(String crt, Set<String> dict) {
	       List<String> expansion = new ArrayList<String>();
	
	       for (int i = 0; i < crt.length(); i++) {
	           for (char ch = 'a'; ch <= 'z'; ch++) {
	               if (ch != crt.charAt(i)) {
	                   String expanded = crt.substring(0, i) + ch
	                           + crt.substring(i + 1);
	                   if (dict.contains(expanded)) {
	                       expansion.add(expanded);
	                   }
	               }
	           }
	       }
	
	       return expansion;
	   }

}
