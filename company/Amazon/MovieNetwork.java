package Amazon;
/**
 * 
 * 808. Movie Network - Medium - Onsite

Give some rating of movie (number starting from 0) and their relationship, 
and relationships can be passed (a and b are related, b and c are related, 
a and c are also considered to be related). Give every movie's relationship list.
Given a movie numbered S, find the top K movies with the highest rating in the movies associated with S
(When the number of movies which associated with S is less than K, output all the movies .
You can output them in any order). Does not include this movie.

 Notice
the number of movies is n, and n <= 20000.
We guarantee that the number is 0 ~ n-1.
We guarantee that the numbers of the 2 vertices of an edge both belong to 0 ~ n-1.
We guarantee that the numbers of the edges is m, and m <= 100000.
We guarantee that the rating of each movie is not the same.

Example
Given ratingArray = [10,20,30,40], contactRelationship = [[1,3],[0,2],[1],[0]], S = 0, K = 2, return [2,3].

Explanation:
In contactRelationship, [1,3] is associated with 0,[0,2] is associated with 1,
[1] is associated 2,[0] is associated with 3.
Finally,Movies numbered [1,2,3] are associated with movie 0, 
and the order which according to their rating from high to low is [3,2,1], so the output [2,3].

Given ratingArray = [10,20,30,40,50,60,70,80,90], 
contactRelationship = [[1,4,5],[0,2,3],[1,7],[1,6,7],[0],[0],[3],[2,3],[]], S = 5, K = 3, return [6,7,4].

Explanation:
In contactRelationship,[1,4,5] is associated with 0,[0,2,3] is associated with 1,[1,7] 
is associated with 2,[1,6,7] is is associated with 3,[0] is associated with 4,[0] 
is associated with 5,[3] is associated with 6,[2,3] is associated with 7,no moive is associated with 8.
Finally,Movies numbered [0,1,2,3,4,6,7] are associated with movie 5, 
and the order which according to their rating from high to low is [7,6,4,3,2,1,0]. 
Notice that movie 8 is not related to movie 5, so it has the highest rating but does not count towards the answer.

Tags: Priority Queue Binary Search Tree Amazon Depth First Search

Related Problems 
Medium Parser 22 %
Medium Word Break III 34 %
 * */
public class MovieNetwork {
	 /**
     * @param rating: the rating of the movies
     * @param G: the realtionship of movies
     * @param S: the begin movie
     * @param K: top K rating 
     * @return: the top k largest rating moive which contact with S
     */
    public int[] topKMovie(int[] rating, int[][] G, int S, int K) {
        // Write your code here
    }

}
