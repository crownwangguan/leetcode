import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> returnList = new ArrayList<>();
        backtrack(returnList, new ArrayList<>(), 0, new boolean[n], new boolean[2*n], new boolean[2*n], n);
        return returnList;
    }
    
    private void backtrack(List<List<String>> returnList, List<String> board, int row, boolean[] cols, boolean[] d1, boolean[] d2, int n){
        if (row == n) {
            System.out.println(board);
            returnList.add(new ArrayList<String>(board));
        }
        for (int col = 0; col < n; col++) {
            int dir1 = col - row + n;
            int dir2 = col + row;
            if (!cols[col] && !d1[dir1] && !d2[dir2]) {
                char[] r = new char[n];
                Arrays.fill(r, '.');
                r[col] = 'Q';
                board.add(new String(r));
                cols[col] = true;
                d1[dir1] = true;
                d2[dir2] =true;
                backtrack(returnList, board, row + 1, cols, d1, d2, n);
                board.remove(board.size()-1);
                cols[col] = false;
                d1[dir1] = false;
                d2[dir2] =false;
            }
        }
    }

    public static void main(String[] args) {
        new NQueens().solveNQueens(4);
    }
}