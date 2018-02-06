package Ladder3.DataStructure_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 131. Building Outline - Hard - Optional

Given N buildings in a x-axis，each building is a rectangle and can be represented by a triple (start, end, height)，
where start is the start position on x-axis, end is the end position on x-axis and 
height is the height of the building. Buildings may overlap if you see them from far away，
find the outline of them。

An outline can be represented by a triple, (start, end, height), 
where start is the start position on x-axis of the outline, 
end is the end position on x-axis and height is the height of the outline.

Building Outline

 Notice
Please merge the adjacent outlines if they have the same height and 
make sure different outlines cant overlap on x-axis.

Example
Given 3 buildings：

[
  [1, 3, 3],
  [2, 4, 4],
  [5, 6, 1]
]
The outlines are：

[
  [1, 2, 3],
  [2, 4, 4],
  [5, 6, 1]
]
Tags 
LintCode Copyright Heap Google
Related Problems 
Hard Sliding Window Median 18 %
 * */
public class BuildingOutline {
	class Edge {
		int pos;int height;boolean isStart;
		public Edge(int pos, int height, boolean isStart) {
			this.pos = pos;this.height = height;this.isStart = isStart;
		}

	}
	class EdgeComparator implements Comparator<Edge> {
		@Override
		public int compare(Edge arg1, Edge arg2) {
			Edge l1 = (Edge) arg1;Edge l2 = (Edge) arg2;
			if (l1.pos != l2.pos)
				return compareInteger(l1.pos, l2.pos);
			if (l1.isStart && l2.isStart) {//both same start, higher start first
				return compareInteger(l2.height, l1.height);
			}//both end, higher end later,
			if (!l1.isStart && !l2.isStart) {
				return compareInteger(l1.height, l2.height);
			}//one start, the other end, start first
			return l1.isStart ? -1 : 1;
		}
		int compareInteger(int a, int b) {
			return a <= b ? -1 : 1;
		}
	}
	public ArrayList<ArrayList<Integer>> buildingOutline(int[][] buildings) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

		if (buildings == null || buildings.length == 0
				|| buildings[0].length == 0) {
			return res;
		}
		PriorityQueue<Edge> edges = new PriorityQueue<>(buildings.length*2,new EdgeComparator());
		for (int[] building : buildings) {
			Edge startEdge = new Edge(building[0], building[2], true);
			edges.add(startEdge);
			Edge endEdge = new Edge(building[1], building[2], false);
			edges.add(endEdge);
		}
		PriorityQueue<Integer> max = new PriorityQueue<>(1, Collections.reverseOrder());
		while(!edges.isEmpty()){
			Edge now = edges.poll();
			if(now.isStart){
				if(max.isEmpty()||now.height>max.peek()){
					res.add(new ArrayList<>(Arrays.asList(now.pos,now.height)));
				}
				max.add(now.height);
			}else{
				max.remove(now.height);
				if(max.isEmpty()){
					res.add(new ArrayList<>(Arrays.asList(now.pos,0)));
				}else if(now.height>max.peek()){
					res.add(new ArrayList<>(Arrays.asList(now.pos,max.peek())));
				}
			}
		}
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		if (res.size() > 0) {
			int pre = res.get(0).get(0);
			int height = res.get(0).get(1);
			for (int i = 1; i < res.size(); i++) {
				ArrayList<Integer> list = new ArrayList<Integer>();
				int id = res.get(i).get(0);
				if (height > 0) {
					list.add(pre);
					list.add(id);
					list.add(height);
					ans.add(list);
				}
				pre = id;
				height = res.get(i).get(1);
			}
		}
		return ans;
	}
	

}

