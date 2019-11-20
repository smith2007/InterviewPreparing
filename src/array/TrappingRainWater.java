package array;

public class TrappingRainWater {

    public static void main(String[] args) {
        int[] arr = {0, 1, 3, 1, 0, 1, 2, 1, 0, 1};

        System.out.println(find(arr));
    }

    /*
    есть массив числе, каждое число это как бы стенка
    - перегородка определнной высоты,
    посчитай какое максимальное кол во воды поместится в данный вымышленный резервуар
     */

    //тут классика с двумя указателями
    //сдвигаем слева и справа
    //пытаемся найти чашки

    static int find(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        int water = 0;

        //как найти грани чашки?
        //надо пытаться найти локальный максимумы
        //которые прошли эти указатели
        int localMaxi = 0;
        int localMaxj = 0;

        while (i != j) {

            //каждую итерацию пытаемся обновить локальный максимум
            if (arr[i] > localMaxi) {
                localMaxi = arr[i];
            }

            if (arr[j] > localMaxj) {
                localMaxj = arr[j];
            }

            //дальше надо понять
            //какой указатель двигать
            if (arr[i] < arr[j]) {
                i++;
                //каждый раз итеарационно считаем
                //воду, имея в голове то что
                //локальный максимум это есть грань нашего сосуда
                int localWater = localMaxi - arr[i];
                //если кол-во воды не отрицательное
                //обновляем общий каунтер воды
                if (localWater > 0) {
                    water += localWater;
                }
            } else {
                j--;
                int localWater = localMaxj - arr[j];
                if (localWater > 0) {
                    water += localWater;
                }
            }
        }
        return water;

    }
}
