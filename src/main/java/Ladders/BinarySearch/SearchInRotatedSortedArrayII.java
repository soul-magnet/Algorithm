package BinarySearch;
/*Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * Write a function to determine if a given target is in the array.
 * 
 * */
public class SearchInRotatedSortedArrayII {
	/** 
     * param A : an integer ratated sorted array and duplicates are allowed
     * param target :  an integer to be search
     * return : a boolean 
     */
    public boolean search(int[] A, int target) {
    	
    	if (A == null || A.length == 0){
    		return false;
    	}
    	
    	int left = 0, right = A.length - 1;
    	while (left < right){
    		int mid = left + (right - left) / 2;
    		if (A[mid] == target){
    			return true;
    		}
    		if (A[mid] < A[right]){ // A[m ... r] are sorted
    			if (A[mid] < target && target <= A[right]){
    				left = mid + 1; // target is in A[m+1 .. right]
    			} else {
    				right = mid - 1; // target is in A[left ... m-1]
    			}
    		} else if (A[mid] > A[right]){ // A[left ... mid] are sorted
    			if (A[mid] > target && target >= A[left]){
    				right = mid - 1; // target is in A[left..m-1]
    			} else {
    				left = mid + 1; // target is in A[m+1.. r]
    			}
    		} else {
    			//{3,3,3,3,[1],2,3}, {3,[1],2,3,3,3,3}
                //As target could be either on left or right of mid, 
    			//we can only get rid of one duplicate
         
    			right--;
    		}
    	}
        return A[right] == target;
    }
}
