package exam;

public class Count {
    // h is a field of heights
    public static int count(int[] h) {
        int count = 0;
        for (int i = 0; i < h.length - 1; i++) {
            if (h[i + 1] > h[i] && (h[i + 1] - h[i] <= 3)) {
                count++;
            }
        }
        return count;
    }
}