//Juizhang Solution
//import java.util.*;
//
//public class Solution {
//
//  class HashHeap {
//    ArrayList<Integer> heap;
//    String mode;
//    int size_t;
//    HashMap<Integer, Node> hash;
//
//    class Node {
//      public Integer id;
//      public Integer num;
//
//      Node(Node now) {
//        id = now.id;
//        num = now.num;
//      }
//
//      Node(Integer first, Integer second) {
//
//        this.id = first;
//        this.num = second;
//      }
//    }
//
//    public HashHeap(String mod) {
//      // TODO Auto-generated constructor stub
//      heap = new ArrayList<Integer>();
//      mode = mod;
//      hash = new HashMap<Integer, Node>();
//      size_t = 0;
//    }
//
//    public int peek() {
//      return heap.get(0);
//    }
//
//    public int size() {
//      return size_t;
//    }
//
//    public Boolean isEmpty() {
//      return (heap.size() == 0);
//    }
//
//    int parent(int id) {
//      if (id == 0) {
//        return -1;
//      }
//      return (id - 1) / 2;
//    }
//
//    int lson(int id) {
//      return id * 2 + 1;
//    }
//
//    int rson(int id) {
//      return id * 2 + 2;
//    }
//
//    boolean comparesmall(int a, int b) {
//      if (a <= b) {
//        if (mode == "min")
//          return true;
//        else
//          return false;
//      } else {
//        if (mode == "min")
//          return false;
//        else
//          return true;
//      }
//
//    }
//
//    void swap(int idA, int idB) {
//      int valA = heap.get(idA);
//      int valB = heap.get(idB);
//
//      int numA = hash.get(valA).num;
//      int numB = hash.get(valB).num;
//      hash.put(valB, new Node(idA, numB));
//      hash.put(valA, new Node(idB, numA));
//      heap.set(idA, valB);
//      heap.set(idB, valA);
//    }
//
//    public Integer poll() {
//      size_t--;
//      Integer now = heap.get(0);
//      Node hashnow = hash.get(now);
//      if (hashnow.num == 1) {
//        swap(0, heap.size() - 1);
//        hash.remove(now);
//        heap.remove(heap.size() - 1);
//        if (heap.size() > 0) {
//          siftdown(0);
//        }
//      } else {
//        hash.put(now, new Node(0, hashnow.num - 1));
//      }
//      return now;
//    }
//
//    public void add(int now) {
//      size_t++;
//      if (hash.containsKey(now)) {
//        Node hashnow = hash.get(now);
//        hash.put(now, new Node(hashnow.id, hashnow.num + 1));
//
//      } else {
//        heap.add(now);
//        hash.put(now, new Node(heap.size() - 1, 1));
//      }
//
//      siftup(heap.size() - 1);
//    }
//
//    public void delete(int now) {
//      size_t--;
//      Node hashnow = hash.get(now);
//      int id = hashnow.id;
//      int num = hashnow.num;
//      if (hashnow.num == 1) {
//
//        swap(id, heap.size() - 1);
//        hash.remove(now);
//        heap.remove(heap.size() - 1);
//        if (heap.size() > id) {
//          siftup(id);
//          siftdown(id);
//        }
//      } else {
//        hash.put(now, new Node(id, num - 1));
//      }
//    }
//
//    void siftup(int id) {
//      while (parent(id) > -1) {
//        int parentId = parent(id);
//        if (comparesmall(heap.get(parentId), heap.get(id)) == true) {
//          break;
//        } else {
//          swap(id, parentId);
//        }
//        id = parentId;
//      }
//    }
//
//    void siftdown(int id) {
//      while (lson(id) < heap.size()) {
//        int leftId = lson(id);
//        int rightId = rson(id);
//        int son;
//        if (rightId >= heap.size()
//            || (comparesmall(heap.get(leftId), heap.get(rightId)) == true)) {
//          son = leftId;
//        } else {
//          son = rightId;
//        }
//        if (comparesmall(heap.get(id), heap.get(son)) == true) {
//          break;
//        } else {
//          swap(id, son);
//        }
//        id = son;
//      }
//    }
//  }
//
//  class Edge {
//    int pos;
//    int height;
//    boolean isStart;
//
//    public Edge(int pos, int height, boolean isStart) {
//      this.pos = pos;
//      this.height = height;
//      this.isStart = isStart;
//    }
//
//  }
//
//  class EdgeComparator implements Comparator<Edge> {
//    @Override
//    public int compare(Edge arg1, Edge arg2) {
//      Edge l1 = (Edge) arg1;
//      Edge l2 = (Edge) arg2;
//      if (l1.pos != l2.pos)
//        return compareInteger(l1.pos, l2.pos);
//      if (l1.isStart && l2.isStart) {
//        return compareInteger(l2.height, l1.height);
//      }
//      if (!l1.isStart && !l2.isStart) {
//        return compareInteger(l1.height, l2.height);
//      }
//      return l1.isStart ? -1 : 1;
//    }
//
//    int compareInteger(int a, int b) {
//      return a <= b ? -1 : 1;
//    }
//  }
//
//  List<List<Integer>> output(List<List<Integer>> res) {
//    List<List<Integer>> ans = new ArrayList<List<Integer>>();
//    if (res.size() > 0) {
//      int pre = res.get(0).get(0);
//      int height = res.get(0).get(1);
//      for (int i = 1; i < res.size(); i++) {
//        List<Integer> now = new ArrayList<Integer>();
//        int id = res.get(i).get(0);
//        if (height > 0) {
//          now.add(pre);
//          now.add(id);
//          now.add(height);
//          ans.add(now);
//        }
//        pre = id;
//        height = res.get(i).get(1);
//      }
//    }
//    return ans;
//  }
//
//  public List<List<Integer>> buildingOutline(int[][] buildings) {
//    // write your code here
//    List<List<Integer>> res = new ArrayList<List<Integer>>();
//
//    if (buildings == null || buildings.length == 0
//        || buildings[0].length == 0) {
//      return res;
//    }
//    ArrayList<Edge> edges = new ArrayList<Edge>();
//    for (int[] building : buildings) {
//      Edge startEdge = new Edge(building[0], building[2], true);
//      edges.add(startEdge);
//      Edge endEdge = new Edge(building[1], building[2], false);
//      edges.add(endEdge);
//    }
//    Collections.sort(edges, new EdgeComparator());
//
//    HashHeap heap = new HashHeap("max");
//
//    List<Integer> now = null;
//    for (Edge edge : edges) {
//      if (edge.isStart) {
//        if (heap.isEmpty() || edge.height > heap.peek()) {
//          now = new ArrayList<Integer>(Arrays.asList(edge.pos,
//              edge.height));
//          res.add(now);
//        }
//        heap.add(edge.height);
//      } else {
//        heap.delete(edge.height);
//        if (heap.isEmpty() || edge.height > heap.peek()) {
//          if (heap.isEmpty()) {
//            now = new ArrayList<Integer>(Arrays.asList(edge.pos, 0));
//          } else {
//            now = new ArrayList<Integer>(Arrays.asList(edge.pos,
//                heap.peek()));
//          }
//          res.add(now);
//        }
//      }
//    }
//    return output(res);
//  }
//
//}
