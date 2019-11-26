package greedy;

public class LemonadeChange {

    public static void main(String[] args) {
        int[] arr = {5, 5, 5, 10, 20};
        System.out.println(lemonadeChange(arr));
    }

    static boolean lemonadeChange(int[] arr) {
        int count5 = 0;
        int count10 = 0;

        for (int bill : arr) {
            if (bill == 5) { // если пришел чувак с 5 баксами ничего не делаем
                count5++;

            } else if (bill == 10) { //если пришел чувак с 10
                if (count5 == 0) { // и пятерок у нас нет тогда false
                    return false;
                } else {
                    count5--; // если пятерки есть - дай сдачу
                    count10++; //увелич кол-во десяток на 1
                }
            } else { // если чувак пришел с 20кой - надо дать 15 баксов сдачу

                if (count10 > 0 && count5 > 0) {   //если есть и пятерки и десятки
                    count5--;//дай одну пятерку
                    count10--;//и одну десятку
                } else if (count5 >= 3) { //если же десяток нет и кол-во пятерок больше или равно 3
                    count5 -= 3; //отдай три пятерки иначе false
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
