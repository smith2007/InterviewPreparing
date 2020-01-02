package string;

public class MultiplyStrings {

    public static void main(String[] args) {

        System.out.println(multiply("123", "456"));
    }

    /**
     *
     дано две строки, в них только числа - необходимо перемножить их и вернуть результат, при этом конвертировать в интеджер напрямую
     очень интересный алгоритм и одновременно сложный для меня - суть сводится к умножению в столбик - но интересному умножению

     для записи столбика мы будем использовать одномерный массив

     суть как и в умножении в столбик это идти с конца первого числа и умножать на каждую цифру на цифру фиксируя остаток
     для фиксации этого мы вводим массив int[] collector = new int[num1.length() + num2.length()]; - будем накидывать туда данные с конца
     ну и раскручиваем два цикла по i и j - внутри делаем ряд шагов
     шаг первый умножение цифру на цифру - 3*5=15 например
     шаг второй фиксируем индекс куда будем класть остаток int ostatokIndex = i + j + 1;
     шаг третий фиксируем как бы финальную сумму которая скл из произведения с прибавлением с тем что там уже когда-то от предыдущего шага лежало int sum = mult + collector[ostatokIndex];

     далее кладем этот наш суммированный остаток в массив

     шаг четвертый - сначала остаток collector[ostatokIndex] = sum % 10;

     шаг пятый -  десятые части, но уже на один индекс ближе

     int desyatieIndex = i + j;
     collector[desyatieIndex] = collector[desyatieIndex] + sum / 10;

     все, весь алгоритм
     в конце бежим и набиваем стринг билдер
     */
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


                //сам остаток в дальний
                int ostatokIndex = i + j + 1;
                int sum = mult + collector[ostatokIndex];
                collector[ostatokIndex] = sum % 10;

                //десятые части по дефолту записывается в ближний разряд
                //при этом там уже что-то может быть и так
                int desyatieIndex = i + j;
                collector[desyatieIndex] = collector[desyatieIndex] + sum / 10;

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
