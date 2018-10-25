import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {
        int n = 3;
        new GenerateParenthesis().generateParenthesis(n);
    }

    public List<String> generateParenthesis(int n) {
        List<String> returnList = new ArrayList<>();
        backtrack(returnList, "", 0, 0, n);
        return returnList;
    }

    private void backtrack(List<String> returnList, String str, int open, int close, int max) {
        if (str.length() == 2 * max) {
            System.out.println(str);
            returnList.add(str);
            return;
        }
        if (open < max) {
            backtrack(returnList, str + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(returnList, str + ")", open, close + 1, max);
        }
    }
}