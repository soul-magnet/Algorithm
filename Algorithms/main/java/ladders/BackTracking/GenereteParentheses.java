package main.java.ladders.BackTracking;
/**
 * 427. Generate Parentheses - Medium

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 
Example
Given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"

Tags:String Backtracking Recursion Zenefits Google

Related Problems 
Easy Valid Parentheses 28 %
Medium Unique Binary Search Trees II 33 %
Medium Unique Binary Search Trees 36 %
 * */
public class GenereteParentheses {
	/**
     * @param n n pairs
     * @return All combinations of well-formed parentheses
     */
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        if(n==0){
            return res;
        }
        int r;
        int l=r=n;
        dfs(r,l, "",res);
        return res;
    }
    private void dfs(int r, int l, String path,ArrayList<String>res){
        if(l==0&&r==0){
            res.add(path);
            return;
        }
        if(l>0){
            dfs(r,l-1,path+"(",res);
        }
        if(r>0&&r>l){
            dfs(r-1,l,path+")",res);
        }
    }
}
