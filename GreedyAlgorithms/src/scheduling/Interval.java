package scheduling;

public class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "scheduling.Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
