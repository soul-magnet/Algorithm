package String;

import java.util.ArrayList;
import java.util.Collections;

/*Given a list of numbers that may has duplicate numbers, 
 * return all possible subsets
 * 
 * Example: If S = [1,2,2], a solution is:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 * Note: Each element in a subset must be in non-descending order.
 * The ordering between two subsets is free.
 * The solution set must not contain duplicate subsets.
 * */
public class SubsetsII {
	/**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result.add(new ArrayList<Integer>());
        
        if (S == null || S.size() == 0){
        	return result;
        }
        Collections.sort(S);
        helper(result, S, new ArrayList<Integer>(), 0);
        return result;
    }

	private void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> S, ArrayList<Integer> current,
			int i) {
		for (int j = i; j < S.size(); j++){
			/*Not enough to check each condition*/
			/*if (! result.contains(S.get(j)))*/
			if (j > i && S.get(j) == S.get(j - 1)){
				continue;
			}
				current.add(S.get(j));
				result.add(new ArrayList<Integer>(current));
				helper(result, S, current, j + 1);
				current.remove(S.get(j));
		}
		
	}
}
