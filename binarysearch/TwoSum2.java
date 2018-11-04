public class TwoSum2 {
    public int[] twoSum2(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        int sum;
        
        while(i < j) {
            sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i+1, j+1};
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 7, 11, 15};
        System.out.println(new TwoSum2().twoSum2(nums1, 9));
    }
}