package core;

public class PalindromeNumber {

    public static void main(String[] args) {
        System.out.println(isPalindrome(1221));
    }

    static boolean isPalindrome(int x) {

        // первая идея это проверить что строка полиндром - это плохая идея
        //вторая идея это пользоваться математикой
        //сразу проверяем эдж кейсы
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        //в этот коллектор будем накидывать разряды
        int revertedCollector = 0;

        //дальше идет сплошная математика
        //крутимся в цикле до тех пор пока наше исходное число
        //будет больше чем темповое - ревертед как бы
        while (x > revertedCollector) {

            //суть в том что мы идем по разрядам и набиваем разряды

            //в reverted мы разряды добавляем
            //накручиваем из икса как бы

            //самое интересное конечно как накинуть разряд из одного числа
            // первое - нужно тупо добавить новый разряд справа к уже имеющемуся число это делаем умножением на 10
            //revertedCollector*10 - вот так
            //далее надо убрать правый разряд из икса
            //x%10 это делаем вот так
            //ну и что дальше ну конечно же складываем
            revertedCollector = revertedCollector * 10 + x % 10;

            x = x / 10; // каждая итерация мы уменьшаем разряд исходного числа
            //было 121 - будет 12
        }

        //итого на выходе у нас получится что левая часть равна тупо правой части
        //это будет в случае если интеджер состоит из четного числа цифр

        //либо ревертед без одного крайнего разряда равно иксу то есть
        //в этом случае у нас кол-во цифр не четное
        return x == revertedCollector || x == revertedCollector / 10;
    }
}