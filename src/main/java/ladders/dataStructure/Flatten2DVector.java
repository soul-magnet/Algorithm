package main.java.ladders.dataStructure;

import java.util.List;

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

Tags: Airbnb Twitter Zenefits Google

Related Problems 
Medium Zigzag Iterator 44 %
Medium Flatten Nested List Iterator 28 %
Easy Flatten Binary Tree to Linked List 33 %
Easy Flatten List 29 %
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
