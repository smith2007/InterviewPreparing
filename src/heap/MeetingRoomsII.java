package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII {

    public static void main(String[] args) {
        // int[][] arr = {{0, 30}, {5, 10}, {15, 20}};
        // int[][] arr = {{7, 10}, {2, 4}};

        int[][] arr = {{13, 15}, {1, 13}, {6, 9}};
        System.out.println(minMeetingRooms(arr));
    }

    static int minMeetingRooms(int[][] arr) {
        if (arr.length == 0 || arr[0].length == 0) {
            return 0;
        }

        // дано расписания нужно понять сколько нам переговорок надо
        // как понять сколько переговорок надо?
        // надо понять какие доклады в каких переговорках сейчас идут
        // и при наступлении следующего доклада - смотреть, а идет ли сейчас доклад?
        // если идет - взять новую

        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));

        PriorityQueue<Event> meetingRooms = new PriorityQueue<>(Comparator.comparingInt(e -> e.end));

        int currCount = 0;

        for (int[] ints : arr) {
            Event event = new Event(ints[0], ints[1]);

            while (!meetingRooms.isEmpty() && meetingRooms.peek().end <= event.start) {
                meetingRooms.poll();
            }
            if (currCount == meetingRooms.size()){
                currCount++;
            }
            meetingRooms.add(event);
        }
        return currCount;
    }

    static class Event {
        int start;
        int end;

        public Event(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}
