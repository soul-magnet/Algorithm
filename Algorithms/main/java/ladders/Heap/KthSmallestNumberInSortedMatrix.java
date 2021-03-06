package main.java.ladders.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
/***
 * LintCode Advanced Algorithms - Ladder 1 - Follow Up In Coding Interviews
 * 
 * 401. Kth Smallest Number in Sorted Matrix 
 * Find the kth smallest number in at row and column sorted matrix.
 * 
 * Example
	Given k = 4 and a matrix:
	
	[
	  [1 ,5 ,7],
	  [3 ,7 ,8],
	  [4 ,8 ,9],
	]
	return 5
	
	Challenge: Solve it in O(k log n) time where n is the bigger one between row size and column size.
	
	Tags: Heap Priority Queue Matrix
	
	Related Problems 
    1 - Hard Kth Smallest Sum In Two Sorted Arrays 27 %(Hard)
	2 - Medium Kth Largest Element (Medium)
*/
/*Analysis: 
The idea is using min heap.
1. Build a min heap of elements from first row. A heap entry also stores
row number and column number
2. Do the following k times
	a) Get minimum element(or root) from min heap
	b) find row number and column number in minimum element
	c) Replace root with the next element from same column and min-heapify the root
3. Return the last extracted root.  
*/
public class KthSmallestNumberInSortedMatrix {
	/**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
     */
	public int kthSmallest(final int[][] matrix, int k) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(k, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return Integer.compare(matrix[a[0]][a[1]], matrix[b[0]][b[1]]);
            }
        });
        
        heap.add(new int[]{0,0});
        visited[0][0] = true;
        
        while (k > 1) {
            int[] res = heap.remove();
            int x = res[0];
            int y = res[1];
             
             
            if (x+1 < matrix.length && visited[x+1][y] == false) {
                visited[x+1][y] = true;
                heap.add(new int[]{x+1, y});
            }
            if (y+1 < matrix[0].length && visited[x][y+1] == false) {
                visited[x][y+1] = true;
                heap.add(new int[]{x, y+1});
            }
            k--;
        }
        int[] res = heap.remove();
        return matrix[res[0]][res[1]];
    }
	
	// Another solution from jiuzhang
	
	public class Point {
        public int x, y, val;
        public Point(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    } 
    
    Comparator<Point> comp = new Comparator<Point>() {
        public int compare(Point left, Point right) {
            return left.val - right.val;
        }
    };
    
    public int kthSmallest1(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        if (k > matrix.length * matrix[0].length) {
            return 0;
        }
        return horizontal(matrix, k);
    }
    
    private int horizontal(int[][] matrix, int k) {
        Queue<Point> heap = new PriorityQueue<Point>(k, comp);
        for (int i = 0; i < Math.min(matrix.length, k); i++) {
            heap.offer(new Point(i, 0, matrix[i][0]));
        }
        for (int i = 0; i < k - 1; i++) {
            Point curr = heap.poll();
            if (curr.y + 1 < matrix[0].length) {
                heap.offer(new Point(curr.x, curr.y + 1, matrix[curr.x][curr.y + 1]));
            }
        }
        return heap.peek().val;
    }
    
    private int vertical(int[][] matrix, int k) {
        Queue<Point> heap = new PriorityQueue<Point>(k, comp);
        for (int i = 0; i < Math.min(matrix[0].length, k); i++) {
            heap.offer(new Point(0, i, matrix[0][i]));
        }
        for (int i = 0; i < k - 1; i++) {
            Point curr = heap.poll();
            if (curr.x + 1 < matrix.length) {
                heap.offer(new Point(curr.x + 1, curr.y, matrix[curr.x + 1][curr.y]));
            }
        }
        return heap.peek().val;
    }
}
