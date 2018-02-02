package IntegerArray;
/*
 * Given an unsorted integer array, find the first missing positive integer.
 * Example: Given [1,2,0] return 3, and [3,4,-1,1] return 2.
 * Challenge: Your algorithm should run in O(n) time and uses constant space.
 * 
 * Analysis:
 * This problem can solve by using a bucket-sort like algorithm.
 * Let's consider finding first missing positive and 0 first
 * The key fact is that the ith element should be i, so we have:
 * i == A[i]
 * A[i] == A[A[i]]
 * 
 * For example, given an array {1,2,0,4} the algorithm does the following:
 * 
 * index  |0 |1 | 2 | 3
 * A      |1| 2 | 0 | 4
 * 
 * i = 0 A[0] != 0 2---> 1  0  4
 *       A[0] != 0 0  1  2  4
 *       A[0] == 0
 * i = 1 A[1] == 1
 * i = 2 A[2] == 2
 * */
public class FirstMissingPossitive {
	/**    
     * @param A: an array of integers
     * @return: an integer
     */
	
	/*
	int firstMissingPositiveAnd0(int A[]) {
	int n = A.length;
	for (int i = 0; i < n; i++) {
		// when the ith element is not i
		while (A[i] != i) {
			// no need to swap when ith element is out of range [0,n]
			if (A[i] < 0 || A[i] >= n)
				break;
 
			//handle duplicate elements
			if(A[i]==A[A[i]])
                    		break;
			// swap elements
			int temp = A[i];
			A[i] = A[temp];
			A[temp] = temp;
		}
	}
 
	for (int i = 0; i < n; i++) {
		if (A[i] != i)
			return i;
	}
 
	return n;
}*/
	// this problem only considers positive numbers, so we need to shift 1 offset.
	// The ith element is i + 1.
    public int firstMissingPositive(int[] A) {
        if (A == null) {
            return 1;
        } 
        
        int n = A.length;
        
        for (int i = 0; i < n; i++){
        	while (A[i] > 0 && A[i] <n && A[i] != (i + 1)){
        		int tmp = A[A[i] - 1];
        		if (tmp == A[i]){
        			break;
        		}
        		A[A[i] - 1] = A[i];
        		A[i] = tmp;
        		
        	}
        }
        
        for (int i = 0; i < A.length; i++){
        	if (A[i] != i + 1){
        		return i + 1;
        	}
        }
        
       return A.length + 1; 
    }
}
