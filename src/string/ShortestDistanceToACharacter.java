package string;

import java.util.Arrays;

public class ShortestDistanceToACharacter {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(shortestToChar("loveleetcode", 'e')));
    }

    /**
     * дана строка и символ - необходимо набить массив интов -
     * где каждое число - это самое коротое расстояние от
     * нашего символа ch до этого конкретного символа
     *
     * Input: S = "loveleetcode", C = 'e'
     * Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
     *
     * в тупую надо брать каждый символ и разбегаться в две стороны - затем брав минимум
     *
     * более умный подход заключается в том что бы пройтись по массиву два раза,
     * первый раз слева направа, второй раз справа налево
     *
     * во время первого прохода мы будем фиксировать каждый последний встретившийся
     * нужный нам символ и фиксировать его позицию, а если это символ не тот котрый
     * нам нужен - то фиксируем его как-бы минимальную позицию за этот проход как фиксировать??
     *
     * ну мы идем слева направо наш последний встретившийся индекс - prevPosition а наш текущий - i
     *
     * i бежит вперед соотв надо от него отнимать prevPosition
     *
     * за первый проход набили как бы минимумы слева направа, теперь второй проход С КОНЦА В НАЧАЛО
     *
     * так же фиксируем prevPosition а i теперь уже будет бежать назад соотв теперь для того
     * что бы определить минимальное растояние нам надо зафиксировать наоборот min = prevPostion -
     * i НО теперь еще берем МИНИМУМ из того что бы ло за первый проход и то что сейчас Math.min
     *
     * все весь алгоритм
     */
    static int[] shortestToChar(String str, char ch) {

        int[] res = new int[str.length()];
        int prevPositionOfCh = Integer.MIN_VALUE / 2; // обязательно инициализируем как минимумом

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            if (curr == ch){
                prevPositionOfCh = i;
            }
            res[i] = i - prevPositionOfCh;
        }

        prevPositionOfCh = Integer.MAX_VALUE / 2; // обязательно как максимумом
        for (int i = str.length() - 1; i >= 0; i--) { //бежим в конец
            char curr = str.charAt(i);
            if (curr == ch){
                prevPositionOfCh = i;
            }
            res[i] = Math.min(res[i], prevPositionOfCh - i); //берем минимум
        }

        return res;
    }
}
