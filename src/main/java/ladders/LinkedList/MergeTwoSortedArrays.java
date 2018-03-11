package main.java.ladders.LinkedList;
/**
 * 6. Merge Two Sorted Arrays - Easy - Optional

Merge two given sorted integer array A and B into a new sorted integer array.

Have you met this question in a real interview? 
Example
A=[1,2,3,4]

B=[2,4,5,6]

return [1,2,2,3,4,4,5,6]

Challenge 
How can you optimize your algorithm if one array is very large and the other is very small?

Tags 
Array Sorted Array
Related Problems 
Easy Intersection of Two Arrays II 23 %
Easy Intersection of Two Arrays 24 %
Easy Merge Two Sorted Lists 39 %
Medium Merge k Sorted Lists 29 %
Easy Merge Sorted Array 33 %
 * */
public class MergeTwoSortedArrays {
	/**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] a, int[] b) {
        // Write your code here
            if(a.length==0||a==null){
            return b;
        }
        if(b.length==0||b==null){
            return a;
        }
        int i=0, j=0, index=0;
        int []c = new int [a.length+b.length];
        while(i < a.length && j< b.length){
            if(a[i]<=b[j])
            { c[index++]=a[i++];
                
            }else
            {
            	c[index++]=b[j++];
            }
        }
       
        	 while(i < a.length){
        		 c[index++]=a[i++];
        	 }
        	 while(j < b.length){
        		 c[index++]=b[j++];
        	 }
        
        
        return c;
    }
}
