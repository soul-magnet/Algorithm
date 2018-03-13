package MS.Onsite2017;

/**Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

 Have you met this question in a real interview? Yes
 Example
 Given a matrix

 [
 [1,2],
 [0,3]
 ],
 return
 [
 [0,2],
 [0,0]
 ]
 Tags
 Cracking The Coding Interview Matrix
 * Created by K25553 on 9/20/2016.
 * [解题思路]
 非常无聊的一道题。解题点就在于清空标志位存在哪里的问题。可以创建O(m+n)的数组来存储，但此题是希望复用已有资源。这里可以选择第一行和第一列来存储标志位。

 1.先确定第一行和第一列是否需要清零
 2.扫描剩下的矩阵元素，如果遇到了0，就将对应的第一行和第一列上的元素赋值为0
 3.根据第一行和第一列的信息，已经可以讲剩下的矩阵元素赋值为结果所需的值了
 4.根据1中确定的状态，处理第一行和第一列。
 http://fisherlei.blogspot.com/2013/01/leetcode-set-matrix-zeroes.html
 */
public class SetMatrixZeroes {

    /**
     * @param matrix: A list of lists of integers
     * @return: Void
     */
    public void setZeroes1(int[][] matrix) {
        if(matrix==null||matrix.length==0){
            return;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean empty_row0 = false;
        boolean empty_col0 = false;
        //firtly store 0 info for fist row and col
        for(int i = 0; i < cols; i++){
            if(matrix[0][i] == 0){
                empty_row0 = true;
                break;
            }
        }

        for(int i = 0; i < rows; i++){
            if(matrix[i][0] == 0){
                empty_col0 = true;
                break;
            }
        }
        //update matrix[0][j] = 0; matrix[i][0] = 0; if matrix[0][j] = 0; therefore [i][0] and [0][i] store all 0 info for all rows and columns to be cleared
        for(int i = 1; i < rows; i++) {
            for(int j =1; j<cols; j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        //clear rows and column if  matrix[0][j] == 0 || matrix[i][0] == 0
        for(int i = 1; i<rows; i++) {
            for (int j=1; j< cols; j++) {
                if(matrix[0][j] == 0 || matrix[i][0] == 0)
                    matrix[i][j] = 0;
            }
        }
        //cleat the first row and col if  matrix[0][0] = 0;
        if(empty_row0){
            for(int i = 0; i < cols; i++){
                matrix[0][i] = 0;
            }
        }

        if(empty_col0){
            for(int i = 0; i < rows; i++){
                matrix[i][0] = 0;
            }
        }


    }
}

