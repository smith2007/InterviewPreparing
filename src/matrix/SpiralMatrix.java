package matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};

        List<Integer> integers = spiralOrder(matrix);

        for (Integer integer : integers) {
            System.out.print(integer +" ");
        }

    }

    static List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix.length == 0) {
            return res;
        }

        //вводим две группы переменных
        //начальный и конечный индекс строк
        int rowBegin = 0;
        int rowEnd = matrix.length - 1;

        //и начальный и конечный индекс колонки
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;

        //раскручиваем цикл, каждая итерация это как бы
        //новый виток нашей спирали
        while (rowBegin <= rowEnd && colBegin <= colEnd) {

            // каждый виток начинается с похода на право
            // идем до упора направо по колонкам
            // в фиксированной строке бежим вправо
            for (int j = colBegin; j <= colEnd; j++) {
                //набиваем первые элементы витка
                res.add(matrix[rowBegin][j]);
            }
            //как только закончили с этой строкой сразу спустимся
            //вниз на одну ячейку для будущего витка
            rowBegin++;

            // теперь бежим вниз
            //максимально вниз до упора до последней строки
            //при фиксированном номере столбца
            for (int j = rowBegin; j <= rowEnd; j++) {
                res.add(matrix[j][colEnd]);
            }
            //все нам последняя колонка уже не понадобится
            //двигаем счетчик колонок влево
            colEnd--;


            if (rowBegin <= rowEnd) {
                // дальше надо пройти влево
                //для этого стартуем с последней текущей колонки
                //и бежим максимально влево до упора
                for (int j = colEnd; j >= colBegin; j--) {
                    //при фиксированном номере строки
                    res.add(matrix[rowEnd][j]);
                }
            }
            //все строка снизу нам не нужна
            //нижний предел поднимаем на один
            rowEnd--;


            //главное не зайти за границы и постоянно контролировать
            //что колонка начала не заступила за колонку конца
            if (colBegin <= colEnd) {
                // следующий завершаюий шаг это закончить наш виток
                //и поднятся наверх до верхней строки
                //при фиксированной колонке
                for (int j = rowEnd; j >= rowBegin; j--) {
                    res.add(matrix[j][colBegin]);
                }
            }
            //после этого та фиксированная колонка нам больше не нужна
            // двигаем ее вправо
            colBegin++;
        }


        //вот и весь алгоритм, элементарно ватсон
        return res;
    }

}
