package sorting;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {

    public static void main(String[] args) {

        int[][] arr = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(canAttendMeetings(arr));
    }

    static boolean canAttendMeetings(int[][] arr) {

        if (arr.length == 0 || arr[0].length == 0) {
            return false;
        }

        //как понять сможешь ли ты посетить все митинги?
        //надо понять есть ли пересекающиеся интервалы
        //если все интервалы не пересекаются значит все окей

        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));

        for (int i = 1; i < arr.length; i++) {
            if (arr[i][0] < arr[i - 1][1]) {
                return false;
            }
        }
        return true;
    }
}
