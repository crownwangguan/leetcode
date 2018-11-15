import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class IntersectionTwoArray {
    public int[] intersect(int[] num1, int[] num2) {
        if (num1.length == 0 || num2.length == 0) {
            return new int[0];
        }
        Arrays.sort(num1);
        Arrays.sort(num2);
        int p1 = 0;
        int p2 = 0;
        List<Integer> res = new ArrayList<>();
        while(p1 < num1.length && p2 < num2.length) {
            if (num1[p1] == num2[p2]) {
                res.add(num1[p1]);
                p1++;
                p2++;
            } else if (num1[p1] > num2[p2]) {
                p2++;
            } else {
                p1++;
            }
        }
        int[] t = new int[res.size()];
        for(int i=0;i<res.size();i++) {
            t[i]=res.get(i);
        }
        return t;
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1, 2, 2, 1};
        int[] num2 = new int[]{2, 2};
        int[] result = new IntersectionTwoArray().intersect(num1, num2);
        for(int i: result) {
            System.out.println(i);
        }
    }
}