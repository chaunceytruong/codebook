package scheduling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class IntervalScheduling {

    public static void main(String[] args) {
        List<Interval> intervals = Arrays.asList(new Interval(1, 3), new Interval(2, 4), new Interval(1, 2));
        System.out.println(getOptimalSchedule(intervals));
    }

    static List<Interval> getOptimalSchedule(List<Interval> allIntervals) {
        List<Interval> result = new ArrayList<>();

        // Sort intervals by earliest finish time
        allIntervals.sort(Comparator.comparing(interval -> interval.end));

        // Check each scheduling if compatible with selected jobs
        for (Interval i : allIntervals) {
            if (result.isEmpty()) {
                result.add(i);
            } else {
                if (i.start >= result.get(result.size() - 1).end) {
                    result.add(i);
                }
            }
        }

        return result;
    }
}
