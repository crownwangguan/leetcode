public class MinimumRotateArray {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            if (nums[left] < nums[right]) {
                break;
            }
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }

    public int findMin2(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid]<nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right--;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int[] nums2 = new int[]{2,2,2,0,1};
        System.out.println(new MinimumRotateArray().findMin(nums));
        System.out.println(new MinimumRotateArray().findMin2(nums2));
    }
}