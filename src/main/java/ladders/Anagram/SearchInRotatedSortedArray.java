package Ladders;

import java.util.ArrayList;

//Suppose a sorted array is rotated at some pivot unknown to you beforehand.
//
//(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
//You are given a target value to search. If found in the array return its index, otherwise return -1.
//
//You may assume no duplicate exists in the array.
//
//Have you met this question in a real interview? Yes
//Example
//For [4, 5, 1, 2, 3] and target=1, return 2.
//
//For [4, 5, 1, 2, 3] and target=0, return -1.
//
//Challenge
//O(logN) time

public class SearchInRotatedSortedArray {
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public ArrayList<Integer> searchRange(ArrayList<Integer> A, int target) {
        int start, end, mid;
        ArrayList<Integer> bound = new ArrayList<Integer>();
        int index = 0;
        // search for left bound
        start = 0;
        end = A.size() - 1;
        mid = start + (end - start) / 2;
        if (A == null || A.size() == 0) {
            bound.set(index, -1);
            return bound;
        }
        while(start + 1 < end) {
            //mid = start + (end - start) / 2;
            if (A.get(mid) == target) {
                end = mid;
            } else if (A.get(mid) < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A.get(start) == target){
            bound.set(index, end);
        } else if(A.get(mid) == target) {
            bound.set(index, end);
        } else {
            bound.set(index, bound.set(index+1, -1));
            return bound;
        }
        
        // search for right bound
        start = 0;
        end = A.size() - 1;
        mid = start + (end - start) / 2;
        while (start + 1 < end){
           // mid = (end - start) / 2 + start;
            if (A.get(mid) == target) {
                start = mid;
            } else if (A.get(mid) < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A.get(end) == target) {
            bound.set(index + 1, start);
        } else {
            bound.set(index, bound.set(index + 1, -1));
            return bound;
        }
        return bound;
    }
}


// public int[] searchRange(int[] A, int target) {
//         int start, end, mid;
//         int[] bound = new int[2]; 
        
//         // search for left bound
//         start = 0; 
//         end = A.length - 1;
//         while (start + 1 < end) {
//             mid = start + (end - start) / 2;
//             if (A[mid] == target) {
//                 end = mid;
//             } else if (A[mid] < target) {
//                 start = mid;
//             } else {
//                 end = mid;
//             }
//         }
//         if (A[start] == target) {
//             bound[0] = start;
//         } else if (A[end] == target) {
//             bound[0] = end;
//         } else {
//             bound[0] = bound[1] = -1;
//             return bound;
//         }
        
//         // search for right bound
//         start = 0;
//         end = A.length - 1;
//         while (start + 1 < end) {
//             mid = start + (end - start) / 2;
//             if (A[mid] == target) {
//                 start = mid;
//             } else if (A[mid] < target) {
//                 start = mid;
//             } else {
//                 end = mid;
//             }
//         }
//         if (A[end] == target) {
//             bound[1] = end;
//         } else if (A[start] == target) {
//             bound[1] = start;
//         } else {
//             bound[0] = bound[1] = -1;
//             return bound;
//         }
        
//         return bound;
//     }

