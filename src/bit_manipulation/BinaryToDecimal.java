package bit_manipulation;

public class BinaryToDecimal {

    public static void main(String[] args) {
        System.out.println(binaryToDecimalString("101"));
    }

    static int binaryToDecimalInt(int[] binary) {
        // инициализируем базовый элемент единицей
        // потому что 1 это два в нулевой
        int base = 1;
        int decimalValue = 0;

        for (int i = binary.length - 1; i >= 0; i--) {
            if (binary[i] == 1) {
                decimalValue += base;
            }
            base = base * 2;
        }
        return decimalValue;
    }

    static int binaryToDecimalString(String binary) {

        // инициализируем степень единицей
        // потому что 1 это два в нулевой 2^0
        int base = 1;
        int decimalValue = 0;

        char[] chars = binary.toCharArray();

        //дальше идем с конца!!!
        for (int i = chars.length - 1; i >= 0; i--) {
            //и если наш бит равен единице мы производим прибавление
            if (chars[i] == '1') {
                decimalValue += base;
            }
            base = base * 2;
        }
        return decimalValue;
    }
}
