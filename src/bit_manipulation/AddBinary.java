package bit_manipulation;

public class AddBinary {



    public static void main(String[] args) {

        System.out.println(addBinary("1111", "1111"));
    }
    private static final char ONE = '1';
    private static final char ZERO = '0';
    /**
     * как происходит сложение в бинарном мире
     * - мы идем с конца и складываем биты по логике: 0+1=1, 1+0=1, 0+0=0, 1+1=11
     * соответсвенно суть алгоритма следующая
     * - идем по разрядно, складываем биты,
     * кладем в результирующий stringBuilder, паралельно фиксируя carry (остаток)
     *
     * выглядит это очень просто - у нас есть два числа «11101»
     * и например «1101» они могут быть разной длинны,
     * соотв в нашем глобальном цикле нам надо крутится складывая все разряды,
     * если у одного из чисел разряды закончились - принимаем его разряд за 0
     * char aChar = i >= 0 ? a.charAt(i) : ZERO;
     * char bChar = j >= 0 ? b.charAt(j) : ZERO;
     *
     * ну и в цикле делаем поправку на остаток, если остаток есть,
     * то есть он 1, то складываем еще и с остатком, обновляя его
     */
    static String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;

        //остаток будем фиксировать через остаток
        boolean carry = false;

        StringBuilder collector = new StringBuilder();

        //крутимся в цикле до тех пор пока у мы не дошли до
        //конца каждого из чисел, либо у нас есть остаток
        while (i >= 0 || j >= 0 || carry) {

            char aChar = i >= 0 ? a.charAt(i) : ZERO;
            char bChar = j >= 0 ? b.charAt(j) : ZERO;

            if (aChar == ONE && bChar == ONE) {
                if (carry) {
                    collector.insert(0, ONE);
                } else {
                    collector.insert(0, ZERO);
                }
                carry = true;
            } else if (aChar == ONE || bChar == ONE) {
                if (carry) {
                    collector.insert(0, ZERO);
                    carry = true;
                } else {
                    collector.insert(0, ONE);
                }
            } else {
                if (carry) {
                    collector.insert(0, ONE);
                    carry = false;
                } else {
                    collector.insert(0, ZERO);
                }
            }
            i--;
            j--;
        }
        return collector.toString();
    }
}
