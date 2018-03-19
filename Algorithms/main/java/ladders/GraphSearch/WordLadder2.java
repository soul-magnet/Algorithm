package main.java.ladders.GraphSearch;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
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
/*  
   Analysis: The idea is the same. To track the actual ladder, we need to add
   a pointer that points the previous node in the WordNode class.
   
   1. From the previous Word Ladder 1, we know that Breath First Search is 
   a better way than the DFS.
   
   2. The requirement of this question is to output the shortest path, which means 
   if we find one path using BFS, then all the other shortest paths must also 
   in this level, so the search will stop once this level ends.
   
   3. We need to output the exact path, so we need one way to store the paths. 
   
   4. For each words in BFS queue, we still need to use the previous way to generate
   the valid words in the dicts (from 1st to last change every char from 'a' to 'z').
   
   5. Duplicates is permitted with in a level
   	  hem -> hex -> tex -> ted
      hem->  tem -> tex -> ted,  are all valid paths.
      Draw this into a tree structure:
                        hem
                       /    \
                    hex    tem
                      |      |
                    tex     tex
                      |      |
                    ted     ted
     A solution is to erase all the words in the previous level,
      instead of erasing words for each word in the level.

	6. Some experience that i tried and failed:
	 (a). Use a big map to store valid words for each dict(map<string, vector<string>>) 
	 	  Failed: Memory limit exceeds
	 (b)
	 
	7. Use a map to store and retrieve the paths. Map<Sting,Vector<String>>, stores all the previous
	string for current string. Retrieval of the path will need recursion.
	
	8. Because we have the map storing the paths, the standard queue is not needed. 
	Because what we do is searching each level(see the tree above), once we found the path,
	still need to finish that level and apply the output. So two "queue" can be used, 
	one stores the current level words and the one stores the next level words. 
	The next level words are generated from the current level. During the generation of valid words, 
	path can be stored at the same time. When the next level words are all generated,
	if the end string is included, we can output the paths, otherwise, we can erase the words in current level
	and search the next level. This erasing step is helping reducing the dict, and eliminate the case that a cycle exist
	in the path.
	
	9. The dict in the last test case contains about 3,000 words. 
   
 * */
public class WordLadder2 {
	/**
     * @param start, a string
     * @param end, a string
     * @param dict, a set of string
     * @return a list of lists of string
     */
   public List<List<String>> findLadders(String start, String end, Set<String> dict) {
       // write your code here
	   dict.add(end);
	   
	   // Key: the dictionary string; Value: Set<List<String>>.
	   Map<String, Set<List<String>>> map = new HashMap<String, Set<List<String>>>();
	   Queue<String> queue = new LinkedList<String>();
	   
	   List<String> startPath = new ArrayList<String>();
	   startPath.add(start);
	   Set<List<String>> startSet = new HashSet<List<String>>();
	   startSet.add(startPath);
	   queue.offer(start);
	   map.put(start, startSet);
	   
	   List<List<String>> ret = new ArrayList<List<String>>();
	   
	   while(!queue.isEmpty()){
		   String str = queue.poll();
		   
		   if (str.equals(end)){
			   ret.addAll(map.get(end));
			   return ret;
		   }
		   
		   for (int i = 0; i < str.length(); i++){
			   for(int j = 0; j < 26; j++){
				   // Transform it into another word.
				   String newStr = replace(str, i, (char)('a' + j));
				   
				   //If a new word is explored
				   if (dict.contains(newStr)){
					   if(!map.containsKey(newStr)) {
						   // construct a new path set
						   Set<List<String>> prevSet = map.get(str);
						   Set<List<String>> newSet = new HashSet<List<String>>();
						   for (List<String> path : prevSet){
							   List<String>newPath = new ArrayList<String>(path);
							   newPath.add(newStr);
							   newSet.add(newPath);
						   }
						   map.put(newStr, newSet);
						   queue.offer(newStr);
					   } else {
						   Set<List<String>> prevSet = map.get(str);
						   Set<List<String>> newSet = map.get(newStr);
						   
						   Iterator<List<String>> prevIt = prevSet.iterator();
						   Iterator<List<String>> newIt = newSet.iterator();
						   
						   //Increase the path set
						   if (prevIt.next().size() + 1 == newIt.next().size()){
							   for (List<String> path : prevSet){
								   List<String> newPath = new ArrayList<String>(path);
								   newPath.add(newStr);
								   newSet.add(newPath);
								   // queue.offer(newStr); // This will cause TLE.
							   }
						   }
					   }
				   }
			   }
		   }
	   }
	   return ret; // Return an empty set.
	  
   }
   
   // Replace a character at a given index of str, with c. 
   private String replace(String str, int index, char c){
	   StringBuilder sb = new StringBuilder(str);
	   sb.setCharAt(index, c);
	   return sb.toString();
   }
}
