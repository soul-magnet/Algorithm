package Ladder2.DataStructure_I;

import java.util.ArrayList;

/**
 * 249. Count of Smaller Number before itself 
 
Give you an integer array (index from 0 to n-1, where n is the size of this array, data value from 0 to 10000) . 
For each element Ai in the array, count the number of element before this element Ai is smaller than it and 
return count number array.

 Notice
We suggest you finish problem Segment Tree Build, Segment Tree Query II and Count of Smaller Number first.

Example
For array [1,2,7,8,5], return [0,1,2,3,2]

Tags: LintCode Copyright Binary Search Segment Tree

Related Problems 
Medium Count of Smaller Number 20 %
 * 
 * */
public class CountOfSmallerNumberBeforeItself {
	class SegmentTreeNode{
        public int start, end, ct;
        public SegmentTreeNode left, right;
        public SegmentTreeNode(int start, int end, int ct){
            this.start = start;
            this.end = end;
            this.ct = ct;
            this.left = this.right = null;
        }
    }
    public SegmentTreeNode build(int start, int end){
        if(start > end ){
            return null;
        }
        SegmentTreeNode root = new SegmentTreeNode(start, end, 0);
        if(start == end){
            return root;
        }
        int mid = start + (end-start)/2;
        root.left = build (start, mid);
        root.right= build (mid+1, end);
        return root;
    }
    public void modify(SegmentTreeNode root, int pos, int ct){
//        if(pos> root.end || pos<root.start){
//            return;
//        }
        if(pos== root.end && pos==root.start){
            root.ct += ct;
            return;
        }
        int mid = root.start + (root.end-root.start)/2;
        if(pos<=mid&&pos>=root.start){
            modify( root.left, pos, ct);
        }
        else if(pos>=mid+1&&pos<=root.end){
            modify( root.right, pos, ct);
        }
        root.ct= root.left.ct+ root.right.ct;
    }
    public int query(SegmentTreeNode root,int start, int end){
//        if((start<root.start)||(start>root.end)||(start>end)||root==null){
//            return 0;
//        }

        if(start==root.start&&end==root.end){
            return root.ct;
        }
        int mid = root.start + (root.end-root.start)/2;
        if(start<=mid){
            if(end>mid){
                return query(root.left, start, mid)+query(root.right,mid+1,end);
            }else{
                return query(root.left, start, end);
            }
        }else{
            return query(root.right, start, end);
        }
    }

    /**
     * @param a: An integer array
     * @return: Count the number of element before this element 'ai' is
     *          smaller than it and return count number array
     */
    public ArrayList<Integer> countOfSmallerNumberII(int[] A) {
        SegmentTreeNode root = build(0, 10000);
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int res;
        for(int i = 0; i < A.length; i++) {
            res = 0;
            if(A[i] > 0) {
                res = query(root, 0, A[i]-1);
            }
            modify(root, A[i], 1);
            ans.add(res);
        }
        return ans;
    }

}

//Juizhang Solution 
//public class Solution {
//	   /**
//	     * @param A: An integer array
//	     * @return: Count the number of element before this element 'ai' is 
//	     *          smaller than it and return count number array
//	     */ 
//	    class SegmentTreeNode {
//	        public int start, end;
//	        public int count;
//	        public SegmentTreeNode left, right;
//	        public SegmentTreeNode(int start, int end, int count) {
//	              this.start = start;
//	              this.end = end;
//	              this.count = count;
//	              this.left = this.right = null;
//	        }
//	    }
//	    SegmentTreeNode root;
//	    public SegmentTreeNode build(int start, int end) {
//	        // write your code here
//	        if(start > end) {  // check core case
//	            return null;
//	        }
//	        
//	        SegmentTreeNode root = new SegmentTreeNode(start, end, 0);
//	        
//	        if(start != end) {
//	            int mid = (start + end) / 2;
//	            root.left = build(start, mid);
//	            root.right = build(mid+1, end);
//	        } else {
//	            root.count =  0;
//	        }
//	        return root;
//	    }
//	    public int querySegmentTree(SegmentTreeNode root, int start, int end) {
//	        // write your code here
//	        if(start == root.start && root.end == end) { // 相等 
//	            return root.count;
//	        }
//	        
//	        
//	        int mid = (root.start + root.end)/2;
//	        int leftcount = 0, rightcount = 0;
//	        // 左子区
//	        if(start <= mid) {
//	            if( mid < end) { // 分裂 
//	                leftcount =  querySegmentTree(root.left, start, mid);
//	            } else { // 包含 
//	                leftcount = querySegmentTree(root.left, start, end);
//	            }
//	        }
//	        // 右子区
//	        if(mid < end) { // 分裂 3
//	            if(start <= mid) {
//	                rightcount = querySegmentTree(root.right, mid+1, end);
//	            } else { //  包含 
//	                rightcount = querySegmentTree(root.right, start, end);
//	            } 
//	        }  
//	        // else 就是不相交
//	        return leftcount + rightcount;
//	    }
//	    public void modifySegmentTree(SegmentTreeNode root, int index, int value) {
//	        // write your code here
//	        if(root.start == index && root.end == index) { // 查找到
//	            root.count += value;
//	            return;
//	        }
//	        
//	        // 查询
//	        int mid = (root.start + root.end) / 2;
//	        if(root.start <= index && index <=mid) {
//	            modifySegmentTree(root.left, index, value);
//	        }
//	        
//	        if(mid < index && index <= root.end) {
//	            modifySegmentTree(root.right, index, value);
//	        }
//	        //更新
//	        root.count = root.left.count + root.right.count;
//	    }
//	    public ArrayList<Integer> countOfSmallerNumberII(int[] A) {
//	        // write your code here
//	        root = build(0, 10000);
//	        ArrayList<Integer> ans = new ArrayList<Integer>();
//	        int res;
//	        for(int i = 0; i < A.length; i++) {
//	            res = 0;
//	            if(A[i] > 0) {
//	                res = querySegmentTree(root, 0, A[i]-1);
//	            }
//	            modifySegmentTree(root, A[i], 1);
//	            ans.add(res);
//	        }
//	        return ans;
//	    }
//	}
//