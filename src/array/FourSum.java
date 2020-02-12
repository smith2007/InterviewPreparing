package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public static void main(String[] args) {
        int[] arr = {1, 0, -1, 0, -2, 2};
        int target = 0;

        System.out.println(fourSum(arr, target));
    }

    static List<List<Integer>> fourSum(int[] arr, int target) {
        //создаем результирующий массив
        ArrayList<List<Integer>> res = new ArrayList<>();
        //проверяем корнер кейс - если длинна меньше 4 то и разговаривать нет смысла
        if (arr.length < 4) {
            return res;
        }

        //сортируем наш массив
        Arrays.sort(arr);

        //так как массив отсортирован - последний элемент - максимальный
        int max = arr[arr.length - 1];

        //сразу проверяем еще один корнер кейс
        //что если сумма 4ех минимумов а именно arr[0] больше чем таргет, то смысла
        //ничего искать нет, сумма всех остальных будет сто пудово больше
        //так же если сумма четерых максимумов буде меньше чем наш таргет то так же смысла нет
        if (4 * arr[0] > target || 4 * max < target) {
            return res;
        }


        int i = 0;
        int firstElm = 0;

        for (i = 0; i < arr.length; i++) {
            firstElm = arr[i];

            // делаем проверку что бы избежать дубликатов
            // если текущий элемент равен предыдущему - дубликат
            // разговаривать дальше смысла нет
            if (i > 0 && firstElm == arr[i - 1]) {
                continue;
            }

            //проверяем текущий элемент, если он плюс три раза по максимум НЕ дадут нам
            //наш таргет то рассматривать этот элемент нет никакого смысла!
            //впереди элементы будут только больше
            if (firstElm + 3 * max < target) {
                continue;//скипаем этот элемент
            }

            //еще одна проверка, если этот элемент умножить на 4 и получившиеся число
            //будет больше чем наше тогда опять же смысла идти в приниципе дальше нет
            //потому что дальше будут элементы только больше
            //а нам текущий уже больше дает
            if (4 * firstElm > target) {
                break;
            }

            //а вот если 4 * firstElm дает наш таргет то это повод задуматься
            if (4 * firstElm == target) {
                if (i + 3 < arr.length && arr[i + 3] == firstElm) {
                    //добавляем его в наш массив
                    res.add(Arrays.asList(firstElm, firstElm, firstElm, firstElm));
                }
                break;
            }

            //сводим задачу к подзадаче - а именно нахождению
            // 3sum
            // передаем туда наш исходный но уже отсортированный массив arr
            // target-firstElm то есть - теперь это будет новый тагрет без нашего начального элемента
            // в качестве low индекса мы передаем i+1 - это то место на котором мы нашли наш firstElm
            // то есть как бы отправную точку
            // в качестве high мы отправляем туда максимальный индекс - конца массива
            // ну и firstElm и наш массив резов

            //еще раз - идея такая - для каждого итого элемента, который мы пометили как firstElm
            //мы пытаемся найти такой 3sum который даст нужный таргет
            threeSumForFourSum(arr, target - firstElm, i + 1, arr.length - 1, res, firstElm);
        }

        return res;
    }


    /**
     * найди все возможные коомбинации из трех чисел которые на выходе дадут наш таргет
     * (а из того таргета мы вычли предварительно наш отправной элемент)
     * найти соотв в нашем сортированном массиве arr[], а где искать?
     * между индексами start и high
     * <p>
     * если такие есть добавь их все в массив резов
     * <p>
     * который мы передали на вход ArrayList<List<Integer>> res
     */

    static void threeSumForFourSum(int[] arr, int target, int start, int end, ArrayList<List<Integer>> res,
                                   int firstElm) {
        // как решается эта задача
        //будем ее пытаться свести к 2sum

        //для начала корнер кейсы
        //так как нам надо найти 3sum
        //то если индекс начала заходит за границы конца, то все
        //дальше смысла нет, там уже 3 элементов точно нет
        if (start + 1 >= end) {
            return;
        }

        //точно так же как и в верхнем алгоритме мы проверяем тут что наш
        //максимальный элемент умноженый уже на три не будет больше таргета
        //грубо говоря все те же корнер кейсы, смотрим имеет ли смысл вообще дальше крутится
        int max = arr[end];
        if (3 * arr[start] > target || 3 * max < target) {
            return;

        }

        int i = 0;
        int secondElm = 0;
        for (i = start; i < end - 1; i++) {
            secondElm = arr[i];
            if (i > start && secondElm == arr[i - 1]) { // так же проверяем что бы не было дублей
                continue;
            }
            if (secondElm + 2 * max < target) { // смотрим не мал оли элемент
                continue;
            }

            //смотрим не большой ли элемент
            if (3 * secondElm > target) { // z is too large
                break;
            }
            //и вот если он подходит то круто обогощаем наш массив
            //если нет, не беда, пытаемся по нему найти 2sum
            if (3 * secondElm == target) { // z is the boundary
                if (i + 1 < end && arr[i + 2] == secondElm) {
                    res.add(Arrays.asList(firstElm, secondElm, secondElm, secondElm));
                }
                break;
            }

            //дальше сокращаем задачу до 2sum
            //для каждых двух валидных, повторюсь валидных элементы мы пытаемся найти такую 2sum
            //которая даст нам нужную оставшуюся коомбинацию
            twoSumForFourSum(arr, target - secondElm, i + 1, end, res, firstElm, secondElm);
        }

    }

    /*
     * Find all possible distinguished two numbers adding up to the target
     * in sorted array arr[] between indices start and end. If there are,
     * add all of them into the ArrayList res, using
     * res.add(Arrays.asList(firstElm, secondElm, the two numbers))
     */
    static void twoSumForFourSum(int[] arr, int target, int start, int end, ArrayList<List<Integer>> res,
                                 int firstElm, int secondElm) {

        if (start >= end) {
            return;
        }

        if (2 * arr[start] > target || 2 * arr[end] < target) {
            return;
        }

        int i = start; //два указателя и и жы которые в конечном итоге должны сослаться на нужные два элемента
        int j = end;
        int sum;
        int x;

        //так как массив сортированный сделать это очень просто, достаточно просто
        //идти по массиву с двух сторон, сжимать его и смотрим что получается
        while (i < j) {
            sum = arr[i] + arr[j];
            if (sum == target) {
                res.add(Arrays.asList(firstElm, secondElm, arr[i], arr[j]));

                x = arr[i];
                while (++i < j && x == arr[i]) { // avoid duplicate

                }
                x = arr[j];
                while (i < --j && x == arr[j]) {
                    // avoid duplicate
                }
            }
            if (sum < target) {
                i++;
            }
            if (sum > target) {
                j--;
            }
        }
    }
}
