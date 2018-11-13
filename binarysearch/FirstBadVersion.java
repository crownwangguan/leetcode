public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int first = 1;
        int last = n;
        while(first < last) {
            int mid = first + (last - first) / 2;
            if (!isBadVersion(mid)) {
                first = mid + 1;
            } else {
                last = mid;
            }
        }
        return first;
    }
}