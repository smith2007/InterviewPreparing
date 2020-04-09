package parentheses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParentheses {

  /**
   * решается за квадратичное время
   * <p>
   * Limit max removal rmL and rmR for backtracking boundary. Otherwise it will exhaust all possible
   * valid substrings, not shortest ones. Scan from left to right, avoiding invalid strs (on the
   * fly) by checking num of open parens. If it's '(', either use it, or remove it. If it's '(',
   * either use it, or remove it. Otherwise just append it. Lastly set StringBuilder to the last
   * decision point. In each step, make sure:
   * <p>
   * i does not exceed s.length(). Max removal rmL rmR and num of open parens are non negative.
   * De-duplicate by adding to a HashSet.
   */
  public List<String> removeInvalidParentheses(String s) {
    int maxPossibleRemovalOfOpenPar = 0;
    int maxPossibleRemovalOfClosePar = 0;
    //перво наперво надо понять какие варианты у нас вообще
    //есть - то есть сколько не закрытых скобок ( или ) у нас есть
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        maxPossibleRemovalOfOpenPar++;
      } else if (s.charAt(i) == ')') {
        if (maxPossibleRemovalOfOpenPar != 0) {
          maxPossibleRemovalOfOpenPar--;
        } else {
          maxPossibleRemovalOfClosePar++;
        }
      }
    }
    //будем набивать хэшсет резов
    Set<String> res = new HashSet<>();
    dfs(s, 0, res, new StringBuilder(), maxPossibleRemovalOfOpenPar, maxPossibleRemovalOfClosePar,
        0);
    return new ArrayList<>(res);
  }

  /**
   * param totalOpenCount -  means the current result in StringBuilder is valid or not. If
   * totalOpenCount < 0 that indicates your # of closing parenthesis is greater than open
   * parenthesis, so the recursive will stop because it's not possible to become valid.
   */
  public void dfs(String str, int i, Set<String> res, StringBuilder sb, int openParCount,
      int closeParCount, int totalOpenCount) {

    if (openParCount < 0 || closeParCount < 0 || totalOpenCount < 0) {
      return;
    }

    //если мы достигли конца строки
    //и открытых и закрытых скобок у нас есть, не вышли ранее - значит
    //эта строчка валидная
    if (i == str.length()) {

      if (openParCount == 0 && closeParCount == 0 && totalOpenCount == 0) {
        res.add(sb.toString());
      }
      return;
    }

    char currChar = str.charAt(i);
    int currLength = sb.length();

    if (currChar == '(') {
      //вариант такой - либо удаляем открытую
      // not use (
      dfs(str, i + 1, res, sb, openParCount - 1, closeParCount, totalOpenCount);
      //оставляем закрытую
      // use (
      dfs(str, i + 1, res, sb.append(currChar), openParCount, closeParCount, totalOpenCount + 1);
    } else if (currChar == ')') {
      //тоже самое и тут - либо оставляем открытую
      //либо ее не оставляем
      dfs(str, i + 1, res, sb, openParCount, closeParCount - 1,
          totalOpenCount);              // not use  )
      dfs(str, i + 1, res, sb.append(currChar), openParCount, closeParCount,
          totalOpenCount - 1);        // use )
    } else {
      //значит это буква - ее берем без раздумий
      dfs(str, i + 1, res, sb.append(currChar), openParCount, closeParCount, totalOpenCount);
    }
    sb.setLength(currLength);
  }
}
