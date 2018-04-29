package scheduling;

import java.util.ArrayList;
import java.util.List;

public class MinimizeMaximizeLateness {

    List<Interval> getOptimalAssignmentOrder(List<Assignment> assignments) {
        List<Interval> result = new ArrayList<>();

        int time = 0;

        for (Assignment assignment : assignments) {
            Interval i = new Interval(time, time + assignment.timeToComplete);
            result.add(i);
            time += i.end;
        }

        return result;
    }
}
