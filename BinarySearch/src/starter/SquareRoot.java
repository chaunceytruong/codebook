package starter;

public class SquareRoot {

    /**
     * Calculate the square root of the specified number.
     *
     * @param x positive number
     * @return square root of the number.
     */
    public int sqrt(int x) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        SquareRoot squareRoot = new SquareRoot();
        try {
            squareRoot.sqrt(-1); // throws IllegalArgumentException
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(squareRoot.sqrt(0)); // 0
        System.out.println(squareRoot.sqrt(1)); // 1
        System.out.println(squareRoot.sqrt(49)); // 7
        System.out.println(squareRoot.sqrt(50)); // 7
        System.out.println(squareRoot.sqrt(999999999)); // 31622
    }
}
