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

    public int totalNQueens(int n) {
        boolean[] column = new boolean[n];
        boolean[] dia1 = new boolean[2*n];
        boolean[] dia2 = new boolean[2*n];
        
        int[] count = new int[1];
        backtracking(n, 0, column, dia1, dia2, count);
        return count[0];
    }
    
    public void backtracking(int n, int index, boolean[] col, boolean[] dia1, boolean[] dia2, int[] count) {
        if (n == index) {
            count[0]++;
            return;
        }
        for (int i = 0; i < n; i++) {
            int d1 = index + i;
            int d2 = index - i + n;
            
            if (!col[i] && !dia1[d1] && !dia2[d2]) {
                col[i] = true;
                dia1[d1] = true;
                dia2[d2] = true;
                backtracking(n, index + 1, col, dia1, dia2, count);
                col[i] = false;
                dia1[d1] = false;
                dia2[d2] = false;
            }
        }
    }

    public static void main(String[] args) {
        new NQueens().solveNQueens(4);
        new NQueens().totalNQueens(4);
    }
}