import java.util.List;
import java.util.ArrayList;

public class Permutation {
    public static void main(String[] args) {
        int[] source_array = new int[]{1, 2, 3};
        Permutation testObjectPermutation = new Permutation();
        System.out.println(testObjectPermutation.permute(source_array));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        if(tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for(int i = 0; i < nums.length; i++) {
                if(tempList.contains(nums[i])) {
                    continue;
                }
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}