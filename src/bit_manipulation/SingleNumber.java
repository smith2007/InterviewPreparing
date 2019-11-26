package bit_manipulation;

public class SingleNumber {

    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 1, 2};
        System.out.println(singleNumber(arr));
    }

    //тут идея вот в чем мы как бы складываем элементы
    //используя этот ксор
    // особенность этого ксора в том что складывая дублированные
    //элементы финальное число даст ноль то есть ксор элемент сам на себя получается не
    //сложение а вычитание
    // таким образом дойдя до конца мы получим либо элемент который не имеет пары, его не вычли
    //либо ноль еси каждый элемент имеет пару

    //гениально
    static int singleNumber(int[] arr) {
        int result = 0;
        for (int i : arr) {
            result = result ^ i;
        }
        return result;
    }
}
