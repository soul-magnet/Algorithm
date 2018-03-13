package main.java.ladders.DepthFirstSearch;
/**
 * 90. k Sum II - Medium

Your title here...Given n unique integers, number k (1<=k<=n) and target.
Find all possible k integers where their sum is target.

Example
Given [1,2,3,4], k = 2, target = 5. Return:

[
  [1,4],
  [2,3]
]
Tags 
LintCode Copyright Depth First Search
Related Problems 
Hard k Sum 26 %
 * */
public class KSum2 {
	/**
    * @param A: an integer array.
    * @param k: a positive integer (k <= length(A))
    * @param target: a integer
    * @return a list of lists of integer 
    */ 
    public ArrayList<ArrayList<Integer>> kSumII(int[] a, int k, int target) {
       ArrayList<ArrayList<Integer>> res = new ArrayList<>();
       ArrayList<Integer> path = new ArrayList<>();
       dfs(a, a.length-1, k, target, path, res );
       return res;
   }

   private void dfs(int[] a, int index, int k, int target, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> res) {
       if(k==0&& target==0){
           res.add(new ArrayList<Integer>(path));
           return;
       }
       if(index <0 || k<=0||target<=0){
           return;
       }
       dfs(a, index-1,k,target,path,res);
       path.add(a[index]);
       dfs(a, index-1,k-1, target-a[index],path,res);
       path.remove(path.size()-1);
   }

}
