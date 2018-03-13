package main.java.ladders.BreadthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
616. Course Schedule II - Medium

There are a total of n courses you have to take, labeled from 0 to n - 1.
Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

Have you met this question in a real interview? Yes
Example
Given n = 2, prerequisites = [[1,0]]
Return [0,1]

Given n = 4, prerequisites = [1,0],[2,0],[3,1],[3,2]]
Return [0,1,2,3] or [0,2,1,3]

Tags: Amazon Topological Sort Breadth First Search Zenefits Facebook
Related Problems 
Hard Course Schedule III 20 %
Medium Course Schedule 23 %
Medium Sequence Reconstruction 19 %
Medium Topological Sorting 31 %
 * */

public class CourseScheduleII {
	/*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: the course order
     */
	 public int[] findOrder(int numCourses, int[][] prerequisites) {
         List[] edges = new ArrayList[numCourses];//list of neighbot for each node
         int[] degree = new int[numCourses];// indegree for each node, if indegree==0 root of tree
         //init degree and beighor matrix for each node
         for (int i = 0;i < numCourses; i++)
             edges[i] = new ArrayList<Integer>();

         for (int i = 0; i < prerequisites.length; i++) {
             degree[prerequisites[i][0]] ++ ;
             edges[prerequisites[i][1]].add(prerequisites[i][0]);
         }
         //init bfs: enque root of tree
         Queue queue = new LinkedList();
         for(int i = 0; i < degree.length; i++){
             if (degree[i] == 0) {
                 queue.add(i);
             }
         }
         //bfs: deque root, cut edges
         int count = 0;
         int[] order = new int[numCourses];
         while(!queue.isEmpty()){
             int course = (int)queue.poll();// deque root
             order[count] = course;
             count ++;
             int n = edges[course].size();
             for(int i = n - 1; i >= 0 ; i--){
                 int pointer = (int)edges[course].get(i);
                 degree[pointer]--;//cut edges
                 if (degree[pointer] == 0) {
                     queue.add(pointer);//find new root to enqueue
                 }
             }
         }

         if (count == numCourses)//check circle
             return order;

         return new int[0];
     }
}
