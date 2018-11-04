import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public static void main(String[] args) {
        new Combinations().combine(4, 2);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> returnList = new ArrayList<>();
        backtrack(returnList, new ArrayList<Integer>(), 1, n, k);
        return returnList;
    }
    
    public void backtrack(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
       if(k == 0) {
           System.out.println(comb);
           combs.add(new ArrayList<>(comb));
           return;
       }
        for(int i = start; i <=n; i++) {
            comb.add(i);
            backtrack(combs, comb, i+1, n, k-1);
            comb.remove(comb.size()-1);
        }
    }
}