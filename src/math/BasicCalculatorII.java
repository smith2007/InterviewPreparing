package math;

public class BasicCalculatorII {

    public static void main(String[] args) {
        System.out.println(calculate("5-2*3-4"));

        //System.out.println(calculate("100000000/1/2/3/4/5/6/7/8/9/10"));
    }


    static int calculate(String str) {
        int globalSum = 0;
        int tempSum = 0;
        int num = 0;
        char lastSign = '+';

        for (int i = 0; i < str.length(); i++) {

            char curr = str.charAt(i);

            //если текущий элемент число - то набиваем инт
            //набиваем текущий нам
            if (Character.isDigit(curr)){
                num = num * 10 + curr - '0';
            }

            //если достигли последнего символа или наткнулись на знак выражения то делаем
            //математическую операцию
            if (i == str.length() - 1 || !Character.isDigit(curr) && curr != ' ') {
                //в общем есть у нас глобал самм
                //и локкал сам
                //мы идем идем по строке считаем локальную сумму
                // но скидываем рузультат в глобальную сумму только тогда когда
                //перед нами оперция плюс или минус
                //если же умножение или деление то мы с помощью tempSum набиваем то самое число
                //которое в конце надо добавить когда встретится оперция + или -
                switch (lastSign) {
                    case '+':
                        globalSum += tempSum;
                        tempSum = num;
                        break;
                    case '-':
                        globalSum += tempSum;
                        tempSum = -num;
                        break;
                    case '*':
                        tempSum *= num;
                        break;
                    case '/':
                        tempSum /= num;
                        break;
                }
                //в конце каждой итерации мы обновляем последний знак
                lastSign = curr;
                //и сбрасываем текущий нам
                num = 0;
            }
        }
        globalSum += tempSum;
        return globalSum;
    }

}
