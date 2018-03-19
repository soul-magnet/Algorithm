/**
 *
 */
package MS.Onsite2017;

/**
 * Example
 * In array [9,3,2,4,8], the 3rd largest element is 4.
 *
 * In array [1,2,3,4,5], the 1st largest element is 5, 2nd largest element is 4,
 * 3rd largest element is 3 and etc.
 *
 * @author K25553
 * partition:
 */
public class KthLargestElement {
    public int kthLargestElement(int k, int[] nums) {
        return quickSelect(nums.length-k, nums, 0, nums.length-1);
    }

    private int quickSelect(int k, int[] nums, int l, int r) {
        if(l>=r){return nums[l];}
        int p = nums[l], l0=l, r0=r;
        while(l<r){
            while(l<r&&nums[r]>p){r--;}
            nums[l] = nums[r];
            while(l<r&&nums[l]<=p){l++;}
            nums[r] = nums[l];}
        nums[l] = p;// loop ends l==r, put pivot into array
        if(l==k){return  p ;}
        else if(k>l){return quickSelect(k, nums,l+1, r0);}
        else{return quickSelect(k,nums,l0,l-1);}
    }

    public int kthLargestElement1(int k, int[] nums) {
		return quickSort(nums.length-k, nums, 0, nums.length-1);
	}

    private int quickSort(int k, int[] nums, int l, int r) {
        if(l>=r){
            return nums[l];
        }
        int pivot = nums[l];
        int crt = l;
        int next = l+1;
        while(next<=r){
            if(nums[next]<=pivot){
                crt++;
                int temp = nums[crt];
                 nums[crt]= nums[next];
                nums[next]=temp;
            }
            next++;
        }
        int temp = nums[crt];
        nums[crt]= nums[l];
        nums[l]=temp;

            if (k == crt) {
                return nums[crt];
            }else if(k<crt){
                return quickSort(k, nums, l, crt-1);
            }else{
                return quickSort(k, nums, crt+1, r);
            }
    }
}
