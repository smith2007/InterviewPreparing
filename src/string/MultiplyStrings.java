package string;

public class MultiplyStrings {

    public static void main(String[] args) {

        System.out.println(multiply("123", "456"));
    }

    static String multiply(String num1, String num2) {

        if (num1 == null || num2 == null) {
            return "";
        }

        //для результата нам нужен промежуточный массив коллектор
        //этот массив коллектор может быть максимальной длинны из суммы разрядов
        //обоих массивов
        int[] collector = new int[num1.length() + num2.length()];

        //принцип - умножение в столбик
        for (int i = num1.length() - 1; i >= 0; i--) {

            for (int j = num2.length() - 1; j >= 0; j--) {
                //идея вот в чем - мы сохраняем наш как бы остаток в сам промежуточный массив коллектор
                //первый шаг - умножаем наши числа из двух строк
                int mult = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');


                //само велью в ближний
                int valuePosition = i + j + 1;
                int valueSum = mult + collector[valuePosition];
                collector[valuePosition] = valueSum % 10;

                //остаток по дефолту записывается в ближний разряд
                //при этом там уже что-то может быть и так
                int carryPosition = i + j;
                collector[carryPosition] = collector[carryPosition] + valueSum / 10;

            }
        }

        StringBuilder strb = new StringBuilder();
        int x = 0;
        for (; x < collector.length; x++) {
            if (collector[x] > 0)
                break;
        }
        for (; x < collector.length; x++) {
            strb.append(collector[x]);
        }
        if (strb.toString().equals("")) {
            return "0";
        }
        return strb.toString();
    }
}
