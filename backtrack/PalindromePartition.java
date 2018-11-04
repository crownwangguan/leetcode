import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePartition {
    public List<List<String>> partition(String s) {
        List<List<String>> returnList = new ArrayList<>();
        backtrack(returnList, new ArrayList<>(), s);
        return returnList;
    }
    
    private void backtrack(List<List<String>> returnList, List<String> tempList, String s) {
        if(s==null || s.length() == 0) {
            returnList.add(new ArrayList<>(tempList));
            return;
        }
        for(int i = 1; i <= s.length(); i++) {
            String temp = s.substring(0, i);
            if(!isPalindrome(temp)) {
                continue;
            }
            tempList.add(temp);
            backtrack(returnList, tempList, s.substring(i, s.length()));
            tempList.remove(tempList.size() - 1);
        }
    }
    
    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while(left <= right) {
            if(s.charAt(left) != s.charAt(right))
                return false;
            left ++;
            right --;
        }
        return true;
    }

    public static void main(String[] args) {
        new PalindromePartition().partition("aab");
    }
}