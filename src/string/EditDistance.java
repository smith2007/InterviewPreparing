package string;

public class EditDistance {

  public static void main(String[] args) {
    int i = minDistance("horse", "ros");
    System.out.println(i);
  }

  static int minDistance(String word1, String word2) {
    //если слова и так равн друг другу то все вопросов нет
    if (word1.equals(word2)) {
      return 0;
    }
    //если одно из слов пустое то тогда надо просто вернуть разницу длинн
    if (word1.isEmpty() || word2.isEmpty()) {
      return Math.abs(word1.length() - word2.length());
    }
    //объявляем матрицу dp по вертикале будет одно слово
    //по горизонтале второе слово
    //но шире на один столбец и одну строку
    int[][] dp = new int[word1.length() + 1][word2.length() + 1];
    //заполняем по горизонтале индексы каждого символа первого слова
    for (int i = 0; i <= word1.length(); i++) {
      dp[i][0] = i;
    }
    //и второго слова
    for (int i = 0; i <= word2.length(); i++) {
      dp[0][i] = i;
    }
    //ну и начинаем бегать по нашей матрицы и заполнять ее ячейки
    for (int i = 1; i <= word1.length(); i++) {
      for (int j = 1; j <= word2.length(); j++) {
        //если символы равны - то берем в качестве dp[i][j] просто диагональ
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          //если символы не равны то мы берем в качестве dp[i][j] = минимум из того что по бокам либо по диагонали
          dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
        }
      }
    }
    return dp[word1.length()][word2.length()];
  }

}
