package main.java.ladders.GraphSearch;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 120. Word Ladder - Medium - Optional

Given two words (start and end), and a dictionary, 
find the length of shortest transformation sequence from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
 Notice
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
Have you met this question in a real interview? 
Example
Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Tags: LinkedIn Breadth First Search

Related Problems 
Hard Word Ladder II 20 %
 * 
 * */
/*  Analysis: So we quickly realize that this is a search problem, and 
 *  breath-first search guarantees the optimal solution.
 *  Tried to use DFS to solve this problem, but got the wrong answer.
 *  The reason is for this problem, we need to get the shortest path 
 *  from one node(start node) to another(end word) in a graph, where each node is 
 *  connected if only one letter is different. 
 *  The end word can be any node in the map.
 *  
 *  Thus we should use BFS level traverse for this case as a easy solution.
 *  */
public class WordLadder {
	/**
     * @param start, a string
     * @param end, a string
     * @param dict, a set of string
     * @return an integer
     */
	
	public int ladderLength(String start, String end, Set<String> dict){
		if (dict == null || dict.size() == 0) {
			return 0;
		}
		
		Queue<String> queue = new LinkedList<String>();
		queue.offer(start);
		dict.remove(start);
		int length = 1;
		
		// BFS Level Traverse
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++){
				// get connections with given word.
				// for example, given word = 'hot', dict = {'hot', 'hit', 'hog'}
				// it will return ['hit', 'hog']
				String current = queue.poll();
				for (char c = 'a'; c <= 'z'; c++){
					for (int j = 0; j < current.length(); j++){
						if (c == current.charAt(j)){
							continue;
						}
						String tmp = replace(current, j, c);
						if(tmp.equals(end)){
							return length + 1;
						}
						if(dict.contains(tmp)){
							queue.offer(tmp);
							dict.remove(tmp);
						}
					}
				}
			}
			length++;
		}
		return 0;
	}
	
	//replace character of a string at given index to a given character
	//return a new string
	private String replace(String s, int index, char c){
		char[] chars = s.toCharArray();
		chars[index] = c;
		return new String(chars);
	}
	
	// version 2: BFS another solution
	
	public int ladderLength2(String start, String end, Set<String> dict) {
        if (start == null || end == null || dict == null){
            return 0;
        }
        // Bug 1: queue is a interface not a class
        Queue<String> q = new LinkedList<String>();
        q.offer(start);
        
        HashSet<String> set = new HashSet<String>();
        set.add(start);
        
        // Bug 3: level start from 1
        int level = 1;
        
        while(!q.isEmpty()){
            int size = q.size();
            level++;
            for (int i = 0; i < size; i++){
                String s = q.poll();
                int len = s.length();
                for (int j = 0; j < len; j++){
                    StringBuilder sb = new StringBuilder(s);
                    for (char c = 'a'; c <= 'z'; c++){
                        // bug 2: setCharAt
                        sb.setCharAt(j, c);
                        String tmp = sb.toString();
                        
                        // should be in the dict and not in the hashSet
                        if (set.contains(tmp) || !dict.contains(tmp))
                            continue;
                        if (tmp.equals(end)){
                            return level;
                        }
                        
                        set.add(tmp);
                        q.offer(tmp);
                    }
                }
            }
        }
        
        // when not found, return 0;
        // "hot", "dog", ["hot", "dog"]
        return 0;
    }
}
