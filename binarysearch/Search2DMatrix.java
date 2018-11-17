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

    public static void main(String[] args) {
        int matrix[][]={{1,   3,  5,  7},{10, 11, 16, 20},{23, 30, 34, 50}};
        System.out.println(new Search2DMatrix().searchMatrix(matrix, 3));
    }
} 