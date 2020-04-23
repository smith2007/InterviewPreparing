package array;

public class MajorityElement {

    /**
     * https://leetcode.com/problems/majority-element
     */
    public static void main(String[] args) {

        int[] arr = {2, 1, 2, 5, 3, 2};
        System.out.println(majorityElement(arr));
    }

    /**
     * идея состоит в том что бы создать каунтер
     * этот каунтер будет каждый раз прибавлятся тогда когда мы
     * встречаем элемент равный нашему ранее зафиксированному мажорному эл-ту
     * <p>
     * и декрементить его как только мы встретили элемент отличный от него
     * гениально
     */
    static int majorityElement(int[] arr) {

        int count = 0;
        int majorCandidate = arr[0];

        for (int elm : arr) {
            //как только каунтер стал равен 0 - сбрасываем
            //и переназначаем мажорный элемент
            if (count == 0) {
                majorCandidate = elm;
                count++;
            } else if (elm == majorCandidate) {
                count++;
            } else {
                count--;
            }
        }
        return majorCandidate;
    }
}
