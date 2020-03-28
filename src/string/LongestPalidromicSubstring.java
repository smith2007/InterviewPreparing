package string;

public class LongestPalidromicSubstring {


  public static void main(String[] args) {
    String str = "cbbd";

    LongestPalidromicSubstring lps = new LongestPalidromicSubstring();
    System.out.println(lps.longestPalindrome(str));

  }

  int start = 0;
  int end = 0;
  int maxLen = 0;


  public String longestPalindrome(String s) {

    //если длинна меньше или равна 2 тогда и разговаривать нечего
    if (s == null || s.isEmpty()) {
      return "";
    }

    //тут идея в следующем - берем итый элемент
    //и бежим в обе стороны
    //влево и вправо
    //подсчитываем смотрим что это палиндром

    //итый индекс это центр палиндрома
    //мы не знаем какой потенциальный сабстринг у нас палиндром - он четный или нечетный
    //по этому мы идем по каждой строке и гооворим ей а
    for (int i = 0; i < s.length() - 1; i++) {
      traverse(s, i, i);//предположим что палиндром НЕ четный
      // тогда разбегаемся от итого символа bab - например

      traverse(s, i, i + 1);
    }
    return s.substring(start, end + 1);//предположим что ты будешь четной длинны, тогда разбегаемся
    //во все стороны от тебя и от твоего правого соседа baab - например
  }

  public void traverse(String s, int i, int j) {

    if (i < 0 || j > s.length() - 1) {
      return;
    }

    //бежим влево и вправо
    //сужаем границы до тех пор пока и слева и справа будут равные символы
    //ищем полиндром
    //как только достигли границ строки
    //или наткнулись на то что символы разные
    //выходим из цикла
    while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
      i--;
      j++;
    }
    if (maxLen < (j - i - 1)) {
      maxLen = (j - i - 1);
      start = i + 1;
      end = j - 1;
    }
  }
}


