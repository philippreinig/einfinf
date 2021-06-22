package Archive.math;

public class RelationenGenerator {
    public static void main(String[] args) {
        int start = 2;
        int end = 8;
        int step = 2;
        System.out.print("{");
        for (int i = start; i <= end; i += step) {
            for (int j = start; j <= end; j += step) {
                if ((i < end) && (j < end)) {
                    System.out.print("(" + i + "," + j + ")" + ",");
                } else {
                    System.out.print("(" + i + "," + j + ")");
                }
            }
        }
        System.out.print("}");
    }
}