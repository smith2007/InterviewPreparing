package greedy;

public class JumpGameII {

    public static void main(String[] args) {
        int[] arr = {7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3};
        System.out.println(jump(arr));
    }

    /**
     * реализация очень простая мы крутимся в цикле
     * и фиксируем три переменных первая кол-во прыжков jumps
     * вторая это конец нашего самого дальнего прыжка
     * и третяя длинна нашего самого дальнего прыжка
     *
     * соотв мы как бы бежим вперед на сколько нам позволяет наш первый прыжок
     * и попутно смотрим, так а есть ли более выгодные если есть фиксируем
     *
     * и потом когда упремся в конец нашей границы - делаем прыжок
     * и мы подменим curEnd на curLongest
     *
     * шикарная идея
     *
     */
    static int jump(int[] arr) {
        if (arr.length == 1) {
            return 0;
        }

        // реализация очень простая
        //мы вводим с
        int jumps = 0, curEnd = 0, curLongest = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            curLongest = Math.max(curLongest, i + arr[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curLongest;
            }
        }

        return jumps;
    }
}
