package string;

public class IsStringContainsDoubleChars {

    public static void main(String[] args) {
        String s = "andrey";

        System.out.println(isContainsDoubleChars(s));

        //false

        String s1 = "aandrey";

        System.out.println(isContainsDoubleChars(s1));

        //true

    }


    //самый тупой способ - хэшмап О(n) - О(n)
    //самый тупой способ - два цикла - O(n2)
    //умный способ посчитать кол-во символов исходя из алфавита - АЦКИХ символов - их 128 - О(n)
    //можно отсортировать две строчки и проверить i и j элементы на идентичность - О(n log n)
    static boolean isContainsDoubleChars(String string){
        int[] letters = new int[128]; // {0,0,0...0}

        for (char c : string.toCharArray()) {
            if (letters[c] == 0){
                letters[c] = letters[c]+1;
            } else {
                return true;
            }
        }
        return false;
    }
}
