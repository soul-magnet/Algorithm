package BreadthFirstSearch;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CourseSchedule {
	//hello
	public boolean canFinish(int numCourses, int[][] prerequisites){
		
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
	
	public static void main(String[] args){
		
		CourseSchedule ins = new CourseSchedule();
		
		int[][] tst1 = {{0, 1}, {1, 2}};
		
		int[][] tst2 = {{0, 1}, {1, 0}};
		
		System.out.println(ins.canFinish(3, tst1));
		
		System.out.println(ins.canFinish(2, tst2));
	}

}
