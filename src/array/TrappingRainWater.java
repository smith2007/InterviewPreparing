package array;

public class TrappingRainWater {

  public static void main(String[] args) {
    int[] arr = {0, 1, 3, 1, 0, 1, 2, 1, 0, 1};

    System.out.println(trap(arr));
  }

  /**
   * есть массив числе, каждое число это как бы стенка - перегородка определнной высоты, посчитай
   * какое максимальное кол во воды поместится в данный вымышленный резервуар тут классика с двумя
   * указателями сдвигаем слева и справа пытаемся найти чашки
   */

  static int trap(int[] height) {
    if (height.length == 0) {
      return 0;
    }
    int i = 0;
    int j = height.length - 1;
    int water = 0;

    //как найти грани чашки?
    //надо пытаться найти локальный максимумы
    //которые прошли эти указатели
    int localMaxi = 0;
    int localMaxj = 0;

    while (i != j) {

      //каждую итерацию пытаемся обновить локальный максимум слева
      localMaxi = Math.max(height[i], localMaxi);
      //и справа
      localMaxj = Math.max(height[j], localMaxj);

      //дальше надо понять
      //какой указатель двигать - а двигать надо тот - который меньше
      if (height[i] < height[j]) {
        i++;
        //каждый раз итеарационно считаем
        //воду, имея в голове то что
        //локальный максимум это есть грань нашего сосуда
        int localWater = localMaxi - height[i];
        //если кол-во воды не отрицательное
        //обновляем общий каунтер воды
        if (localWater > 0) {
          water += localWater;
        }
      } else {
        //тоже самое и тут - двигаем правый указатель
        //считаем тут локальную воду
        j--;
        int localWater = localMaxj - height[j];
        if (localWater > 0) {
          water += localWater;
        }
      }
    }
    return water;
  }
}
