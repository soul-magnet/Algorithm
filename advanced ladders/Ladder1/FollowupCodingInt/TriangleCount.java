package Ladder1.FollowupCodingInt;

import java.util.Arrays;

/**
 * 382. Triangle Count
 * 
 * Given an array of integers, how many three numbers can be found in the array, 
 * so that we can build an triangle whose three edges length is the three numbers that we find?


Example: Given array S = [3,4,6,7], return 3. They are:

[3,4,6]
[3,6,7]
[4,6,7]
Given array S = [4,4,4,4], return 4. They are:

[4(1),4(2),4(3)]
[4(1),4(2),4(4)]
[4(1),4(3),4(4)]
[4(2),4(3),4(4)]

Tags: Two Pointers LintCode Copyright

Related Problems 
1 - Medium 3Sum 21 %
2 - Easy Two Sum
 * */

public class TriangleCount {
    /**
     * @param S: A list of integers
     * @return: An integer
     */
   public int triangleCount(int s[]) {
		int  r= 0;int res = 0;Arrays.sort(s);
		while(r<s.length){
			int l=0;
			int l1=r-1;
			while(l<l1){
				if(s[l]+s[l1]>s[r]){res +=l1-l;l1--;}
				else{l++;}
			}
			r++;
		}
		return res;
	}
}

