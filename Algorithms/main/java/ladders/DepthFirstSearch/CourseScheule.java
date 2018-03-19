import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * In college some courses have other pre-required courses such that  if a student wants to take a course with 
 * pre-required courses, she must first complete the pre-required courses,
 * before being able to take the course itself. She is given all the list of courses and the pre-requirement courses
 * for each of them. The student has not taken any courses yet. Given a specific course, write the implementation
 * of the function that finds out if it's possible for the student to take the course and 
 * in which order courses must be completed.
 * 
 * Example Function Prototype: 
 * 
 * int[] getCourseOrder(int[][]courseInfo, int courseToTake)
 * 
 * Example input courses information:
 * 
 * course  Pre-Req
 *  0		null
 *  1		[0]
 *  2		[1]
 *  3		[1, 0]
 *  
 *  courseToTake: 0 Expected Output [0]
 *  courseToTake: 1 Expected Output [0, 1]
 *  courseToTake: 2 Expected Output [0, 1, 2]
 *  courseToTake: 3 Expected Output [0, 1, 3]
 * */
public class CourseSchedule {
	/*
     * @param courseToTake: a total of n courses
     * @param courseInfo: a list of prerequisite pairs
     * @return: the course order
     */
	
	public int[] getCourseOrder(int[][]courseInfo, int courseToTake){
		List[] edges = new ArrayList[courseToTake]; //lsit of neighbor to each node
		int[] degree = new int[courseToTake]; //indegree for each node, if indegree == 0 root of tree
		
		//initialize degree and neighbor matrix for each node
		for(int i = 0; i < courseToTake; i++){
			edges[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < courseInfo.length; i++){
			degree[courseToTake[i][0]]++;
			edges[courseToTake[i][1]].add(courseToTake[i][0]);
		}
		
		//init bfs: enqueue root of tree
		Queue queue = new LinkedList<>();
		for(int i = 0; i < degree.length; i++){
			if(degree[i] == 0)
				queue.add(i);
		}
		
		//bfs: dequeue, root, cut edges
		int count  = 0;
		int[] order = new int[courseToTake];
		while(!queue.isEmpty()){
			int course = (int)queue.poll();//deque root
			order[count] = course;
			count++;
			int n = edges[course].szie();
			for(int i = n - 1; i >= 0; i--){
				int pointer =(int)edges[course].get(i);
				degree[pointer]--; //cut edges
				if(degree[pointer] == 0){
					queue.add(pointer);
				}
			}
		}//end of while
		
		if(count  == courseToTake) //check circle
			return order;
		
		return new int[0];
	}
}
