package Microsoft;
/**
 * 531. Six Degrees - Medium

Six degrees of separation is the theory that everyone and everything is six or fewer steps away, by way of introduction, from any other person in the world, so that a chain of "a friend of a friend" statements can be made to connect any two people in a maximum of six steps.

Given a friendship relations, find the degrees of two people, return -1 if they can not been connected by friends of friends.

Have you met this question in a real interview? Yes
Example
Gien a graph:

1------2-----4
 \          /
  \        /
   \--3--/
{1,2,3#2,1,4#3,1,4#4,2,3} and s = 1, t = 4 return 2

Gien a graph:

1      2-----4
             /
           /
          3
{1#2,4#3,4#4,2,3} and s = 1, t = 4 return -1

Tags: Microsoft

Related Problems 
Medium Clone Graph 29 %
 * */

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x;
 *         neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */
public class SixDegrees {
    /**
     * @param graph a list of Undirected graph node
     * @param s, t two Undirected graph nodes
     * @return an integer
     */
    public int sixDegrees(List<UndirectedGraphNode> graph,
                          UndirectedGraphNode s,
                          UndirectedGraphNode t) {


        if(t==s){
            return 0;
        }
        Map<UndirectedGraphNode,Integer> visited = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        visited.put(s,0);queue.offer(s);
        while(!queue.isEmpty()){
            UndirectedGraphNode node = queue.poll();
            int degree = visited.get(node);
            for(UndirectedGraphNode neighbor:node.neighbors){
                if(visited.containsKey(neighbor)){
                    continue;
                }else{
                    if(neighbor==t){
                        return degree+1;
                    }
                    visited.put(neighbor,degree+1);
                    
                    queue.offer(neighbor);
                    
                }
            }
        }
        
        return -1;
    }
}
