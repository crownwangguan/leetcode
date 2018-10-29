import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class CombinationSum {

    public static void main(String[] args) {
        new CombinationSum().combinationSum(new int[] {2,3,6,7}, 7);
        new CombinationSum().combinationSum2(new int[] {10, 1, 2, 7, 6, 1, 5}, 8);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> returnList = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(returnList, new ArrayList<Integer>(), candidates, target, 0);
        return returnList;
    }

    private void backtrack(List<List<Integer>> returnList, List<Integer> tempList, int[] candidates, int target, int start) {
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

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> returnList = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack2(returnList, new ArrayList<Integer>(), candidates, target, 0);
        return returnList;
    }
    
    private void backtrack2(List<List<Integer>> returnList, List<Integer> tempList, int[] candidates, int target, int index) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            System.out.println(tempList);
            returnList.add(new ArrayList<>(tempList));
            return;
        }
        for ( int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i-1] ) {
                continue;
            }
            tempList.add(candidates[i]);
            backtrack2(returnList, tempList, candidates, target-candidates[i], i+1);
            tempList.remove(tempList.size()-1);
        }
    }
}