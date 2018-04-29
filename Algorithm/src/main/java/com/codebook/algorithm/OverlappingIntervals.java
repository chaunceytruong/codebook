package com.codebook.algorithm;

import java.util.*;

/**
 * OverlappingIntervals contains the logic to merge overlapping intervals.
 */
public class OverlappingIntervals {

    // ================================================================================
    // Public Methods
    // ================================================================================

    /**
     * Given a collection of intervals, merge all overlapping intervals.
     *
     * For example,
     * Given [1,3],[2,6],[8,10],[15,18],
     * return [1,6],[8,10],[15,18].
     *
     * @param intervals to merge.
     * @return merged intervals.
     */
    public List<Interval> merge(List<Interval> intervals) {
        // First, we sort the list.
        intervals.sort(new IntervalComparator());

        LinkedList<Interval> merged = new LinkedList<>();
        for (Interval interval : intervals) {
            // if the list of merged intervals is empty or if the current scheduling does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast().end < interval.start) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous intervals.
            else {
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }

        return merged;
    }
    // ================================================================================
    // Inner Classes
    // ================================================================================

    class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            if (a.start < b.start) {
                return -1;
            } else if (a.start > b.start) {
                return 1;
            } else {
                return Integer.compare(a.end, b.end);
            }
        }
    }
}
