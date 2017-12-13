package BreadthFirstSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CourseSchedule {
	//BFS Version 1 - cannot pass OJ - getting memory limit exceeds error
	public boolean canFinishBFS(int numCourses, int[][] prerequisites){
		
		if(numCourses <= 1) return true;
		
		if(prerequisites.length == 0 || prerequisites[0].length == 0) return true;
		
		Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();
		
		//build graph
		for(int i = 0; i < numCourses; i++){
			graph.put(i, new HashSet<Integer>());
		}
		for(int i = 0; i < prerequisites.length; i++){
			graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
		}
		//BFS
		Queue<Integer> queue = new LinkedList<Integer>();
		int courseReaming = numCourses;
		for(Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()){
			if(entry.getValue().size() == 0){
				queue.offer(entry.getKey());
				courseReaming--;
			}
		}
		
		while(!queue.isEmpty()){
			int key = queue.poll();
			
			for(Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()){
				if(entry.getValue().contains(key)){
					entry.getValue().remove(key);
					if(entry.getValue().size() == 0){
						queue.offer(entry.getKey());
						courseReaming--;
						}
					}
			}
		}
		
		return courseReaming == 0;
	}
	
	//BFS Version 2 - Passes OJ - works well with large input
	public boolean canFinish(int numCourses, int[][] prerequisites){
		//1. Construct a list of Integer List as the adjacency list representation of the given graph
		ArrayList<ArrayList<Integer>> edges = new ArrayList<ArrayList<Integer>>();
		
		//2. Construct a count array that stores the number of incoming edges of each vertex
		int[] indegrees = new int[numCourses]; //incoming edge number
		
		for(int i = 0; i < numCourses; i++){
			edges.add(new ArrayList<Integer>());
		}
		
		int courseNum;
		for(int i = 0 ; i < prerequisites.length; i++){
			courseNum = prerequisites[i][0];
			indegrees[courseNum]++;
			edges.get(prerequisites[i][1]).add(prerequisites[i][0]);
		}
		
		//3. Add all vertices whose incoming edges are 0 to a queue; and start BFS traversal.
		// Keep a count of how many vertices are explored
		Queue<Integer> queue = new LinkedList<Integer>();
		int count= 0;
		
		while(!queue.isEmpty()){
			int currentVertex = queue.poll();
			count++;
			
			//4. Each time a vertex is dequeued, conceptually cut this vertex and its outgoing edges from graph.
			//To do this, update its neighbors' incoming edges numbers by deducting 1.
			//Add any neighbors whose incoming edges is 0 to the queue.
			//repeat this step until quee is empty
			for(int i = 0; i < edges.get(currentVertex).size(); i++){
				int pointer = edges.get(currentVertex).get(i);
				indegrees[pointer]--;
				if(indegrees[pointer] == 0)
					queue.add(pointer);
			}
		}
		
		//5. Check if the count is the same with the total number of given vertices;
		//if not, it means there is at least one directed cycle in the constructed graph
		//vertices are not explored are all the vertices in the cycle
		if(count < numCourses)
			return false;
		
		return true;
	}
	
	//DFS Version Topological Sort - OJ cannot pass for large input
	
	/**
	 * Run DFS for each connected component to detect cycle
	 * 3 integer to represent visit status
	 * During recursion, if we follow a back edge which points to a previous node which is being visited, 
	 * then we find a cycle.
	 * */
	public boolean canFinishDFS(int numCourses, int[][] prerequisities){
		Map<Integer, ArrayList<Integer>> map = new HashMap<>();
		for(int[] i : prerequisities){
			if(map.containsKey(i[1])){
				map.get(i[1]).add(i[0]);
			}else{
				map.put(i[1], new ArrayList());
				map.get(i[1]).add(i[0]);
			}
		}
		
		int visited[] = new int[numCourses];
		for(int i = 0; i < numCourses; i++){
			if(!dfs(map,visited, i)){
				return false;
			}
		}
		
		return true;
	}
	
	private boolean dfs(Map<Integer, ArrayList<Integer>> map, int[] visited, int i){
		if(!map.containsKey(i))
			return true;
		if(visited[i] == 1)
			return false;
		if(visited[i] == -1)
			return true;
		for(int j : map.get(i)){
			if(!dfs(map, visited, i)){
				return false;
			}
			
			visited[i] = -1;
		}
		
		return true;
	}
	
	
	
	
	public static void main(String[] args){
		
		CourseSchedule ins = new CourseSchedule();
		
		int[][] tst1 = {{0, 1}, {1, 2}};
		
		int[][] tst2 = {{0, 1}, {1, 0}};
		
		System.out.println(ins.canFinishBFS(3, tst1));
		
		System.out.println(ins.canFinishBFS(2, tst2));
	}

}
