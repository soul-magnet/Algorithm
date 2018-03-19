package main.java.ladders.Array;

import java.util.Arrays;

/**
 * 412. Candy - Hard

There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.

Children with a higher rating get more candies than their neighbors.

What is the minimum candies you must give?

Example
Given ratings = [1, 2], return 3.

Given ratings = [1, 1, 1], return 3.

Given ratings = [1, 2, 2], return 4. ([1,2,1]).

Tags 
Greedy Array
 * */
public class Candy {
	/**
     * @param ratings Children's ratings
     * @return the minimum candies you must give
     */
    public int candy(int[] ratings) {
                if(ratings==null||ratings.length==0){
            return 0;
        }
        int dic [] = new int[ratings.length];
        Arrays.fill(dic,1);
        for(int i =1; i< ratings.length; i++){
            if(ratings[i]>ratings[i-1]){
                dic[i]=dic[i-1]+1;
            }
        }
        int res =0;
        for(int i= ratings.length-1; i>0; i--){
            res+= dic[i];
            if (ratings[i-1]>ratings[i]&&dic[i-1]<=dic[i]){
                dic[i-1]=dic[i]+1;
            }
        }
        res+=dic[0];
        return res;
    }

}
