import java.util.ArrayList;
import java.util.Collections;

// Given a 2D grid, each cell is either an house 1 or empty 0 (the number zero, one), 
// find the place to build a post office, the distance that post office to all the house sum is smallest. 
//   Return the smallest distance. Return -1 if it is not possible.

//  Notice
// You can pass through house and empty.
// You only build post office on an empty.

// Example
// Given a grid:

// 0 1 0 0
// 1 0 1 1
// 0 1 0 0
// return 6. (Placing a post office at (1,1), the distance that post office to all the house sum is smallest.)

// Tags 
// Sort Binary Search

public class BuildPostOfficeI {
      class Node {
        int x, y ;
        Node(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    /**too slow
     * @param grid a 2D grid
     * @return an integer
     */
    public int shortestDistance(int[][] grid) {
        // Write your code here
      ArrayList<Integer> x = new ArrayList<>();
      ArrayList<Integer> y = new ArrayList<>();
      ArrayList<Integer> sumX = new ArrayList<>();
      ArrayList<Integer> sumY = new ArrayList<>();
      
      for(int i = 0; i < grid.length; i++){
          for(int j = 0; j < grid[0].length; j++){
            if(grid[i][j] == 1){
              x.add(i);
              y.add(j);
            }
          }
      }
      
      Collections.sort(x);
      Collections.sort(y);
      
      sumX.add(x.get(0));
      sumY.add(y.get(0));
      
      for(int i = 1; i < x.size(); i++){
          sumX.add(x.get(i) + sumX.get(i - 1));
          sumY.add(y.get(i) + sumY.get(i - 1));
      }
      
      int result = Integer.MAX_VALUE;
      
      for(int i = 0; i < grid.length; i++){
        for(int j = 0; j < grid[0].length; j++){
          if(grid[i][j] == 0){
              int distanceX = distance(i, x, sumX);
              int distanceY = distance(j, x, sumY);
              result = Math.min(result, distanceX + distanceY);
          }
        }
      }
      return result;
    }
  
  private int distance (int crt, ArrayList<Integer> x, ArrayList<Integer> sumX){
     int l = 0, r = x.size() - 1;
     while(l+1 < r){
       int mid = l + (r - l)/2;
       if(x.get(mid) <= crt){
          l = mid;
       }else{
         r = mid;
       }
     }
    int index = 0;
    if(x.get(r) < crt){
      index = r;
    }else{
      index = l;
    }
    int last = sumX.size() -1;
    int after = (sumX.get(last) - sumX.get(index)) - crt*(last - index);
    int front = crt*(index+1) - sumX.get(index);
    
    return after+front;
  }
}
