package main.java.ladders.Greedy;

import java.util.ArrayList;
import java.util.List;
/**
 * 84. Single Number III - Medium

Given 2*n + 2 numbers, every numbers occurs twice except two, find them.

Example
Given [1,2,2,3,4,4,5,3] return 1 and 5

Challenge 
O(n) time, O(1) extra space.

Tags: LintCode Copyright Greedy

Related Problems 
Medium Single Number IV 35 %
Medium Single Number II 40 %
Easy Single Number 46 %
Medium Majority Number III 30 %
Medium Majority Number II 31 %
Easy Majority Number 43 %
 * */
/* Analysis: 
 * 1. Find a bit P that differs result1 from result2
 * 2. Divide the array into two partitions by the number at bit P == 1/0
 * 3. XOR two partitions separately to get two results.
 * */
public class SingleNumber3 {
	/**
     * @param A : An integer array
     * @return : Two integers
     * a1^a1^a2^a2^a3^a4=a3^a4=01001
     *                         54321
     * for postion 1 = 1, oxr one is 1 other is 0
     * then partion a[] based pos1 then 
     * p1{2,2,2,2,2,result} which pos 1 is 1
     * p2{2,2,2,2,2,result2} which pos1 is 0
     */
    public List<Integer> singleNumberIII(int[] a) {
        List<Integer> res = new ArrayList<Integer>();
        if(a==null||a.length==0){
            return res;
        }
        int xor= 0;
        for(int i : a){
            xor ^= i;
        }
        
        int pos=0;
        for(int i=0; i<32; i++){
            if((xor>>i&1)==1){
                pos=i;
                break;
            }
        }
        List<Integer> res1 = new ArrayList<Integer>();
        List<Integer> res2 = new ArrayList<Integer>();
        for(int i : a ){
            if((i>>pos&1)==1){
                res1.add(i);
            }else{
                res2.add(i);
            }
        }
        int one =0;
        int two =0;
        for(int i: res1 ){
            one ^= i;
        }
        for (int i: res2){
            two ^= i;
        }
        res.add(one);
        res.add(two);
        return res;
    }
    ///////////////////////////////////////////////////////////////////
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
