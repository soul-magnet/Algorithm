package Ladder7.FollowUp;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 401. Kth Smallest Number in Sorted Matrix - Medium - Required

Find the kth smallest number in at row and column sorted matrix.

Example
Given k = 4 and a matrix:

[
  [1 ,5 ,7],
  [3 ,7 ,8],
  [4 ,8 ,9],
]
return 5

Challenge 
Solve it in O(k log n) time where n is the bigger one between row size and column size.

Tags:Heap Priority Queue Matrix

Related Problems 
Hard Kth Smallest Sum In Two Sorted Arrays 27 %
Medium Kth Largest Element 26 %
 * */
public class KthSmallestNumberInSortedMatrix {
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

	public int kthSmallest(int[][] matrix, int k) {
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
				heap.offer(new Point(curr.x, curr.y + 1,
						matrix[curr.x][curr.y + 1]));
			}
		}
		return heap.peek().val;
	}

}
