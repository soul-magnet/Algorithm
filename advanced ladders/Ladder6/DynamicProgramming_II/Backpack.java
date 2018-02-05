package Ladder6.DynamicProgramming_II;
/**
 * 92. Backpack - Medium - Required

Given n items with size Ai, an integer m denotes the size of a backpack. How full you can fill this backpack?

 Notice
You can not divide any item into small pieces.

Example
If we have 4 items with size [2, 3, 5, 7], the backpack size is 11, we can select [2, 3, 5], 
so that the max size we can fill this backpack is 10. If the backpack size is 12. 
we can select [2, 3, 7] so that we can fulfill the backpack.

You function should return the max size we can fill in the given backpack.

Challenge 
O(n x m) time and O(m) memory.

O(n x m) memory is also acceptable if you do not know how to optimize memory.

Tags: LintCode Copyright Backpack Dynamic Programming

Related Problems 
Easy John's backyard garden 41 %
Medium Minimum Partition 11 %
Medium Cutting a Rod 33 %
Medium Partition Equal Subset Sum 31 %
Medium Backpack VI 32 %
Medium Backpack V 45 %
Medium Backpack IV 42 %
Hard Backpack III 54 %
Medium Backpack II 40 %
 * */

public class Backpack {
	
	/**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
        public static int backPack(int m, int[] a) {
         boolean f[] = new boolean[m + 1]; f[0] = true;
        int res = 0;
        for(int i: a){
            for(int j=m;j>=i;j--){
                if(f[j-i]){
                    f[j]=true;
                    res=Math.max(res,j);
                }
            }
        }
        return res;
    }

}
