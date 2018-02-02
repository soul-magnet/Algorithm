package DataStructure;

import java.util.Stack;

/*
 * Use Stack to keep track of height and start indexes
 * Compare current height with previous one
 * #1: current > previous(top of height stack)
 * Push current height & index as candidate rectangle start position
 * 
 * #2: current == previous 
 * Ignore, as largest rectangle will start from previous with same height
 * 
 * #3: current < previous
 * Need keep popping out previous heights, and compute the candidate rectangle 
 * with height and width(current index - previous index)
 * Push the height and the index appropriate position
 * 
 * http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
 * 
 * We traverse all bars from left to right, maintain a stack of bars. 
 * Every bar is pushed to stack once. 
 * A bar is popped from stack when a bar of smaller height is seen.
 * When a bar is popped, we calculate the area with the popped bar as smallest bar.
 * How do we get left and right indexes of the popped bar?
 * The current index tells us the 'right index' and index of previous item 
 * in stack is the left index. 
 * 
 * 1. Create an empty stack
 * 2. Start from first bar, and do following for every bar his[i] where i's varies from 0 to n-1.
 * 		a) if stack is empty or his[i] is higher than the bar at top of stack, then push "i" to stack.
 * 		b) if this bar is smaller than the top of stack, then keep removing the top of stack 
 * 		   while top of the stack is greater. Let the removed bar be hist[tp].
 * 		   calculate area of rectangle with hist[tp] as smallest bar. For hist[tp], the 'left index' is previous (previous to tp) item in stack 
 * 		   and "right index" is i's (current index)
 * 3. If the stack is not empty, then one by one remove all bars from stack and do step 2.b for every removed bar.
 * 
 * Time Complexity: Since every bar is pushed and popped only once, the time complexity 
 * of this method is O(n)
 * 
 **/
public class LargestRectangleInHistogram {
	
	public int largestRectangleArea(int [] height){
		if (height == null || height.length == 0) {
			return 0;
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		int maxArea = 0;
		for (int i = 0; i < height.length; i++) {
			int curent = (i == height.length) ? -1 : height[i];
			while(!stack.isEmpty() && curent <= height[stack.peek()]) {
				int h = height[stack.pop()];
				int w = stack.isEmpty() ? i : i - stack.peek() - 1;
				maxArea = Math.max(maxArea, h * w);
			}
			stack.push(i);
		}
		return maxArea;
	}

}

// Another approach

/*
 * public class MaximumHistogram {

    public int maxHistogram(int input[]){
        Deque<Integer> stack = new LinkedList<Integer>();
        int maxArea = 0;
        int area = 0;
        int i;
        for(i=0; i < input.length;){
            if(stack.isEmpty() || input[stack.peekFirst()] <= input[i]){
                stack.offerFirst(i++);
            }else{
                int top = stack.pollFirst();
                //if stack is empty means everything till i has to be
                //greater or equal to input[top] so get area by
                //input[top] * i;
                if(stack.isEmpty()){
                    area = input[top] * i;
                }
                //if stack is not empty then everythin from i-1 to input.peek() + 1
                //has to be greater or equal to input[top]
                //so area = input[top]*(i - stack.peek() - 1);
                else{
                    area = input[top] * (i - stack.peekFirst() - 1);
                }
                if(area > maxArea){
                    maxArea = area;
                }
            }
        }
        while(!stack.isEmpty()){
            int top = stack.pollFirst();
            //if stack is empty means everything till i has to be
            //greater or equal to input[top] so get area by
            //input[top] * i;
            if(stack.isEmpty()){
                area = input[top] * i;
            }
            //if stack is not empty then everything from i-1 to input.peek() + 1
            //has to be greater or equal to input[top]
            //so area = input[top]*(i - stack.peek() - 1);
            else{
                area = input[top] * (i - stack.peekFirst() - 1);
            }
        if(area > maxArea){
                maxArea = area;
            }
        }
        return maxArea;
    }
    
    public static void main(String args[]){
        MaximumHistogram mh = new MaximumHistogram();
        int input[] = {2,2,2,6,1,5,4,2,2,2,2};
        int maxArea = mh.maxHistogram(input);
        //System.out.println(maxArea);
        assert maxArea == 12;
    }
}
*/
