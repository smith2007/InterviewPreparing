package string;

public class LongestPalidromicSubstring {


    public static void main(String[] args) {
        String str = "cbbd";

        LongestPalidromicSubstring lps = new LongestPalidromicSubstring();
        System.out.println(lps.longestPalindrome(str));

    }

    private int start, end, maxLen;

    public String longestPalindrome(String s) {

        if (s.length() < 2) {
            return s;
        }

        //тут идея в следующем - берем итый элемент
        //и бежим в обе стороны
        //влево и вправо
        //подсчитываем смотрим что это палиндром

        //итый индекс это центр палиндрома

        for (int i = 0; i < s.length() - 1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i + 1); //assume even length.
        }

        return s.substring(start, end + 1);
    }

    private void extendPalindrome(String s, int i, int j) {

        //бежим влево и вправо
        //сужаем границы до тех пор пока и слева и справа будут равные символы
        //ищем полиндром
        //как только достигли границ строки
        //или наткнулись на то что символы разные
        //выходим из цикла
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            j++;
            i--;
        }

        //как только вышли из цикла значит палиндром нашли
        //хоть какой-либо
        //ну или не нашли и остаемся с пустой строкой
        //он может состоять хоть из одного символа
        //хоть из нуля
        int currSubsLength = j - i - 1;

        //ну и все дальше дело техники, надо
        // посмотреть длинну и сохранить
        if (end - start - 1 < currSubsLength) {
            maxLen = currSubsLength;
            start = i + 1;
            end = j - 1;
        }
    }
}


