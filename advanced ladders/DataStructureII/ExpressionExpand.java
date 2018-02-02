package DataStructureII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 575. Expression Expand - Medium - required

Given an expression s includes numbers, letters and brackets. 
Number represents the number of repetitions inside the brackets(can be a string or another expression)．
Please expand expression to be a string.

Example
s = abc3[a] return abcaaa
s = 3[abc] return abcabcabc
s = 4[ac]dy, return acacacacdy
s = 3[2[ad]3[pf]]xyz, return adadpfpfpfadadpfpfpfadadpfpfpfxyz

Challenge: Can you do it without recursion?

Tags: Stack Divide and Conquer Recursion Non Recursion Yahoo

Related Problems 
Hard Expression Tree Build 23 %
Hard Expression Evaluation 23 %

*/

public class ExpressionExpand {
	public List<String> stringPermutation2(String str) {
        List<String> res = new ArrayList<>();
        if(str.equals(null)){
            return res;
        }
        char[] dic = str.toCharArray();
        Arrays.sort(dic);
        boolean [] visited = new boolean[str.length()];
        dfs(dic, visited, res, new String() );
        return res;
    }

    private void dfs(char[] dic, boolean[] visited, List<String> res, String s) {
        if(s.length()==dic.length){
            res.add(new String (s));
            return;
        }
        for (int i=0; i< dic.length;i++){
            if(visited[i]==true||(i!=0&& dic[i]==dic[i-1]&& visited[i-1]==false)){
                continue;
            }
            visited[i]=true;
            s=s+dic[i];
            dfs(dic,visited,res,s);
            //backtracking
            visited[i]=false;
            s=s.substring(0,s.length()-1);
        }
    }

}
