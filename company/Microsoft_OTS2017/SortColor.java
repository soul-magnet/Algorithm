package MS.OA2017;

/**
 Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 Note:
 You are not suppose to use the library's sort function for this problem.
 Follow up:
 A rather straight forward solution is a two-pass algorithm using counting sort.
 First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

 * Created by wtnwi on 1/13/2017.
 */
public class SortColor {
    public void sortColors1(int[] a) {
        int[] ct = new int [2];
        for(int i: a){
            ct[i]++;
        }
        for(int i= a.length-1; i>-1; i--){
            if(ct[2]>0){
                a[i]=ct[2];ct[2]--;
            }else if(ct[1]>0){
                a[i]=ct[1];ct[1]--;
            }else{
                a[i]=ct[0];ct[0]--;
            }
        }
    }
    public void sortColors(int[] a) {
        if(a == null || a.length <= 1)
            return;
        int l=0, r=a.length-1, mid=0;
        while(mid<=r){
            if(a[mid]==0){swap(a,l,mid);l++;mid++;
            }else  if(a[mid]==1){l++;
            } else{swap(a, r, mid) ;r--;}
        }
    }

    private void swap(int[] a, int l, int mid) {
        int temp = a[l];
        a[l]= a[mid];
        a[mid]=temp;
    }


}
