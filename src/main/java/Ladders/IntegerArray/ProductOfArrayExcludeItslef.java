package IntegerArray;

import java.util.ArrayList;

/*Given an integers array A.
 * Define B[i] = A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1], 
 * calculate B WITHOUT divide operation.
 * Example : For A = [1, 2, 3], return [6, 3, 2].
 * */

public class ProductOfArrayExcludeItslef {
	/**
     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        ArrayList<Long> result = new ArrayList<Long>();
        if (A == null || A.size() == 0){
            return result;
        }
        
        // LeftToEnd = A[0] * ....*A[i -1]
        long leftToI = 1;
        result.add(leftToI);
        for (int i = 1; i < A.size(); i++) {
        	leftToI *= A.get(i - 1);
        	result.add(leftToI);
        }
        
        // RightToI = A[i - 1] * A[i + 1] * .... *A[n - 1]
        long rightToI = 1;
        result.set(A.size() - 1, result.get(A.size() - 1) * rightToI);
        for (int i = A.size() - 2; i >= 0; i--){
        	rightToI *= A.get(i + 1);
        	result.set(i, result.get(i) * rightToI);
        }
        
        return result;
    }
}
