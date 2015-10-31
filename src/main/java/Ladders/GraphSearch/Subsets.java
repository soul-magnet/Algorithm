package GraphSearch;

import java.util.ArrayList;
import java.util.Collections;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;
/*
 * Given a set of distinct integers, return all possible subsets.
 * Example
 * If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
Note: 
Elements in a subset must be in non-descending order.

The solution set must not contain duplicate subsets.*/
/*
 * 1. Sort the arrayList to the non-descending order
 * 2. Backtracking
 * 
 * */
public class Subsets {
	
	/**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
	
	public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> S){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		result.add(new ArrayList<Integer>());
		
		if (S == null || S.size() == 0){
			return result;
		}
		Collections.sort(S);
		helper(result, S, new ArrayList<Integer>(), 0);
		return result;
	}
	
	private void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> S,ArrayList<Integer> cur, int i){
		for (int j = i; j < S.size(); j++){
			cur.add(S.get(j));
			result.add(new ArrayList<Integer>(cur));
			helper(result, S, cur, j + 1);
			cur.remove(S.get(j));
		}
	}
	
}
