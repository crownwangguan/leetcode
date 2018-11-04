import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Subset2 {
    public static void main(String[] args) {
        int[] testCase = new int[] { 1, 2, 2 };
        new Subset2().subsetsDup(testCase);
    }

    public List<List<Integer>> subsetsDup(int[] nums) {
        List<List<Integer>> returnList = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return returnList;
        }
        Arrays.sort(nums);
        backtrack(returnList, new ArrayList<>(), nums, 0);
        return returnList;
    }

    private void backtrack(List<List<Integer>> returnList, List<Integer> tempList, int[] nums, int start) {
        System.out.println(tempList);
        returnList.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            tempList.add(nums[i]);
            backtrack(returnList, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}