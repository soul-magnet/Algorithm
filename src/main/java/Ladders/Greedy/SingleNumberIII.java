package Greedy;

import java.util.ArrayList;
import java.util.List;

/*
 * Given 2*n + 2 numbers, every numbers occurs twice except two, find them.
 * Example: Given [1,2,2,3,4,4,5,3] return 1 and 5
 * Challenge: O(n) time, O(1) extra space.
 * 
 * Analysis: 
 * 1. Find a bit P that differs result1 from result2
 * 2. Divide the array into two partitions by the number at bit P == 1/0
 * 3. XOR two partitions separately to get two results.
 * */
public class SingleNumberIII {
	/**
     * @param A : An integer array
     * @return : Two integers
     */
	public List<Integer> singleNumberIII(int[] A) {
		int xor = 0;
        for (int i = 0; i < A.length; i++) {
            xor ^= A[i];
        }
        
        /*int lastBit = xor - (xor & (xor -1));
        int group0 = 0, group1 = 0; 
        for (int i  = 0; i < A.length; i++) {
            if (lastBit & A[i] == 0) {
                group0 ^= A[i];
            } else {
                group1 ^= A[i];
            }
        }*/
        
        // xor = re1 ^ re2
        // as re1 != re2 thus xor != 0
        
        int mask = 1;
        while ((mask & xor) == 0)
            mask = mask << 1; //  find the right most bit at position P such that xor@P == 1, we know that re1@P != re2@P. Set the mask = 1(@P)000...
            int xor1 = 0, xor2 = 0; // divide the array elementsinto two partitions according to A[i]@P == 0 / 1
            for (int a : A) {
                if ((mask & a) == 0) // Let's suppose re1@P == 0, then xor1 = [xor each (A[i]@P == 1)] = re1
                xor1 = xor1 ^ a;
                else 
                xor2 = xor2 ^ a; // As re2@P == 0, then [xor each (A[i]@P == 0)] = re2
            }
            
            
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(xor1);
        result.add(xor2);
        return result;
	}
}
