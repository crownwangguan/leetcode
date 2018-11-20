public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        
        int row_num = matrix.length;
        int col_num = matrix[0].length;
        
        int begin = 0;
        int end = row_num * col_num -  1;
        
        while(begin <= end) {
            int mid = begin + (end - begin) / 2;
            int mid_value = matrix[mid/col_num][mid%col_num];
            
            if(mid_value == target) {
                return true;
            } else if (mid_value < target) {
                begin = mid+1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        int col = matrix[0].length - 1;
        int row = 0;
        while (col >= 0 && row <= matrix.length - 1) {
            if (target == matrix[row][col]) {
                return true;
            } else if (target < matrix[row][col]) {
                col--;
            } else if (target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int matrix[][]={{1,   3,  5,  7},{10, 11, 16, 20},{23, 30, 34, 50}};
        System.out.println(new Search2DMatrix().searchMatrix(matrix, 3));

        int matrix2[][]={{1,   4,  7, 11, 15},{2,   5,  8, 12, 19},{3,   6,  9, 16, 22},{10, 13, 14, 17, 24}};
        System.out.println(new Search2DMatrix().searchMatrix2(matrix2, 5));
    }
} 