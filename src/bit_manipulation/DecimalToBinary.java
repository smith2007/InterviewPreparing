package bit_manipulation;

public class DecimalToBinary {


    public static void main(String[] args) {

    }

    static void decToBinary(int n) {
        // формируем массив из наших разрядов
        int[] binaryNum = new int[32];

        int i = 0;
        while (n > 0) {
            // шаг первый это делим через mod
            //остаток от деления и будет наш бит
            binaryNum[i] = n % 2;
            //шаг второй делим наш n пополам для сл итерации
            n = n / 2;
            i++;
        }
        // самый важный момент - биты читаются с конца!!!
        for (int j = i - 1; j >= 0; j--) {
            System.out.print(binaryNum[j]);
        }
    }


}
