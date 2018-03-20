/**
 * 
 */
package Microsoft_OTS2017;

/**
  * Given an array of n objects with k different colors (numbered from 1 to k), 
	 * sort them so that objects of the same color are adjacent, 
	 * with the colors in the order 1, 2, ... k.

Example
Given colors=[3, 2, 2, 1, 4], k=4, your code should sort colors in-place to [1, 2, 2, 3, 4].
 * @author Tiannan
http://www.opendatastructures.org/ods-java/11_2_Counting_Sort_Radix_So.html
 */
public class SortColors2 {
	/**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    /*
    Solution 1: Using the quick sort.
    */ 
    public void sortKColors1(int[] colors, int k) {
        // write your code here
        if (colors == null) {
            return;
        }
        
        quickSort(colors, 0, colors.length - 1);
    }
    
    public void quickSort(int[] colors, int left, int right) {
        if (left >= right) {
            return;
        }
        
        int pivot = colors[right];
        
        int pos = partition(colors, left, right, pivot);
        
        quickSort(colors, left, pos - 1);
        quickSort(colors, pos + 1, right);
    }
    
    public int partition(int[] colors, int left, int right, int pivot) {
        int leftPoint = left - 1;
        int rightPoint = right;
        
        while (true) {
            while (colors[++leftPoint] < pivot);
            
            while (leftPoint < rightPoint && colors[--rightPoint] > pivot);
            
            if (leftPoint >= rightPoint) {
                break;
            }
            
            swap(colors, leftPoint, rightPoint);
        }
        
        swap(colors, leftPoint, right);
        return leftPoint;
    }
    
    public void swap(int[] colors, int left, int right) {
        int tmp = colors[left];
        colors[left] = colors[right];
        colors[right] = tmp;
    }
	public void sortKColors(int[] colors, int k) {
        // write your code here
        if (colors == null) {
            return;
        }
        
        int len = colors.length;
        for (int i = 0; i < len; i++) {
            // Means need to deal with A[i]
            while (colors[i] > 0) {
                int num = colors[i];
                if (colors[num - 1] > 0) {    
                    // 1. There is a number in the bucket, 
                    // Store the number in the bucket in position i;
                    colors[i] = colors[num - 1];
                    colors[num - 1] = -1;
                } else if (colors[num - 1] <= 0) {
                    // 2. Bucket is using or the bucket is empty.
                    colors[num - 1]--;
                    // delete the A[i];
                    colors[i] = 0;
                }
            }
        }
        
        int index = len - 1;
        for (int i = k - 1; i >= 0; i--) {
            int cnt = -colors[i];
            
            // Empty number.
            if (cnt == 0) {
                continue;
            }
                                
            while (cnt > 0) {
                colors[index--] = i + 1;
                cnt--;
            }
        }
	}
	public void sortColors2(int[] colors, int k) {
        // write your code here
        // bucket sort inplace  On
        // use index as bucket to store the num of values
        // use -the num of values to differentiate the value and the number of the value
        // use 0 to represent current value is stored in bucket and it is empty now
        //as the result the sequence would be -1 -2 0 -1 0
        // the kth ele from k-1 - 0 
        // loop from len-1 to 0 to place the number of ele
        int max= Integer.MIN_VALUE;
        int [] ct= new int [k];
        for (int i: colors){
            ct[i-1]++;
        }
        // for(int i=1; i< colors.lentgh;i++){
        //     ct[i]+=ct[i-1];
        // }
        int index= colors.length-1;
        for (int i=k-1; i>-1; i--){
            while(ct[i]>0){
                colors[index]= i+1;
                index--;
                ct[i]--;
            }
        }
    } 
	/**
	
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
