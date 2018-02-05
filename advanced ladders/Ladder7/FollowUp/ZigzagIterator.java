package Ladder7.FollowUp;

import java.util.Iterator;
import java.util.List;

/**
 * 540. Zigzag Iterator - Medium - Optional

Given two 1d vectors, implement an iterator to return their elements alternately.

Have you met this question in a real interview? Yes
Example
Given two 1d vectors:

v1 = [1, 2]
v2 = [3, 4, 5, 6]
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].

Tags 
Google
Related Problems 
Medium Flatten 2D Vector 45 %
Medium Zigzag Iterator II 33 %
Medium Flatten Nested List Iterator 28 %
Hard Binary Search Tree Iterator 36 %
 * */

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator solution = new ZigzagIterator(v1, v2);
 * while (solution.hasNext()) result.add(solution.next());
 * Output result
 */

public class ZigzagIterator {
	private Iterator<Integer> i1, i2;
    private int ct;
    /**
     * @param v1 v2 two 1d vectors
     */
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        i1=v1.iterator();
        i2= v2.iterator();
        ct=0;
    }

    public int next() {
        ct++;
       if(i1.hasNext()&&i2.hasNext()){
           if(ct%2==1){
               return i1.next();
           }else{
               return i2.next();
           }
       }else if(i1.hasNext()){
           return i1.next();
       }else if(i2.hasNext()){
           return i2.next();
       }
        return -1;
    }

    public boolean hasNext() {
        return i1.hasNext()||i2.hasNext();
    }

}
