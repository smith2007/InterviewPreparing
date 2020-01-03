package dynamic_programming;

public class HouseRobber {

    public static void main(String[] args) {
        int[] arr = {2, 1, 1, 2};

        System.out.println(rob(arr));
    }

    static int rob(int[] arr) {

        int maxIfLastRob = 0; //макс число денег если грабить текущий дом
        int maxIfLastNotRob = 0; //макс число денег если НЕ грабить текущий дом

        for (int i = 0; i < arr.length; i++) {

            //если текущий дом грабить, предыдущий НЕ должен быть ограблен
            int maxIfCurrRob = maxIfLastNotRob + arr[i];

            //если НЕ грабить текущий, то возьми максимум от
            // того что бы грабить предыдущий i-1 дом и НЕ грабить этот предыдущий
            maxIfLastNotRob = Math.max(maxIfLastNotRob, maxIfLastRob);

            //фиксируем для следующей итерации сумму если бы мы грабили текущий дом
            //она нам понадобится потому что мы будем сравнивать и брать это значение
            //как бы для предыдущего
            maxIfLastRob = maxIfCurrRob;
        }
        return Math.max(maxIfLastRob, maxIfLastNotRob);
    }
}
