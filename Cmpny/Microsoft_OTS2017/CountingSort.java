package MS.OA2017;



/**
 * Created by wtnwi on 1/13/2017.
 */
public class CountingSort {
    public static void main(String[] argv) {
        int[] A = CountingSort.countingSort(new int[]{16, 4, 10, 14, 7, 9, 3, 2, 8, 1});
        //排序的数组
        int a[] = {100, 93, 97, 92, 96, 99, 92, 89, 93, 97, 90, 94, 92, 95};
        int b[] = countSort(a);for(int i : b){System.out.print(i + "  ");}
    }
    public static int[] countingSort(int[] A) {
        int[] B = new int[A.length];int k = 100;int[] C = new int[k];// 假设A中的数据a'有，0<=a' && a' < k并且k=100
        for (int j = 0; j < A.length; j++) {int a = A[j];C[a] += 1;}// 计数
        for (int i = 1; i < k; i++) {C[i] = C[i] + C[i - 1];} // 求计数和
        for (int j = A.length - 1; j >= 0; j--) {int a = A[j];B[C[a] - 1] = a;C[a] -= 1;}// 整理
        return B;
    }

    public static int[] countSort(int []a){
        int b[] = new int[a.length];
        int max = a[0], min = a[0];
        for(int i : a){if(i > max){max = i;}if(i < min){min = i;}}
        //这里k的大小是要排序的数组中，元素大小的极值差+1
        int k = max - min + 1;int c[] = new int[k];
        for(int i = 0; i < a.length; ++i){c[a[i]-min] += 1;}//优化过的地方，减小了数组c的大小
        for(int i = 1; i < c.length; ++i){c[i] = c[i] + c[i-1];}// 求计数和
        for(int i = a.length-1; i >= 0; --i){b[--c[a[i]-min]] = a[i];}//按存取的方式取出c的元素
        return b;
    }
}

