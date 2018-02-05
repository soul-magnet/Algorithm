package Ladder3.DataStructure_II;
/**
 * 367. Expression Tree Build - Hard -Optional
 
The structure of Expression Tree is a binary tree to evaluate certain expressions.
All leaves of the Expression Tree have an number string value.
All non-leaves of the Expression Tree have an operator string value.

Now, given an expression array, build the expression tree of this expression, 
return the root of this expression tree.

Clarification
See wiki:
Expression Tree

Example
For the expression (2*6-(23+7)/(1+2)) (which can be represented by ["2" "*" "6" "-" "(" "23" "+" "7" ")" "/" "(" "1" "+" "2" ")"]). 
The expression tree will be like

                 [ - ]
             /          \
        [ * ]              [ / ]
      /     \           /         \
    [ 2 ]  [ 6 ]      [ + ]        [ + ]
                     /    \       /      \
                   [ 23 ][ 7 ] [ 1 ]   [ 2 ] .
After building the tree, you just need to return root node [-].

Tags: Stack LintCode Copyright Binary Tree

Related Problems 
Medium Expression Expand 27 %
Hard Expression Evaluation 23 %
 * */

/**
 * Definition of ExpressionTreeNode:
 * public class ExpressionTreeNode {
 *     public String symbol;
 *     public ExpressionTreeNode left, right;
 *     public ExpressionTreeNode(String symbol) {
 *         this.symbol = symbol;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class ExpressioTreeBuild {
	
	/**
     * @param expression: A string array
     * @return: The root of expression tree
     */
            public ExpressionTreeNode build(String[] expression) {
            Stack<ExpressionTreeNode> operator = new Stack<>();
            Stack<ExpressionTreeNode> data = new Stack<>();
            for(String crt: expression){
                if(isOperator(crt)){
                    while(!operator.isEmpty()&&isOperator(operator.peek().symbol)){
                        String op = operator.peek().symbol;
                        if(opPrecedence(crt)<=opPrecedence(op) ){
                            ExpressionTreeNode root = operator.pop();
                            ExpressionTreeNode r= data.pop();
                            ExpressionTreeNode l=data.pop();
                            root.left=l;
                            root.right=r;
                            data.push(root);
                        }else{
                            break;
                        }
                    }
                    operator.push(new ExpressionTreeNode(crt));
                }else if(crt.equals("(")){
                    operator.push(new ExpressionTreeNode("("));
                }else if(crt.equals(")")){
                    while(!operator.isEmpty()&&!operator.peek().symbol.equals("(")){
                        ExpressionTreeNode root = operator.pop();
                        ExpressionTreeNode r= data.pop();
                        ExpressionTreeNode l=data.pop();
                        root.left=l;
                        root.right=r;
                        data.push(root);
                    }
                    operator.pop();//pop (
                }else{//all data
                    data.push(new ExpressionTreeNode(crt));
                }
            }
            while(!operator.isEmpty()){
                ExpressionTreeNode root = operator.pop();
                ExpressionTreeNode r= data.pop();
                ExpressionTreeNode l=data.pop();
                root.left=l;
                root.right=r;
                data.push(root);
            }
            if(data.isEmpty()){
                return null;
            }
            return data.pop();
        }

    private int opPrecedence(String op) {
        switch(op){
            case "+":
            case"-": return 1;
            case"/":
            case"*": return 2;
            default:return 5;
        }
    }

    private boolean isOperator(String crt) {
        if("/*-+".contains(crt)){
            return true;
        }
        return false;
    }

}
