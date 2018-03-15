package main.java.ladders.Stack;

import java.util.Stack;

/**
 * 575. Expression Expand - Medium - Related

Given an expression s includes numbers, letters and brackets. 
Number represents the number of repetitions inside the brackets(can be a string or another expression)．
Please expand expression to be a string.

Example
s = abc3[a] return abcaaa
s = 3[abc] return abcabcabc
s = 4[ac]dy, return acacacacdy
s = 3[2[ad]3[pf]]xyz, return adadpfpfpfadadpfpfpfadadpfpfpfxyz

Challenge 
Can you do it without recursion?

Tags: Stack Divide and Conquer Recursion Non Recursion Yahoo
Related Problems 
Hard Expression Tree Build 23 %
Hard Expression Evaluation 23 %
 * */
public class ExpressionExpand {
	/**
     * @param s  an expression includes numbers, letters and brackets
     * @return a string
     */
    public String expressionExpand(String s) {
                if(s==null||s.length()==0){
            return "";
        }

        Stack<Integer> weight = new Stack<>();
        Stack<Character> string = new Stack<>();
        weight.push(1);
        int ct = 0;
        for(char c: s.toCharArray()){
            //System.out.println( c);
            if (Character.isDigit(c)){
                ct=ct*10+(c-'0');
            }else if(c=='['){
                string.push('[');
                weight.push(ct);
                ct=0;
            }else if(c==']'){
                int ct1 = weight.pop();

                StringBuffer res = new StringBuffer();
                //add rever order in stack, recover it by reverse
                while(!string.isEmpty()){
                    char crt =string.pop();
                    if(crt=='['){
                        break;
                    }else {
                        res.append(crt);
                    }
                }
                res= res.reverse();
                StringBuffer now = new StringBuffer();
                for(int i=0; i<ct1;i++){
                    now.append(res);
                   // System.out.println( now.toString());
                }
                //System.out.println( res.toString());
                //System.out.println( now.toString());
                for(char c1: now.toString().toCharArray()){
                    string.push(c1);
                }
            }else {
                string.push(c);
            }
        }
        StringBuffer ans = new StringBuffer();
        while(!string.isEmpty()){
            ans.append(string.pop());
        }
        ans=ans.reverse();
        return ans.toString();

    }

}
