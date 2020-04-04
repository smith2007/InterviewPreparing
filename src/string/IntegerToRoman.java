package string;

public class IntegerToRoman {

    public static void main(String[] args) {
        System.out.println(intToRoman(99));
    }

    static String intToRoman(int num) {
        int[] values =     {1000, 900,  500, 400,  100,  90,  50,   40,   10,   9,   5,   4,    1};
        String[] symbols = {"M",  "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        //правило такое - бегаем по массиву значений римских чисел слева на право, от большого к маленькому
        //1000->900->500->400->
        //цель - найти ближайшее число которое меньше нашего
        //наше число на входе будет мутейтися, из него будут вычитаться заиспользованное римское число
        //каждый раз когда мы найдем ближайшее к нему (нашему числу на входе)
        //символ, мы будем его эквивалент вычитать
        //и набивать строку c начала, если в задаче roman to integer мы бежали с конца наполняли строку
        //то тут с начала
        StringBuilder res = new StringBuilder();
        int i = 0;
        while (i < symbols.length) {
            if (values[i] <= num) {
                //если добежали до такого эквивалента, который наконец меньше
                //вычитаем
                num -= values[i];
                res.append(symbols[i]);
            } else {
                i++;
            }
        }
        return res.toString();
    }


}
