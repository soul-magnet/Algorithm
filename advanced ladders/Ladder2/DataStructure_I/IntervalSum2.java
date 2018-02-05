package Ladder2.DataStructure_I;
/**
 * 207. Interval Sum II 

Given an integer array in the construct method, implement two methods query(start, end) and modify(index, value):

For query(start, end), return the sum from index start to index end in the given array.
For modify(index, value), modify the number in the given index to value
 Notice
We suggest you finish problem Segment Tree Build, Segment Tree Query and Segment Tree Modify first.

Example
Given array A = [1,2,7,8,5].

query(0, 2), return 10.
modify(0, 4), change A[0] from 1 to 4.
query(0, 1), return 6.
modify(2, 1), change A[2] from 7 to 1.
query(2, 4), return 14.
Challenge 
O(logN) time for query and modify.

Tags:LintCode Copyright Binary Search Segment Tree

Related Problems 
Medium Interval Sum 27 %
Medium Interval Minimum Number 26 %
 * */

public class IntervalSum2 {
    /* you may need to use some attributes here */
      class SegmentTreeNode {
        public int start, end;
        public int sum;
        public SegmentTreeNode left, right;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = this.right = null;
        }
    }
    SegmentTreeNode root;
    /**
     * @param a: An integer array
     */
    public IntervalSum2(int[] a) {
       root= build(0, a.length-1,  a);
    }
    
    /**
     * @param start, end: Indices
     * @return: The sum from start to end
     */
    public long query(int start, int end) {
        return query(start, end,  root);
    }
    
    /**
     * @param index, value: modify A[index] to value.
     */
    public void modify(int index, int value) {
        modifySegmentTree( root, index, value);
    }
     private void modifySegmentTree(SegmentTreeNode root, int index, int value) {
         if(root.start==index&& root.end==index){
             root.sum= value;
             return;
         }
         int mid = (root.start+ root.end)/2;
         if(index <=mid){
             modifySegmentTree( root.left, index, value);
         }else{
             modifySegmentTree( root.right, index, value);
         }
         root.sum = root.left.sum+root.right.sum;
     }
     
    private SegmentTreeNode build(int start, int end, int[] a) {
			if(start>end){
				return null;
			}
			SegmentTreeNode root = new SegmentTreeNode(start, end);
			if(start==end){
				root.sum=a[start];
				return root;
			}
			int mid = (start+end)/2;
			if(start!=end){
				root.left = build(start, mid, a);
				root.right = build(mid+1, end, a);
				root.sum= root.left.sum+root.right.sum;

			}
			return root;
		}
		private long query(int start, int end, SegmentTreeNode root) {
			if (root.start==start&&root.end==end){
				return root.sum;
			}
			int mid = (root.start+ root.end)/2;
			if(start<=mid){
				if(end<=mid){
					return query(start, end, root.left);
				}else{
					return query(start, mid, root.left)+query(mid+1, end, root.right);
				}

			}
			return query(start, end, root.right);
		}
}

//Solution form Juizhang

//public class Solution {
//    /* you may need to use some attributes here */
//    
//     class SegmentTreeNode {
//        public int start, end;
//        public int sum;
//        public SegmentTreeNode left, right;
//        public SegmentTreeNode(int start, int end, int sum) {
//              this.start = start;
//              this.end = end;
//              this.sum = sum;
//              this.left = this.right = null;
//        }
//    }
//    SegmentTreeNode root;
//    public SegmentTreeNode build(int start, int end, int[] A) {
//        // write your code here
//        if(start > end) {  // check core case
//            return null;
//        }
//        
//        SegmentTreeNode root = new SegmentTreeNode(start, end, 0);
//        
//        if(start != end) {
//            int mid = (start + end) / 2;
//            root.left = build(start, mid, A);
//            root.right = build(mid+1, end, A);
//            
//            root.sum = root.left.sum + root.right.sum;
//        } else {
//            root.sum =  A[start];
//            
//        }
//        return root;
//    }
//    public int querySegmentTree(SegmentTreeNode root, int start, int end) {
//        // write your code here
//        if(start == root.start && root.end == end) { // 相等 
//            return root.sum;
//        }
//        
//        
//        int mid = (root.start + root.end)/2;
//        int leftsum = 0, rightsum = 0;
//        // 左子区
//        if(start <= mid) {
//            if( mid < end) { // 分裂 
//                leftsum =  querySegmentTree(root.left, start, mid);
//            } else { // 包含 
//                leftsum = querySegmentTree(root.left, start, end);
//            }
//        }
//        // 右子区
//        if(mid < end) { // 分裂 3
//            if(start <= mid) {
//                rightsum = querySegmentTree(root.right, mid+1, end);
//            } else { //  包含 
//                rightsum = querySegmentTree(root.right, start, end);
//            } 
//        }  
//        // else 就是不相交
//        return leftsum + rightsum;
//    }
//    public void modifySegmentTree(SegmentTreeNode root, int index, int value) {
//        // write your code here
//        if(root.start == index && root.end == index) { // 查找到
//            root.sum = value;
//            return;
//        }
//        
//        // 查询
//        int mid = (root.start + root.end) / 2;
//        if(root.start <= index && index <=mid) {
//            modifySegmentTree(root.left, index, value);
//        }
//        
//        if(mid < index && index <= root.end) {
//            modifySegmentTree(root.right, index, value);
//        }
//        //更新
//        root.sum = root.left.sum + root.right.sum;
//    }
//    /**
//     * @param A: An integer array
//     */
//    public Solution(int[] A) {
//        // write your code here
//        root = build(0, A.length-1, A);
//    }
//    
//    /**
//     * @param start, end: Indices
//     * @return: The sum from start to end
//     */
//    public long query(int start, int end) {
//        // write your code here
//        return querySegmentTree(root, start ,end);
//    }
//    
//    /**
//     * @param index, value: modify A[index] to value.
//     */
//    public void modify(int index, int value) {
//        // write your code here
//        modifySegmentTree(root, index, value);
//    }
//}
//
//
