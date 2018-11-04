import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Permutation2 {

    public static void main(String[] args) {
        int[] testList = new int[] { 1, 1, 2 };
        Permutation2 testObjPermutation2 = new Permutation2();
        System.out.println(testObjPermutation2.permuteUnique(testList));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);
        permute(resultList, new ArrayList<>(), nums, new boolean[nums.length]);
        return resultList;
    }

    private void permute(List<List<Integer>> resultList, List<Integer> tempList, int[] nums, boolean[] used) {
        if (tempList.size() == nums.length) {
            resultList.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || ((i > 0 && (nums[i] == nums[i - 1])) && !used[i-1])) {
                    continue;
                }
                used[i] = true;
                tempList.add(nums[i]);
                permute(resultList, tempList, nums, used);
                tempList.remove(tempList.size() - 1);
                used[i] = false;
            }
        }
    }
}