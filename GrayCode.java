import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GrayCode {

    public static void main(String[] args) {
        System.out.println(new GrayCode().grayCode(2));
    }

    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        List<Integer> grayCode = new ArrayList<>();
        int[] a = {0, 1};
        backtrack(result, grayCode, a, n);
        return result;
    }

    private void backtrack(List<Integer> result, List<Integer> grayCode, int[] a, int n) {
        if (grayCode.size() == n) {
            double sum = 0;
            for (int i = 0; i < grayCode.size(); i++) {
                if (grayCode.get(i) == 1) {
                    sum += Math.pow(2, i);
                }
            }
            result.add((int)sum);
            return;
        }
        for (int i = 0 ; i < 2; i++) {
            grayCode.add(a[i]);
            backtrack(result, grayCode, a, n);
            grayCode.remove(grayCode.size() - 1);
        }
    }

    private void swap (int[] a) {
        int temp = a[0];
        a[0] = a[1];
        a[1] = temp;
    }

}