package main.java.ladders.BreadthFirstSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 120. Word Ladder - Medium - Required

Given two words (start and end), and a dictionary, 
find the length of shortest transformation sequence from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
 Notice
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.

Example
Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Tags 
LinkedIn Breadth First Search
Related Problems 
Hard Word Ladder II 20 %*/


public class WordLadder {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return an integer
      */
    public int ladderLength(String start, String end, Set<String> dict) {
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
}
