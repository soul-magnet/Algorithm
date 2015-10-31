package Ladders;

import java.util.ArrayList;
import java.util.Collections;

public class MergeSortedArrayII {
	/**
	 * Merge two given sorted integer array A and B into a new sorted integer array.

Have you met this question in a real interview? Yes
Example
A=[1,2,3,4]

B=[2,4,5,6]

return [1,2,2,3,4,4,5,6]

Challenge
How can you optimize your algorithm if one array is very large and the other is very small?
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public ArrayList<Integer> mergeSortedArray(ArrayList<Integer> A, ArrayList<Integer> B) {
        int len = B.size();
        for (int i = 0; i < len; ++i) 
            A.add(B.get(i));
        Collections.sort(A);
        return A;
    }
}
