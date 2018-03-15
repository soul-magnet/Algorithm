package main.java.ladders.Stack;
/**
 * 368. Expression Evaluation - Hard - Optional

Given an expression string array, return the final result of this expression

 Notice
The expression contains only integer, +, -, *, /, (, ).

Example
For the expression 2*6-(23+7)/(1+2),
input is

[
  "2", "*", "6", "-", "(",
  "23", "+", "7", ")", "/",
  "(", "1", "+", "2", ")"
],
return 2

Tags 
Stack LintCode Copyright
Related Problems 
Medium Calculate Maximum Value 25 %
Medium Expression Expand 27 %
Hard Expression Tree Build 23 %
Hard Convert Expression to Reverse Polish Notation 27 %
Hard Convert Expression to Polish Notation 26 %
 * */

public class ExpressionEvaulation {
    /**
     * @param expression: an array of strings;
     * @return: an integer
     */
    public int evaluateExpression(String[] expression) {
        int res =0;
        Stack<String> operater = new Stack<>();
        Stack<Integer> data = new Stack<>();
        for (String crt : expression){
            if(isOperater(crt)){
                while(!operater.isEmpty()&&isOperater(operater.peek())){
                    String op = operater.peek();
                    if(opPrecedence(crt)<=opPrecedence(op)){
                        operater.pop();
                        int r = data.pop();
                        int l = data.pop();
                        data.push(calulate(l, r, op)) ;
                    }else{
                        break;
                    }
                }
                operater.push(crt);
            }else if(crt.equals("(")){
                operater.push(crt);
            }else if(crt.equals(")")){
                while(!operater.isEmpty()&&!operater.peek().equals("(")){
                    String op = operater.pop();
                    int r = data.pop();
                    int l = data.pop();
                    data.push(calulate(l, r, op)) ;
                }
                operater.pop();//pop "("
            }else{
                data.push(Integer.valueOf(crt));
            }
        }
        while(!operater.isEmpty()){
            String op = operater.pop();
            int r = data.pop();
            int l = data.pop();
            data.push(calulate(l, r, op)) ;
        }
        if(data.isEmpty()){
            return 0;
        }
        return data.pop();
    }

    private Integer calulate(int l, int r, String op) {
        switch (op){
            case "+":return l+r;
            case"-":return l-r;
            case"/":return l/r;
            case"*":return l*r;
            default:return l^r;
        }

    }

    private int opPrecedence(String op) {
        switch (op){
            case "+":return 1;
            case"-":return 1;
            case"/":return 2;
            case"*":return 2;
            default:return 5;
        }
    }

    private boolean isOperater(String crt) {
        if("/*-+".contains(crt)){
            return true;
        }
        return false;
    }

};
