import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class CombinationSum {

    public static void main(String[] args) {
        new CombinationSum().combinationSum(new int[] {2,3,6,7}, 7);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> returnList = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(returnList, new ArrayList<Integer>(), candidates, target, 0);
        return returnList;
    }

    public void backtrack(List<List<Integer>> returnList, List<Integer> tempList, int[] candidates, int target, int start) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            System.out.println(tempList);
            returnList.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            tempList.add(candidates[i]);
            backtrack(returnList, tempList, candidates, target - candidates[i], i);
            tempList.remove(tempList.size() - 1);
        }
    }
}