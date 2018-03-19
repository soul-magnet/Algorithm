package main.java.ladders.DepthFirstSearch;

import java.util.HashMap;
import java.util.Map;

/**
 * 198. Permutation Index II - Easy - Related
 
Given a permutation which may contain repeated numbers, 
find its index in all the permutations of these numbers, which are ordered in lexicographical order. 
The index begins at 1.

Have you met this question in a real interview? 
Example
Given the permutation [1, 4, 2, 2], return 3.

Related Problems 
Medium Next Permutation II 34 %
 * */
public class PermutaionIndex {
	 /**
     * @param A an integer array
     * @return a long integer
     */
    public long permutationIndexII(int[] A) {
       if (A == null || A.length == 0) return 0L;
        //a[i], cout of a i
        Map<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
        long index = 1, fact = 1, multiFact = 1;
        for (int i = A.length - 1; i >= 0; i--) {
            // collect its repeated times and update multiFact
            if (hashmap.containsKey(A[i])) {
                //22 2*1/2  222 3*2*1/3*2*1 221 3*2*1/2*1
                hashmap.put(A[i], hashmap.get(A[i]) + 1);
                multiFact *= hashmap.get(A[i]);
            } else {
                hashmap.put(A[i], 1);
            }
            // get rank every turns
            int rank = 0;
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] > A[j]) rank++;
            }
            // do divide by multiFact
            index += rank * fact / multiFact;
            fact *= (A.length - i);
        }

        return index;
    }
}
