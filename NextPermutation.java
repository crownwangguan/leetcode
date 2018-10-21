import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NextPermutation {

    private void swap(int[] nums, int currPointer, int biggerPointer) {
        int tmp = nums[currPointer];
        nums[currPointer] = nums[biggerPointer];
        nums[biggerPointer] = tmp;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int currPointer = nums.length - 2;
        while (currPointer >= 0 && nums[currPointer] >= nums[currPointer + 1]) {
            currPointer--;
        }
        if (currPointer >= 0) {
            int rightMostBiggerPointer = nums.length - 1;
            while (nums[rightMostBiggerPointer] <= nums[currPointer]) {
                rightMostBiggerPointer--;
            }
            swap(nums, currPointer, rightMostBiggerPointer);
        }
        reverse(nums, currPointer + 1, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] testCase = new int[]{1, 2, 3, 4, 5};
        new NextPermutation().nextPermutation(testCase);
        for (int i : testCase) {
            System.out.println(i);
        }
    }
}