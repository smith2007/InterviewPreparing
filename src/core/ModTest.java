package core;

public class ModTest {

    public static void main(String[] args) {
        System.out.println("3%2 = " + 3 % 2); // я думал 5 - оказалось - 1

        System.out.println("5%3 = " + 5 % 3); // я думал 7 - оказалось - 2

        System.out.println("1%2 = " + 1 % 2); // я думал 5 - оказалось - 1

        System.out.println("5%2 = " + 5 % 2); // оказалось - 1

        System.out.println("9%4 = " + 9 % 4); // оказалось - 1

        System.out.println("5%1 = " + 5 % 1); // тут логично - делится без остатка - 0


        System.out.println("1%1 = " + 1 % 1); // тут логично - делится без остатка - 0


        System.out.println("2%1 = " + 2 % 1); // делится без остатка - 0


        System.out.println(99 % 96);

    }
}
