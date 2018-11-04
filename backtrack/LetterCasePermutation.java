import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public List<String> letterCasePermutation(String S) {
        List<String> returnList = new ArrayList<>();
        backtrack(returnList, S.toCharArray(), 0);
        return returnList;
    }
    
    private void backtrack(List<String> returnList, char[] chars, int index) {
        if (index == chars.length) {
            returnList.add(new String(chars));
            System.out.println(new String(chars));
            return;
        }
        if (Character.isLetter(chars[index])) {
            chars[index] = Character.toLowerCase(chars[index]);
            backtrack(returnList, chars, index+1);
            chars[index] = Character.toUpperCase(chars[index]);
        }
        backtrack(returnList, chars, index+1);
    }
    
    public static void main(String[] args) {
        String test = "a1b2";
        new LetterCasePermutation().letterCasePermutation(test);
    }
}