package MS.OA2017;

import java.util.Arrays;

/**Flip the array matrix on the diaginal axis
 * that goes from the top left of the matrix to the botton right.
 * You may represent the matrix as a two dimentional array or equivalent data structure;
 * Created by wtnwi on 1/13/2017.
 */
public class FlipMatrixOntheDiagnal {
    static int [][] flipMatrix (int [][] a){
        if(a==null||a.length==0){
            return a;
        }
        int i= 0, j= a[0].length-1;
        while(i<a.length&&j>-1){
            int j1 = j-1, i1=i+1;
            while(i1<a.length&&j1>-1){
                int temp= a[i][j1];
                a[i][j1]=a[i1][j];
                a[i1][j] = temp;
                i1++;j1--;
            }
            i++;j--;
        }
        return a;
    }

    public static void main(String [] args){
        int a [][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        for(int [] now :flipMatrix(a)){
            System.out.println(Arrays.toString(now));
        }
    }
}
