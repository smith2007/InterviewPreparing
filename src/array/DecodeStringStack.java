package array;

import java.util.LinkedList;

public class DecodeStringStack {

    // 2[a]3[b]10[c] - aabbbc
    public static void main(String[] args) {
        String str = "2[a]3[b]20[c]";
        System.out.println(transform(str));
    }


    /**
     * s = "3[a]2[bc]", return "aaabcbc".
     * s = "3[a2[c]]", return "accaccacc".
     * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
     */

    static String transform(String str) {

        String curr = "";

        //первый стек будет нужен для того что бы набивать числа - сколько раз повторять
        //ризонный вопрос зачем тут нужен стек для того что бы обработать ситуации как тут:
        // 3[a2[c]]
        LinkedList<Integer> countStack = new LinkedList<>();

        //второй стек нужен для того что бы держать текущую строку
        LinkedList<String> resStack = new LinkedList<>();
        int i = 0;

        //крутимся в цикле
        //наша задача набить две вещи - паттерн
        //и число сколько раз этот паттерн повторится
        while (i < str.length()) {
            if (Character.isDigit(str.charAt(i))) { // если встретили число - крутимся собираем все диджиты
                String count = "";
                while (Character.isDigit(str.charAt(i))) { //проходим максимально вправо до тех пор
                    count += str.charAt(i); // до тех пор пока не соберем полностью число
                    i++;
                }
                countStack.push(Integer.parseInt(count)); // как только собрали кладем их на стек
            } else if (str.charAt(i) == '[') {
                resStack.push(curr); // resStack - у нас используется для того что бы хранить текущую строку
                curr = "";//обнуляем - те нам надо начать набивать паттерн а текущую строку положить на стек
                i++;
            } else if (str.charAt(i) == ']') { //как только встретили закрывающую скобку,
                // это говорит о том что паттерн набили
                String previousStr = resStack.pop(); // вытаскиваем предыдущую строку
                Integer times = countStack.pop(); //вытаскиваем сколько раз нам надо набить
                for (int j = 0; j < times; j++) {
                    previousStr += curr; //набиваем
                }
                curr = previousStr; // фиксируем
                i++;
            } else if (Character.isLetter(str.charAt(i))) {
                curr += str.charAt(i);
                i++;
            }

        }

        return curr;

    }
}
