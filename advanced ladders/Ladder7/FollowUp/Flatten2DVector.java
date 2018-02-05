package Ladder7.FollowUp;
/**
 * 601. Flatten 2D Vector - Medium - Optional

Implement an iterator to flatten a 2d vector.

Example
Given 2d vector =

[
  [1,2],
  [3],
  [4,5,6]
]
By calling next repeatedly until hasNext returns false, 
the order of elements returned by next should be: [1,2,3,4,5,6].

Tags:Airbnb Google Zenefits Twitter

Related Problems 
Medium Zigzag Iterator 44 %
Medium Flatten Nested List Iterator 28 %
Easy Flatten Binary Tree to Linked List 33 %
Easy Flatten List 30 %
 * */
public class Flatten2DVector {

}

public class Vector2D implements Iterator<Integer> {

    public Vector2D(List<List<Integer>> vec2d) {
        // Initialize your data structure here
    }

    @Override
    public Integer next() {
        // Write your code here
    }

    @Override
    public boolean hasNext() {
        // Write your code here
    }

    @Override
    public void remove() {}
    
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */

//Juizhang SOlution 1
public class Vector2D implements Iterator<Integer> {
    Stack<List<Integer>> stack = new Stack<>();
    Stack<Integer> stackj;
    
    void pushListListToStack(List<List<Integer>> vec2d) {
    Stack<List<Integer>> temp = new Stack<>();
        for (List<Integer> nested : vec2d) {
            temp.push(nested);
        }
        
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }
    
    void pushListToStack(List<Integer> vec) {
    Stack<Integer> temp = new Stack<>();
        for (Integer nested : vec) {
            temp.push(nested);
        }
        
        while (!temp.isEmpty()) {
            stackj.push(temp.pop());
        }
    }
    
    public Vector2D(List<List<Integer>> vec2d) {
        pushListListToStack(vec2d);
        // Initialize your data structure here
        stackj = new Stack<>();
    }

    public Integer next() {
        // Write your code here
        if(!hasNext()) {
            return null;
        }
        return stackj.pop();
    }

    public boolean hasNext() { // 准备下一个元素
        // Write your code here
        while (stackj.isEmpty() && !stack.isEmpty())
            pushListToStack(stack.pop());
        return !stackj.isEmpty();
    }
    
    public void remove() {}
}

//Juzihang SOlution 2
public class Vector2D implements Iterator<Integer> {

    private Iterator<List<Integer>> i;
    private Iterator<Integer> j;

    public Vector2D(List<List<Integer>> vec2d) {
        // Initialize your data structure here
        i = vec2d.iterator();
        j = null;
    }

    @Override
    public Integer next() {
        // Write your code here
        hasNext();
        return j.next();
    }

    @Override
    public boolean hasNext() {
        // Write your code here
        while ((j == null || !j.hasNext()) && i.hasNext())
            j = i.next().iterator();
        return j != null && j.hasNext();
    }

    @Override
    public void remove() {}
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
