package main.java.ladders.CombinationBasedDFS;

import java.util.ArrayList;

/**
 * 426. Restore IP Addresses - Medium - Required

Given a string containing only digits, 
restore it by returning all possible valid IP address combinations.

Example
Given "25525511135", return

[
  "255.255.11.135",
  "255.255.111.35"
]
Order does not matter.

Tags: String Backtracking Recursion

Related Problems 
Medium Subsets 26 %
 * */
public class RestoreIpAddress {
	/**
     * @param s the IP string
     * @return All possible valid IP addresses
     */
    public ArrayList<String> restoreIpAddresses(String s) {
               ArrayList<String > res = new ArrayList<>();

        if( s==null||s.length()<4||s.length()>12){
            return res;
        }
        
        dfs(s,res,new ArrayList<String>(),0);
        return res;
    }

    private void dfs(String s, ArrayList<String> res, ArrayList<String> list, int index) {
        if(list.size()==4){
            if(index != s.length()){
                return;
            }
            StringBuffer sb = new StringBuffer();
            for( String c : list){
                sb.append(c);
                sb.append(".");
            }
            sb.deleteCharAt(sb.length()-1);
            res.add(sb.toString());
            return;
        }

        for(int i = 0; i<3&& index+i<s.length(); i++){
            String temp = s.substring(index, index+i+1);
            if( isValid(temp)){
                list.add(temp);
                dfs(s,res,list,index+i+1);
                list.remove(list.size()-1);
            }
        }
    }

    private boolean isValid(String temp){
        if(temp.charAt(0)=='0'){
            return temp.equals("0");
        }
        int res= Integer.valueOf(temp);
        return res<=255&&res>=0;
    }
}
