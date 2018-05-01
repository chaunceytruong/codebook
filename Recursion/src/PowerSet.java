import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerSet {

    public static void main(String[] args) {
        System.out.println(getPowerSet(Arrays.asList(1, 5, 10, 15, 20)));
    }

    /**
     * Recursive solution for calculating power set. O(N * 2^N))
     *
     * @param set of numbers
     * @return power set
     */
    private static List<List<Integer>> getPowerSet(List<Integer> set) {
        return getPowerSet(set, 0);
    }

    /**
     * Recursive solution for calculating power set.
     *
     * @param set of numbers
     * @param index current element in subset
     * @return power set
     */
    private static List<List<Integer>> getPowerSet(List<Integer> set, int index) {
        List<List<Integer>> allSubSets;

        // Base Case: n = 0
        if (set.size() == index) {
            allSubSets = new ArrayList<>();
            allSubSets.add(new ArrayList<>());
        } else {
            allSubSets = getPowerSet(set, index + 1);
            int item = set.get(index);
            List<List<Integer>> moreSubSets = new ArrayList<>();
            for (List<Integer> subSet : allSubSets) {
                List<Integer> clone = new ArrayList<>();

                // Clone the previous set
                clone.addAll(subSet);

                // Add the new item to it
                clone.add(item);
                moreSubSets.add(clone);
            }
            allSubSets.addAll(moreSubSets);
        }
        return allSubSets;
    }
}
