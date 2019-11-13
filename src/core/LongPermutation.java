package core;

public class LongPermutation {


    public static void main(String[] args) {
        Long num = 54321L;
                 //54312
        System.out.println(permute(num));
    }



    /*
     * Sysdig Java Interview:
     * Given a Long number N, write a function that calculates the highest number lower
     * than N obtained by permute only one digit of N.
     *
     * If no permutation exists to return a lower value, return N.
     * Example:
     * N = 153
     * permuteToPrevious(N) = 135

        // то есть надо расчитать наибольшее число, которое МЕНЬШЕ чем изначальное число
        // при этом сделать только одну перестановку

//иными словами надо найти такое число, такой символ
//который был бы больше чем последний
//например последний 2 надо отталкиватся от него

92145112 вот наше оригинальное чило, как его можно представить
92145121 - НЕ корректно 1<2
а какие варианты корректные?

ну например такие
92142115
92125114
22145119

ну по идее можно свапать все подряд
и если меньше обновлять какой либо минимум



     *                    N = 92145112
     * permuteToPrevious(N) = 92142115
     *
     * Please note:
     * Use Long as type. Digits can repeat
     */

    static Long permute(Long num) {
        if (num == null || num < 10) {
            return num;
        }

        String str = num.toString();
        int lastIndex = str.length() - 1;

        Long result = num;
        for (int j = lastIndex; j >= 0; j--) {

            for (int i = j - 1; i >= 0; i--) {
                char[] chars = str.toCharArray();

                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;

                long currNum = Long.parseLong(String.valueOf(chars));
                if (currNum < num) {
                    if (result.equals(num)) {
                        result = currNum;
                    } else if (currNum > result) {
                        result = currNum;
                    }
                }

            }
        }


        return result;
    }
}
