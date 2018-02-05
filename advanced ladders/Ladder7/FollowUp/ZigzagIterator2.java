package Ladder7.FollowUp;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 541. Zigzag Iterator II - Medium - Optional

Follow up Zigzag Iterator: What if you are given k 1d vectors? 
How well can your code be extended to such cases? 
The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. 
If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic".

Example
Given k = 3 1d vectors:

[1,2,3]
[4,5,6,7]
[8,9]
Return [1,4,8,2,5,9,3,6,7].

Tags:Google

Related Problems 
Medium Zigzag Iterator 44 %
Medium Flatten Nested List Iterator 28 %
Hard Binary Search Tree Iterator 36 %
 * */

/**
 * Your ZigzagIterator2 object will be instantiated and called as such:
 * ZigzagIterator2 solution = new ZigzagIterator2(vecs);
 * while (solution.hasNext()) result.add(solution.next());
 * Output result
 */
public class ZigzagIterator2 {
	 	int index;
	    ArrayList<Iterator<Integer>> i;
	    /**
	     * @param vecs a list of 1d vectors
	     */
	    public ZigzagIterator2(ArrayList<ArrayList<Integer>> vecs) {
	        index=0;
	        i=new ArrayList<>();
	        for(ArrayList<Integer> crt: vecs){
	            if(crt.size()>0){
	                this.i.add(crt.iterator());
	            }

	        }

	    }

	    public int next() {
	  int crt = i.get(index).next();
	        
	        if(i.get(index).hasNext()){
	            index= (index+1)%i.size();
	        }else {
	            i.remove(index);
	            if(i.size()>0){
	                index= (index)%i.size();
	            }
	        }

	        return crt;
	    }

	    public boolean hasNext() {
	        return i.size()>0;
	    }

}
