public class BinarySearch {
    public int search(int[] nums, int target) {
        if(nums.length < 1) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target){
                end = mid-1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new BinarySearch().search(new int[]{-1,0,3,5,9,12}, 9));
    }
}