package scheduling;

import java.util.*;

public class IntervalPartitioning {

    public static void main(String[] args) {
        List<Interval> classes = Arrays.asList(
                new Interval(10, 11),
                new Interval(10, 12),
                new Interval(10, 13),
                new Interval(11, 13),
                new Interval(12, 14),
                new Interval(13, 15),
                new Interval(13, 16),
                new Interval(15, 17),
                new Interval(15, 17)
        );
        System.out.println(String.format("minNumOfClassroomsNeeded: %s", minNumOfClassroomsNeeded(classes)));
    }

    static int minNumOfClassroomsNeeded(List<Interval> classes) {
        Queue<ClassRoom> classRooms= new PriorityQueue<>(classes.size(), Comparator.comparingInt(cls -> cls.finishTimeLastLecture));
        for (Interval cls : classes) {
            if (classRooms.isEmpty() || classRooms.peek().finishTimeLastLecture > cls.start) {
                ClassRoom newClassRoom = new ClassRoom();
                newClassRoom.finishTimeLastLecture = cls.end;
                classRooms.offer(newClassRoom);
            } else {
                ClassRoom compatibleClassroom = classRooms.poll();
                if (compatibleClassroom != null) {
                    compatibleClassroom.finishTimeLastLecture = cls.end;
                    classRooms.offer(compatibleClassroom);
                }
            }
        }
        return classRooms.size();
    }
}
