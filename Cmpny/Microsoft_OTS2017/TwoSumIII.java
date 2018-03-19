package MS.OA2017;

import java.util.ArrayList;
import java.util.Arrays;

/**一道是给一个integer array 找出所有a+b = c.
 * Created by wtnwi on 1/13/2017.
 */
public class TwoSumIII {
    public ArrayList<ArrayList<Integer>> twoSum2(int[] nums, int target) {
    // Write your code here
    Arrays.sort(nums);
    int left = 0, right = nums.length - 1;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    while(left < right) {
        if(nums[left] + nums[right] > target) {
            right --;
        } else  if(nums[left] + nums[right] < target) {
            left ++;
        }else{
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(nums[left]);ans.add(nums[right]);
            res.add(ans);
        }
    }
    return res;
}
}
