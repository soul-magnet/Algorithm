package main.java.ladders.searchAndRecursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
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
public class WordLadder {
	/**
     * @param start, a string
     * @param end, a string
     * @param dict, a set of string
     * @return an integer
     */
   public int ladderLength1(String start, String end, Set<String> dict) {
       HashMap<String, Integer> distance = new HashMap<>();
       HashMap<String, List<String>> adjacentMap = new HashMap<>();
       dict.add(start);
       dict.add(end);
       bfs(dict, distance, adjacentMap, start, end);
       return distance.get(end);
   }

   private void bfs(Set<String> dict, HashMap<String, Integer> distance, HashMap<String, List<String>> adjacentMap, String start, String end) {
       //initialize
       distance.put(start,1);
       if(start.equals(end)){
           return;
       }
       for(String ele: dict){
           adjacentMap.put(ele, new ArrayList<String>());
       }
       Queue<String> q = new LinkedList<>();
       q.offer(start);
       while(!q.isEmpty()){
           String crt = q.poll();
           ArrayList<String>  adjacent = findAdjacent(dict,crt,distance,adjacentMap);
           for (String ele: adjacent){
               if(!distance.containsKey(ele)){
                   distance.put(ele,distance.get(crt)+1);
                   if(ele.equals(end)){
                       return;
                   }
                   q.offer(ele);
               }
           }
       }
   }

   private ArrayList<String> findAdjacent(Set<String> dict, String crt, HashMap<String, Integer> distance, HashMap<String, List<String>> adjacentMap) {
       ArrayList<String>  adjacent = new ArrayList<>();
       for (int i=0; i< crt.length();i++){
           for (char j='a'; j<'z';j++){
               if(dict.contains(crt.substring(0,i)+j+crt.substring(i+1))&&j!=crt.charAt(i)){
                   adjacent.add(crt.substring(0,i)+j+crt.substring(i+1));
               }
           }
       }
       adjacentMap.put(crt,adjacent);
       return adjacent;
   }
   
   //BFS - Queue(%92 test cases passed)
   public int ladderLength2(String start, String end, Set<String> dict) {
       //Use queue to help BFS
       if(start.equals(end)){
           return 0;
       }
       
       Queue<String> queue = new LinkedList<String>();
       queue.add(start);
       queue.add(null);
       
       //Mark visited word
       Set<String> visited = new HashSet<String>();
       visited.add(start);
       
       int level = 1;
       while(!queue.isEmpty()){
           String str = queue.poll();
           
           if(str != null){
               //Modify str's each character(so word distance is 1)
               for(int i = 0; i < str.length(); i++){
                   char[] chars = str.toCharArray(); // converts string to character array
                   
                   for(char c = 'a'; c <= 'z'; c++ ){
                       chars[i] = c;
                       String word = new String(chars);
                       
                       //Found the end word
                       if(word.equals(end)) return level+1;
                       
                       //put it into queue
                       if(dict.contains(word) && !visited.contains(word)){
                           queue.add(word);
                           visited.add(word);
                       }
                   }
               }
           }else{
               level++;
               if(!queue.isEmpty()){
                   queue.add(null);
               }
           }
       }
       
       return 0;
   }
   
   //passed all the test cases
   public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
       Set<String> visited = new HashSet<String>();
       visited.add(beginWord);
       wordDict.add(endWord);
       int distance = 1;
       while (!visited.contains(endWord)) {
           Set<String> toAdd = new HashSet<String>();
           for (String each : visited) {
               for (int i = 0; i < each.length(); i++) {
                   char[] chars = each.toCharArray();
                   for (char ch = 'a'; ch <= 'z'; ch++) {
                       chars[i] = ch;
                       String word = new String(chars);
                       if (wordDict.contains(word)) {
                           toAdd.add(word);
                           wordDict.remove(word);
                       }
                   }
               }
           }
           distance++;
           if (toAdd.size() == 0) return 0;
           visited = toAdd;
       }
       return distance;
   }}
