package main.java.ladders.HashTable;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * 58. 4Sum - Medium

Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?

Find all unique quadruplets in the array which gives the sum of target.

 Notice
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.

Have you met this question in a real interview? 
Example
Given array S = {1 0 -1 0 -2 2}, and target = 0. A solution set is:

(-1, 0, 0, 1)
(-2, -1, 1, 2)
(-2, 0, 0, 2)

Tags: Hash Table Array Two Pointers Sort

Related Problems 
Medium 3Sum 20 %
Easy Two Sum 28 %
 * */
public class FourSum {
	/**
     * @param numbers : Give an array numbersbers of n integer
     * @param target : you need to find four elements that's sum of target
     * @return : Find all unique quadruplets in the array which gives the sum of
     *           zero.
     */
    public ArrayList<ArrayList<Integer>> fourSum(int[] n, int t) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if(n==null || n.length<4){
			return res;
		}
        int len= n.length;
		Arrays.sort(n);
		for(int i=0;i<n.length-3;i++){
            while(i>0&&n[i]==n[i-1]&&i<n.length-3){
				i++;
			}
            for(int j=i+1;j<len-2;j++){
				while(j>i+1&&n[j]==n[j-1]&&j<len-2){
					j++;
				}
				int l= j+1, r= len-1;
                while(l<r){
                    int sum = n[i]+n[j]+n[l]+n[r];
                    if(sum< t){
                        l++;
                    }else if (sum>t){
                        r--;
                    }else{
                        ArrayList<Integer> path = new ArrayList<>();
                        path.add(n[i]);
                        path.add(n[j]);
                        path.add(n[l]);
                        path.add(n[r]);
                        res.add(path);
                        r--;
                        l++;
                        while(r>l&&n[r]==n[r+1]){
                            r--;
                        }
                        while(l>r&&n[l]==n[l-1]){
                            l++;
                        }
                    }
                }
            }
        }
        return res;
	}

}
