/**
 * 
 */
package MS.OA2017;

/**
  * Given an array of n objects with k different colors (numbered from 1 to k), 
	 * sort them so that objects of the same color are adjacent, 
	 * with the colors in the order 1, 2, ... k.

Example
Given colors=[3, 2, 2, 1, 4], k=4, your code should sort colors in-place to [1, 2, 2, 3, 4].
 * @author Tiannan
 *inplace，并且O(N)时间复杂度的算法。

我们可以使用类似桶排序的思想，对所有的数进行计数。

1. 从左扫描到右边，遇到一个数字，先找到对应的bucket.比如

3 2 2 1 4

第一个3对应的bucket是index = 2 (bucket从0开始计算）

2. Bucket 如果有数字，则把这个数字移动到i的position(就是存放起来），然后把bucket记为-1(表示该位置是一个计数器，计1）。

3. Bucket 存的是负数，表示这个bucket已经是计数器，直接减1. 并把color[i] 设置为0 （表示此处已经计算过）

4. Bucket 存的是0，与3一样处理，将bucket设置为-1， 并把color[i] 设置为0 （表示此处已经计算过）

5. 回到position i，再判断此处是否为0（只要不是为0，就一直重复2-4的步骤）。

6.完成1-5的步骤后，从尾部到头部将数组置结果。（从尾至头是为了避免开头的计数器被覆盖）

例子(按以上步骤运算)：

3 2 2 1 4

2 2 -1 1 4

2 -1 -1 1 4

0 -2 -1 1 4

-1 -2 -1 0 4

-1 -2 -1 -1 0

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
