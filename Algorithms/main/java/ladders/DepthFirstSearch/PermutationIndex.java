package main.java.ladders.DepthFirstSearch;
/**
 * 197. Permutation Index - Easy - Related
 
Given a permutation which contains no repeated number, 
find its index in all the permutations of these numbers, 
which are ordered in lexicographical order. The index begins at 1.

Example
Given [1,2,4], return 1.

Related Problems 
Medium Next Permutation II 34 %
Medium Previous Permutation 27 %
 * 
 * */
public class PermutationIndex {
	 /**
     * @param A an integer array
     * @return a long integer
     */
    public long permutationIndex(int[] A) {
       if (A == null || A.length == 0) return 0;

        long index = 1, fact = 1;
        for (int i = A.length - 1; i >= 0; i--) {
            // get rank in every iteration
            int rank = 0;
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] > A[j]) rank++;
            }

            index += rank * fact;
            fact *= (A.length - i);
        }

        return index;
    }

}
