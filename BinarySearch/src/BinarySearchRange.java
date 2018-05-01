import java.util.Arrays;

public class BinarySearchRange {

    public static void main(String[] args) {
        int[] values = new int[] { 5, 7, 7, 8, 8, 10 };
        int target = 8;
        System.out.println(String.format("nums = %s, target = %s", Arrays.toString(values), target));
        System.out.println(Arrays.toString(searchRange(values, target)));
    }

    public static int[] searchRange(int[] values, int target) {
        int[] targetRange = {-1, -1};

        int leftIdx = findInsertionIndex(values, target, true);

        // assert that `leftIdx` is within the array bounds and that `target`
        // is actually in `nums`.
        if (leftIdx == values.length || values[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = findInsertionIndex(values, target, false)-1;

        return targetRange;
    }

    // returns leftmost (or rightmost) index at which `target` should be
    // inserted in sorted array `nums` via binary search.
    private static int findInsertionIndex(int[] values, int target, boolean left) {
        int low = 0;
        int high = values.length;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (values[mid] > target || (left && target == values[mid])) {
                high = mid;
            } else {
                low = mid+1;
            }
        }
        return low;
    }
}
