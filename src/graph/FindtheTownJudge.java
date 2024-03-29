package graph;

public class FindtheTownJudge {


  /**
   * в городе где живет N людей которые пронумерованя от 1 до N - пустили слух что один из этих
   * людей Ходят слухи, что один из этих людей тайно является городским судьей. Если городской судья
   * существует, то:

   * 1 - Городской судья никому не доверяет.
   * 2. Все (кроме городского судьи) доверяют городскому
   * судье.
   * 3. Существует ровно один человек, который удовлетворяет свойствам 1 и 2.

   * нам дан массив доверия  trust[i] = [a, b] где показано что человек a доверяет человеку b если
   * такой судья есть и может быть иденфицирован - верни его номер, в противном случае верни -1
   */
  public int findJudge(int[][] trusts, int n) {
    if (trusts.length == 0) {
      return n == 1 ? 1 : -1;
    }
//тут нам надо найти того чувака кому доверяют все, соотв пошли смотреть траст связи
    int[] trustCount = new int[n + 1];
    //проходим по тем связя
    for (int[] trust : trusts) {
      //просто будем инкрементить тогда когда кто то кому то доверяет
      trustCount[trust[1]]++;
      trustCount[trust[0]]--;
    }
    for (int i = 1; i < trustCount.length; i++) {
      //и в том случае если нашли такого чувака которому доверяют все вот он
      if (trustCount[i] == n - 1) {
        return i;
      }
    }
    return -1;
  }

}
