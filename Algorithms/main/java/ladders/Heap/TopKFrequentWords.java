package main.java.ladders.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 471. Top K Frequent Words - Medium - Optional
 
Given a list of words and an integer k, return the top k frequent words in the list.

 Notice
You should order the words by the frequency of them in the return list, 
the most frequent one comes first. If two words has the same frequency, 
the one with lower alphabetical order come first.

Example
Given

[
    "yes", "lint", "code",
    "yes", "code", "baby",
    "you", "baby", "chrome",
    "safari", "lint", "code",
    "body", "lint", "code"
]
for k = 3, return ["code", "lint", "baby"].

for k = 4, return ["code", "lint", "baby", "yes"],

Challenge 
Do it in O(nlogk) time and O(n) extra space.

Extra points if you can do it in O(n) time with O(k) extra space approximation algorithms.

Tags: Hash Table Heap Priority Queue

Related Problems 
Hard Top K Frequent Words II 19 %
Medium Top K Frequent Words (Map Reduce) 22 %
Medium Top k Largest Numbers II 29 %
Medium Top k Largest Numbers 35 %
 * */
public class TopKFrequentWords {
	/**
     * @param words an array of string
     * @param k an integer
     * @return an array of string
     */
     class Pair {
	    String key;
	    int value;
	    
	    Pair(String key, int value) {
	        this.key = key;
	        this.value = value;
	    }
	}
    private Comparator<Pair> pairComparator = new Comparator<Pair>() {
        public int compare(Pair left, Pair right) {
            if (left.value != right.value) {
                return left.value - right.value;
            }
            return right.key.compareTo(left.key);
        }
    };
    
    public String[] topKFrequentWords(String[] words, int k) {
       
        if (k == 0) {
            return new String[0];
        }
        
        HashMap<String, Integer> counter = new HashMap<>();
        for (String word : words) {
            if (counter.containsKey(word)) {
                counter.put(word, counter.get(word) + 1);
            } else {
                counter.put(word, 1);
            }
        }
        
        PriorityQueue<Pair> Q = new PriorityQueue<Pair>(k, pairComparator);
        for (String word : counter.keySet()) {
            Pair peak = Q.peek();
            Pair newPair = new Pair(word, counter.get(word));
            if (Q.size() < k) {
                Q.add(newPair);
            } else if (pairComparator.compare(newPair, peak) > 0) {
                Q.poll();
                Q.add(new Pair(word, counter.get(word)));
            }
        }
        
        String[] result = new String[k];
        int index = 0;
        while (!Q.isEmpty()) {
            result[index++] = Q.poll().key;
        }
        
        // reverse
        for (int i = 0; i < index / 2; i++) {
            String temp = result[i];
            result[i] = result[index - i - 1];
            result[index - i - 1] = temp;
        }
        
        return result;
     
    }

}
