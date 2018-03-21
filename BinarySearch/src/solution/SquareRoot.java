package solution;

public class SquareRoot {

    /**
     * Calculate the square root of the specified number.
     *
     * @param x positive number
     * @return square root of the number.
     */
    public int sqrt(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("No negatives!");
        }
        if (x == 0) {
            return 0;
        }
        int low = 1;
        int high = x;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid == x / mid) {
                return mid;
            } else if (mid > x / mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        SquareRoot squareRoot = new SquareRoot();
        System.out.println(squareRoot.sqrt(50)); // 7
        System.out.println(squareRoot.sqrt(999999999)); // 500000000
    }
}
