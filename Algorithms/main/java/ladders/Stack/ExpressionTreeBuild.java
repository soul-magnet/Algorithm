package main.java.ladders.Stack;

import java.util.Stack;

/**
 * 367. Expression Tree Build - Hard - Optional

The structure of Expression Tree is a binary tree to evaluate certain expressions.
All leaves of the Expression Tree have an number string value. 
All non-leaves of the Expression Tree have an operator string value.

Now, given an expression array, build the expression tree of this expression, 
return the root of this expression tree.

Clarification
See wiki:
Expression Tree

Example
For the expression (2*6-(23+7)/(1+2)) 
(which can be represented by ["2" "*" "6" "-" "(" "23" "+" "7" ")" "/" "(" "1" "+" "2" ")"]). 
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

public class ExpressionTreeBuild {
	
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

//Juizhang Solution
//version 1
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


public class Solution {
 class TreeNode {
     int val;
     ExpressionTreeNode eNode;
     public TreeNode(int val, String s) {
         this.val = val;
         eNode = new ExpressionTreeNode(s);
     }
 }
 /**
  * @param expression: A string array
  * @return: The root of expression tree
  */
 public ExpressionTreeNode build(String[] expression) {
     if (expression == null || expression.length == 0) {
         return null;
     }
     Stack<TreeNode> stack = new Stack<TreeNode>();
     int base = 0;
     int val = 0;

     for (int i = 0; i < expression.length; i++) {
         if (expression[i].equals("(")) {
             base += 10;
             continue;
         }
         if (expression[i].equals(")")) {
             base -= 10;
             continue;
         }
         val = getWeight(base, expression[i]);
         TreeNode node = new TreeNode(val, expression[i]);
         while (!stack.isEmpty() && node.val <= stack.peek().val) {
             node.eNode.left = stack.pop().eNode;
         }
         if (!stack.isEmpty()) {
             stack.peek().eNode.right = node.eNode;
         }
         stack.push(node);
     }
     if (stack.isEmpty()) {
         return null;
     }
     TreeNode rst = stack.pop();
     while (!stack.isEmpty()) {
         rst = stack.pop();
     }
     return rst.eNode;
 }
 //Calculate weight for characters
 public int getWeight(int base, String s) {
     if (s.equals("+") || s.equals("-")) {
         return base + 1;
     }
     if (s.equals("*") || s.equals("/")) {
         return base + 2;
     }
     return Integer.MAX_VALUE;
 }
}

//version 2
/**
* Definition of ExpressionTreeNode:
* public class ExpressionTreeNode {
*     public String symbol;
*     public ExpressionTreeNode left, right;
*     public ExpressionTreeNode(rooting symbol) {
*         this.symbol = symbol;
*         this.left = this.right = null;
*     }
* }
*/
class TreeNode {
 public int val;
	public String s;
	public ExpressionTreeNode root; 

	public TreeNode(int val, String ss) {
		this.val = val;
		this.root = new ExpressionTreeNode(ss);
	}

}

public class Solution {

	int get(String a, Integer base) {
		if (a.equals("+") || a.equals("-"))
			return 1 + base;
		if (a.equals("*") || a.equals("/"))
			return 2 + base;

		return Integer.MAX_VALUE;
	}



	public ExpressionTreeNode build(String[] expression) {
		// write your code here
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode root = null;
		int val = 0;
		Integer base = 0;
		for (int i = 0; i <= expression.length; i++) {
			if(i != expression.length)
			{
				
				if (expression[i].equals("(")) {
					base += 10;
					continue;
				}
				if (expression[i].equals(")")) {
					base -= 10;
					continue;
				}
				val = get(expression[i], base);

			}
			TreeNode right = i == expression.length ? new TreeNode(
					Integer.MIN_VALUE, "") : new TreeNode(val,
					expression[i]);
			while (!stack.isEmpty()) {
				if (right.val <= stack.peek().val) {
					TreeNode nodeNow = stack.pop();

					if (stack.isEmpty()) {
						right.root.left = nodeNow.root;

					} else {
						TreeNode left = stack.peek();
						if (left.val < right.val) {
							right.root.left = nodeNow.root;
						} else {
							left.root.right = nodeNow.root;
						}
					}
				} else {
					break;
				}
			}
			stack.push(right);
		}

	
		
		return stack.peek().root.left;
	}


};
