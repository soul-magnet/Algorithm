package main.java.ladders.TopologicalSort;

/**
 * 615. Course Schedule - Medium

There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, 
for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?


Example
Given n = 2, prerequisites = [[1,0]]
Return true

Given n = 2, prerequisites = [[1,0],[0,1]]
Return false

Tags 
Amazon Apple Zenefits Topological Sort Breadth First Search
Related Problems 
Hard Course Schedule III 20 %
Medium Course Schedule II 21 %
Medium Topological Sorting 31 %
 * */

public class CourseSchedule {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: true if can finish all courses or false
     */
    
    //BFS - passes online judge
    public boolean canFinish(int numCourses, int[][] prerequisites){
         
          ArrayList<ArrayList<Integer>> edges = new ArrayList<ArrayList<Integer>>();
          int[] incomingEdgeNum = new int[numCourses];
          
          for(int i = 0; i < numCourses; i++)
                edges.add(new ArrayList<Integer>());
          
          int courseNum;
          
          for(int i = 0; i < prerequisites.length; i++){
                courseNum = prerequisites[i][0];
                incomingEdgeNum[courseNum]++;
                edges.get(prerequisites[i][1]).add(prerequisites[i][0]);
           } 
         
           Queue<Integer> queue = new LinkedList<Integer>();
         
           for(int i = 0; i < incomingEdgeNum.length; i++){
                if(incomingEdgeNum[i] == 0)
                    queue.add(i);
            }
         
            int count = 0;
            while(!queue.isEmpty()){
                int currentCourse = queue.poll();
                count++;
            
             for(int i = 0; i < edges.get(currentCourse).size(); i++){
                 int pointer = edges.get(currentCourse).get(i);
                 incomingEdgeNum[pointer]--;
                 if(incomingEdgeNum[pointer] == 0)
                     queue.add(pointer);
             }
         }
         if(count < numCourses)
            return false;
         
         return true;
    
        
    }
    
    
 //DFS Version - Cannot pass Online Judge for large input
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        //prerequisites 0 crt course 1 prerequisit
        //map prerequisite -> follow up book
        //dfs if search current node, is visted , then circle(false), if
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
       for(int[] i: prerequisites){
           if(map.containsKey(i[1])){
               map.get(i[1]).add(i[0]);
           }else{
               map.put(i[1],new ArrayList());
               map.get(i[1]).add(i[0]);
           }
       }
        int visited [] = new int[numCourses];

        for(int i= 0; i< numCourses; i++){
            if(!dfs(map, visited, i)){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(Map<Integer, ArrayList<Integer>> map, int[] visited, int i) {
        //prune to cut all has been visited and not circle,
        //so 3 stages: visited before and there is not not circle -1, no visited 0, visited (circle)1
        if(!map.containsKey(i)){
            return true;
        }
        if ( visited[i]==-1){
            return true;
        }
        if( visited[i]==1){
            return false;
        }
        visited[i]=1;
        for(int j: map.get(i)){
            if(!dfs(map, visited, j))
                return false;
        }
        visited[i]=-1;
        return true;
    }
    
    //DFS - Another version
     public boolean canFinish2(int numCourses, int[][] prerequisites) {
        //prerequisites 0 crt course 1 prerequisit
        //map prerequisite -> follow up book
        //dfs if search current node, is visted , then circle(false), if
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int[] i: prerequisites){
            if(map.containsKey(i[1])){
                map.get(i[1]).add(i[0]);
            }else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i[0]);
                map.put(i[1],list);

            }
        }
        int visited [] = new int[numCourses];
        Stack<Integer> stack = new Stack<>();
        for(int i= 0; i< numCourses; i++){
            //no out degree not circle
            if(!map.containsKey(i)) {
                continue;
            }
            for(int j= 0; i< numCourses; i++){
                if(visited[j]==1){
                    visited[j]=-1;
                }
            }
            if( visited[i]==-1){
                continue;
            }
            stack.push(i);
            // dfs visited crt node,
            while(!stack.isEmpty()){
                int crt = stack.pop();
                //visited i in crt dfs 2 times == circle
                if(visited[crt]==1){
                    return false;
                }
                //visited crt in other branch of dfs 2 times -> pruned
                if(visited[crt]==-1){
                    continue;
                }
                if(!map.containsKey(crt)) {
                    continue;
                }
                //if not visited, push to its vetice num to ct stack , and push to stack, marked visted ==1 in crt,

                for( int j: map.get(crt)){
                        stack.push(j);
                }
                visited[crt]= 1;
            }
            visited[i]=-1;
        }
        return true;
    }

    
    
   
}