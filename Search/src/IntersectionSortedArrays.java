import java.util.ArrayList;
import java.util.List;

public class IntersectionSortedArrays {

    public static void main(String[] args) {
        int[] arr1 = new int[] { 1, 2, 3};
        int[] arr2 = new int[] { 2, 3, 4};
        int[] arr3 = new int[] { 3, 4, 5};
        System.out.println("findIntersection: " + findIntersection(arr1, arr2, arr3));
    }

    public static List<Integer> findIntersection(int[] x, int[] y, int[] z) {
        List<Integer> result = new ArrayList<>();

        int xPtr = 0;
        int yPtr = 0;
        int zPtr = 0;
        while (xPtr < z.length && yPtr < y.length && zPtr < z.length) {
            if (x[xPtr] == y[yPtr] && x[xPtr] == z[zPtr]) {
                result.add(x[xPtr]);
                xPtr++;
                yPtr++;
                zPtr++;
            } else if (x[xPtr] < y[yPtr]) {
                xPtr++;
            } else if (y[yPtr] < z[zPtr]) {
                yPtr++;
            } else {
                zPtr++;
            }
        }

        return result;
    }
}
