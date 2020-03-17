package sorting;

public class SortColorsSmart {

    public static void main(String[] args) {

        int[] arr = {0, 2, 1, 2, 0, 0, 2};

        sortColors(arr);

        for (int value : arr) {
            System.out.println(value);
        }
    }


    /**
     * интересная задача, сначала я решил ее выпушиванием двоек а затем единиц вперед, делалось это за два прохода
     * но есть более умный подход за один подход
     * <p>
     * он состоит в том что мы делаем три указателя zeroIndex, twoIndex и i
     * итый индекс у нас гуляет по массиву вперед
     *
     * зеро и ту индекс соотв по бокам - они будут сжиматься соотв мы будем свопать когда встретим итый индекс == 0
     * или когда итый индекс == 2
     *
     * zeroIndex, twoIndex - просто показывают места в которые нам надо вставить то или иное число
     *
     */
    static void sortColors(int[] nums) {
        int zeroIndex = 0;
        int twoIndex = nums.length - 1;
        int i = 0;

        while (i <= twoIndex) {
            if (nums[i] == 0) {
                swap(nums, zeroIndex, i);
                zeroIndex++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, twoIndex, i);
                twoIndex--;
            } else {
                i++;
            }
        }
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
