import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Subset {
    public static void main(String[] args) {
        int[] testCase = new int[] { 1, 2, 3 };
        new Subset().subsets(testCase);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> returnList = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(returnList, new ArrayList<>(), nums, 0);
        return returnList;
    }

    private void backtrack(List<List<Integer>> returnList, List<Integer> tempList, int[] nums, int start) {
        System.out.println(tempList);
        returnList.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(returnList, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}