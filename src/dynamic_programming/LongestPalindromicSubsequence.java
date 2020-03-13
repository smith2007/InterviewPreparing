package dynamic_programming;

public class LongestPalindromicSubsequence {


  public static void main(String[] args) {
    System.out.println(longestPalindromeSubseq("bbbab"));
  }

  /**
   1 2 3 3 4
   0 1 2 2 3
   0 0 1 1 3
   0 0 0 1 1
   0 0 0 0 1
   */
  static int longestPalindromeSubseq(String s) {

    //каждый элемент в строке будет говорить нам о том какой макисмальный
    // палиндром получится если начать с 0 с 1ой со 2ой буквы и так далее
    //теперь как такую матрицу заполнить
    int[][] dp = new int[s.length()][s.length()];

    // идем с конца нашей строки
    for (int i = s.length() - 1; i >= 0; i--) {
      //по диагонали всегда будут единицы - потому что какой символ не возьми он сам из себя палиндром
      dp[i][i] = 1;
      //заполняем только верхнюю диагональ матрицы
      //как заполнить только верхнюю диагональ? начинать отсчет столбцов с i+1, а указатель j
      //у нас смотрит на столбцы всегда
      //раскручиваем цикл
      for (int j = i + 1; j < s.length(); j++) {
        //итый замер на определенной позиции, смотрим если наши буквы равны то есть стоит например bb
          char chari = s.charAt(i);
          char charj = s.charAt(j);
          if (chari == charj) {
          //то надо взять предыдущее значение и проапдейтить его на 2
            dp[i][j] = dp[i + 1][j - 1] + 2;
          } else {
            //а вот если нет, то надо брать максимум из предыдущих расчетов
            dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
        }
      }
    }

    return dp[0][s.length() - 1];

  }

}
