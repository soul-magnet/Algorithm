package main.java.ladders.dataStructure;

import java.util.HashMap;
import java.util.TreeSet;

/**
 * 24. LFU Cache - Hard - Related

LFU (Least Frequently Used) is a famous cache eviction algorithm.

For a cache with capacity k, 
if the cache is full and need to evict a key in it, 
the key with the lease frequently used will be kicked out.

Implement set and get method for LFU cache.

Have you met this question in a real interview? Yes
Example
Given capacity=3

set(2,2)
set(1,1)
get(2)
>> 2
get(1)
>> 1
get(2)
>> 2
set(3,3)
set(4,4)
get(3)
>> -1
get(2)
>> 2
get(1)
>> 1
get(4)
>> 4

Related Problems : Hard LRU Cache 22 %
 * */
public class LFUCache {
    class Node{
       int frequency, key, value, recency;

       public Node(int frequency, int key, int value, int recency) {
           this.frequency = frequency;
           this.key = key;
           this.value = value;
           this.recency = recency;
       }
   }
   int size, recent;
   HashMap<Integer, Node> map;
   TreeSet<Node> set;
   // @param capacity, an integer
   public LFUCache(int capacity) {
       recent=0;
       size= capacity;
       map = new HashMap<>();
       set = new TreeSet<Node>(new Comparator<Node>() {
           @Override
           public int compare(Node o1, Node o2) {
               if(o1.frequency==o2.frequency){
                   return o1.recency-o2.recency;
               }
               return o1.frequency-o2.frequency;
           }
       });
   }

   // @param key, an integer
   // @param value, an integer
   // @return nothing
   public void set(int key, int value) {
       if(map.containsKey(key)){
           Node crt = map.get(key) ;
           crt.value=value;
           return;
       }
       if(map.size()==size){
           Node crt= set.first();
           map.remove(crt.key);
           set.remove(crt);
       }
       map.put(key, new Node(0,key,value, ++recent));
       set.add(map.get(key));
       return;
   }

   public int get(int key) {
       if(! map.containsKey(key)){
           return -1;
       }
       Node crt= map.get(key);
       set.remove(crt);
       crt.frequency++;
       crt.recency= ++this.recent;
       set.add(crt);
       return crt.value;
   }
}