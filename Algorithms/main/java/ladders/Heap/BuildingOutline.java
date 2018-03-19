package main.java.ladders.Heap;
/**
 * 131. Building Outline - Super

Given N buildings in a x-axis，each building is a rectangle and can be represented by a triple 
(start, end, height)，where start is the start position on x-axis, end is the end position on x-axis and
 height is the height of the building. Buildings may overlap if you see them from far away，find the outline of them。

An outline can be represented by a triple, (start, end, height), 
where start is the start position on x-axis of the outline, 
end is the end position on x-axis and height is the height of the outline.

Building Outline

 Notice
Please merge the adjacent outlines if they have the same height and make sure different outlines cant overlap on x-axis.

Have you met this question in a real interview? Yes
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