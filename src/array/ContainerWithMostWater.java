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
        int left = 0;
        int right = arr.length - 1;

        int maxArea = 0;
        while (left < right) {
            int size = right - left;
            int localArea = size * Math.min(arr[left], arr[right]);
            maxArea = Math.max(maxArea, localArea);

            if (arr[left] < arr[right]) {
                left++;
            } else {
                right--;
            }

        }
        return maxArea;
    }
}
