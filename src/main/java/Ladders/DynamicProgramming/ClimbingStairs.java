package DynamicProgramming;

public class ClimbingStairs {
	// Iterative way
	public int climbingStairs(int n){
		if (n <= 1)
				return n;
		int now = 0;
		int last = 1;
		int lastlast = 1;
		
		for (int i = 0; i <n ; i++){
			now  = last + lastlast;
			last = lastlast;
			last= now;
		}
		return now;
	}
	// recursive way; not efficient 
	public int climbingStairsX(int n){
		if (n == 1) return 1;
		if (n == 2) return 2;
		if (n == 3) return 3;
		
		return climbingStairsX(n -1) + climbingStairsX(n - 2) + climbingStairsX(n - 3);
	}
}
