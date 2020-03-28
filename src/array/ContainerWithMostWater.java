package array;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(arr));
    }

    /**
     * здесь тупо найти грани слева и справа, берем самую наибольшую в левой части массива
     * и самую наибольшую в правой части массива, условно это наша чашка
     *
     * далее счиатем как бы площадь воды - это тупо минимальная высота умноженое на кол-во
     */

    static int maxArea(int[] arr) {
        //делаем два указателя слева и справа
        int left = 0;
        int right = arr.length - 1;
        //ну и максимум
        int maxArea = 0;
        //работаем по принципу сжатия
        while (left < right) {
            //считаем
            int countOfBlocks = right - left;
            //и считаем площадь опираясь на минимальную гранб
            int localArea = countOfBlocks * Math.min(arr[left], arr[right]);
            //обновляем максимум если надо
            maxArea = Math.max(maxArea, localArea);
            // ну и двигаем указатель левый или правый в зависимости от того что меньше
            if (arr[left] < arr[right]) {
                left++;
            } else {
                right--;
            }

        }
        return maxArea;
    }
}
