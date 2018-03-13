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
 * [����˼·]
 �ǳ����ĵ�һ���⡣������������ձ�־λ������������⡣���Դ���O(m+n)���������洢����������ϣ������������Դ���������ѡ���һ�к͵�һ�����洢��־λ��

 1.��ȷ����һ�к͵�һ���Ƿ���Ҫ����
 2.ɨ��ʣ�µľ���Ԫ�أ����������0���ͽ���Ӧ�ĵ�һ�к͵�һ���ϵ�Ԫ�ظ�ֵΪ0
 3.���ݵ�һ�к͵�һ�е���Ϣ���Ѿ����Խ�ʣ�µľ���Ԫ�ظ�ֵΪ��������ֵ��
 4.����1��ȷ����״̬�������һ�к͵�һ�С�
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

