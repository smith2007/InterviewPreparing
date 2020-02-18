package bit_manipulation;

public class AddBinary {

    private static final char ONE = '1';
    private static final char ZERO = '0';

    public static void main(String[] args) {

        System.out.println(addBinary("1111", "1111"));
    }

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
