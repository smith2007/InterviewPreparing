package array;

import java.util.stream.IntStream;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};

        int[] product = getProduct(arr);
        IntStream.of(product).forEach(System.out::println);
    }

    static int[] getProduct(int[] arr) {

        //если пользоватся операцией деления нельзя
        //то без доп памяти тут никак
        int[] phantom = new int[arr.length];


        // тут фокус заключается в том что,
        // надо набить фантомный массив который всегда начинается с 1
        // далее надо использовать этот массив для того что бы перемножать
        // с темповым элементом который получается произведением с предыдущего шага

        //ОСНОВНАЯ ИДЕЯ - как получит то что нам надо??
        // а именно произведение всех на все кроме итого
        //пройти слева направо получить произведения каждого шага
        //пройти справа направо получит произведения каждого шага

        //для вычисления конечного значения перемножить значения из этих двух проходов
        phantom[0] = 1;

        //в первом цикле
        //крутимся и набиваем массив
        for (int i = 1; i < phantom.length; i++) {
            phantom[i] = phantom[i - 1] * arr[i - 1];
        }

        int temp = 1;

        //далее идем с конца, и перемножаем на
        for (int i = arr.length - 1; i >= 0; i--) {
            phantom[i] = phantom[i] * temp;
            temp = temp * arr[i];
        }

        return phantom;
    }
}
