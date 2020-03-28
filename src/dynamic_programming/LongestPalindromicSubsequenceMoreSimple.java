package dynamic_programming;

public class LongestPalindromicSubsequenceMoreSimple {


  public static void main(String[] args) {
    System.out.println(longestPalindromeSubseq("bbbab"));
  }


  static int longestPalindromeSubseq(String s) {
    StringBuilder sb = new StringBuilder(s);
    //первым делом разворачиваем строчку
    String s2 = sb.reverse().toString();

    int n = s.length();
    //делаем матрицу dp на одно деление шире
    int[][] dp = new int[n + 1][n + 1];
    //раскручиваем цикл по i j
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= n; j++) {
        //нулевой эл - всегда будет нулевым
        if (i == 0 || j == 0) {
          dp[i][j] = 0;
        } else if (s.charAt(i - 1) == s2.charAt(j - 1)) {
          //если символы равны - это значит повод как бы продолжить наш палиндром
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          //если символы не равны, то придется скипнуть этот символ
          //и взять как бы максимум из того что по бокам
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    return dp[n][n];
  }

}
