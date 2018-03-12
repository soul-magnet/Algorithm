package main.java.ladders.BreadthFirstSearch;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 624. Remove Substrings - Medium - Optional

Given a string s and a set of n substrings. 
You are supposed to remove every instance of those n substrings from s so that s is of the minimum length and 
output this minimum length.

Example
Given s = ccdaabcdbb, substrs = ["ab", "cd"]
Return 2

Explanation: 
ccdaabcdbb -> ccdacdbb -> cabb -> cb (length = 2)

Tags 
String Amazon
 * */

public class RemoveSubstring {
    /*
     * @param s: a string
     * @param dict: a set of n substrings
     * @return: the minimum length
     */
    public int minLength(String s, Set<String> dict) {
        
        Queue<String> que = new LinkedList<String>();
        Set<String> hash = new HashSet<String>();
    
        int min = s.length();
        que.offer(s);
        hash.add(s);

        while (!que.isEmpty()) {
            s = que.poll();
            for (String sub : dict) {
                int found = s.indexOf(sub);
                while (found != -1) {
                    String new_s = s.substring(0, found) +
                        s.substring(found + sub.length(), s.length());
                    if (!hash.contains(new_s)) {
                        if (new_s.length() < min)
                            min = new_s.length();
                        que.offer(new_s);
                        hash.add(new_s);
                    }
                    found = s.indexOf(sub, found + 1);
                }
            }
        }
        return min;
    }
}
