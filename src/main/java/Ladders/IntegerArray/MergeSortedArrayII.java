package IntegerArray;

import java.util.ArrayList;
import java.util.Collections;

/*
 * Merge two given sorted integer array A and B
 * into a new sorted integer array.
 * 
 * Example :
 * A=[1,2,3,4]
 * B=[2,4,5,6]
 * return [1,2,2,3,4,4,5,6]
 * Challenge:
 * How can you optimize your algorithm if one array is very large and the other is very small?
 * */

public class MergeSortedArrayII {
	/*public ArrayList<Integer> mergeSortedArray(ArrayList<Integer> A, ArrayList<Integer> B) {
		int len = B.size();
		for (int i = 0; i <len; i++){
			A.add(B.get(i));
		}
		Collections.sort(A);
		return A;
	}*/
	
	public ArrayList<Integer> mergeSortedArray(ArrayList<Integer> A, ArrayList<Integer> B){
		if (A == null || A.isEmpty()) return B;
		if (B == null || B.isEmpty()) return A;
		
		ArrayList<Integer> store = new ArrayList<Integer>();
		int aLen = A.size(), bLen = B.size();
		int i = 0, j = 0;
		
		while (i < aLen && j < bLen){
			if (A.get(i) < B.get(j)){
				store.add(A.get(i));
				i++;
			}else {
				store.add(B.get(j));
				j++;
			}
		}
		
		// A has elements left
		while (i < aLen) {
			store.add(A.get(i));
			i++;
		}
		
		// B has elements left
		while (j < bLen) {
			store.add(B.get(j));
			j++;
		}
		return store;
	}

}
