package array;

public class JumpGame {

    public static void main(String[] args) {

        int[] arr = {1,2,3};

        System.out.println(canJump(arr));
    }

    // вот я перешел на сл элемент
    //что мне интересно
    //мне интересно на сколько я еще вперед смогу прыгнуть с учетом
    // того что до этого места я препрыгал

    // бежим по массиву
    //если нашли элемент больше максимума (оставшихся прыжков)
    //организуем цикл отсюда до этого максимума
    //если текущая итая позиция плюс значение arr[i] >= последнему элементу
    //тогда возвращаем true

    static boolean canJump(int[] arr) {
        if (arr.length == 1) {
            return true;
        }
        int jumps = arr[0];
        int i = 0;
        while (true) {
            if (jumps == 0) {
                return false;
            }
            // джампы есть
            // пошли вмеред
            i++;
            jumps--; // прыгнули

            //если допрыгали до конца
            if (i == arr.length-1){
                return true;
            }

            //если до конца не допрыгали проверяем текущий
            //элемент
            if (arr[i] > jumps) {
                jumps = arr[i];
            }
        }
    }
}
