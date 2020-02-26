package array;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {

    public static void main(String[] args) {

        int[][] a = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] b = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};


        int[][] res = intervalIntersection(a, b);

        for (int[] re : res) {
            for (int i : re) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }

    /**
     * необходимо найти пересечения по интервалам, действуем через 2 указателя
     * i и j - первый бежит по первому массиву второй по второму
     */
    static int[][] intervalIntersection(int[][] a, int[][] b) {


        if (a.length == 0 || b.length == 0) {
            return new int[0][0];
        }

        List<int[]> result = new ArrayList<>();

        int i = 0;
        int j = 0;

        //крутимся в цикле до тех пор пока не достигнем какого-либо конца
        while (i < a.length && j < b.length) {
            int[] first = a[i]; //берем попарно элементы (они же отрезки как бы)
            int[] second = b[j];

            //теперь наша задача попытаться найти как бы нижнюю границу нашего теоретического отрезка - интерсекта нашего
            //так как это нижняя граница - то берем максимум!! 0-1 берем 1 - потому что ищем пересечение
            int low = Math.max(first[0], second[0]);

            //а верхняя граница соответсвенно будет искаться по минимуму 2 и 5 - что берем конечно 2
            int high = Math.min(first[1], second[1]);

            //по итогу например получим 1-2 - перевый переченный отрезок

            //но вот тут надо посмотреть а точно ли получился отрезок??
            //то есть нижняя граница она меньше чем верхняя
            if (low <= high) {
                //если да то это сто процентов отрезок
                result.add(new int[]{low, high});
            }


            //а далее надо решить какой указатель двигать
            //а как это понять??
            //что двигать то что меньше то и двигать вперед, зачем нам двигать тот который больше???
            //может быть этот больший отрезок станет частью другого пересекаемого интервала
            if (a[i][1] < b[j][1]) {
                i++;

            } else {
                j++;

            }
        }

        int[][] res = new int[result.size()][2];

        for (int k = 0; k < result.size(); k++) {
            res[k][0] = result.get(k)[0];
            res[k][1] = result.get(k)[1];
        }

        return res;
    }
}
