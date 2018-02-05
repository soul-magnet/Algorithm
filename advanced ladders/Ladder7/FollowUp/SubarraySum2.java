package Ladder7.FollowUp;

import java.util.Arrays;

/**
 * 404. Subarray Sum II - Hard - Required

Given an integer array, find a subarray where the sum of numbers is in a given interval. 
Your code should return the number of possible answers. (The element in the array should be positive)


Example
Given [1,2,3,4] and interval = [1,3], return 4. The possible answers are:

[0, 0]
[0, 1]
[1, 1]
[2, 2]

Tags:Array Two Pointers

Related Problems 
Medium Subarray Sum Closest 21 %
Easy Subarray Sum 31 %
 * */
public class SubarraySum2 {
	
	/**
     * @param A an integer array
     * @param start an integer
     * @param end an integer
     * @return the number of possible answer
     */
       public int subarraySumII(int[] a, int start, int end) {
        int len = a.length;
        for(int i=1; i< a.length;i++){
            a[i]+=a[i-1];
        }
        Arrays.sort(a); int ct =0;
        for(int i=0; i<a.length;i++){
            if(a[i]>=start&&a[i]<=end){
                ct++;
            }
            int l = a[i]-end, r = a[i]-start;
            ct+= (find(a,i+1, r+1)-find(a,i+1,l));
        }
        return ct;
    }

    private int find(int[] a, int len, int t) {
        if(a[len-1]<t)return len;
        int l=0,r= len-1, pos=0;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(a[mid]>=t){
                pos= mid;
                r=mid-1; 
            }else{
                l=mid+1;
            }
           
        } return pos;
    }

}
