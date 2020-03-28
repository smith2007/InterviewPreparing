package backtracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {

  public static void main(String[] args) {
    RestoreIPAddresses restoreIPAddresses = new RestoreIPAddresses();
    for (String restoreIpAddress : restoreIPAddresses.restoreIpAddresses("010010")) {
      System.out.println(restoreIpAddress);
    }

  }

  public List<String> restoreIpAddresses(String str) {
    List<String> res = new ArrayList<>();
    backtrack("", str, res, 0);
    return res;
  }

  void backtrack(String currStr, String remainingStr, List<String> res, int countOfBlocks) {
    if (countOfBlocks > 4) {
      return;
    }
    if (remainingStr.isEmpty()) {
      if (countOfBlocks == 4) {
        res.add(currStr);
      }
      return;
    }
    // запускаем бэктрекинг на одном символе
    String oneDigit = remainingStr.substring(0, 1);
    String newRemaining = remainingStr.substring(1);
    String newCurrStr = newRemaining.isEmpty() ? currStr + oneDigit : currStr + oneDigit + ".";
    backtrack(newCurrStr, newRemaining, res, countOfBlocks + 1);

    // запускаем бэктрекинг на двух символах
    if (remainingStr.length() > 1) {
      String twoDigits = remainingStr.substring(0, 2);
      newRemaining = remainingStr.substring(2);
      newCurrStr = newRemaining.isEmpty() ? currStr + twoDigits : currStr + twoDigits + ".";
      if (twoDigits.charAt(0) != '0') {
        backtrack(newCurrStr, newRemaining, res, countOfBlocks + 1);
      }
    }

    // запускаем бэктрекинг на трех символах
    if (remainingStr.length() > 2) {
      String threeDigits = remainingStr.substring(0, 3);
      //с учетом того что мы не вылезли за рамки 255
      if (Integer.parseInt(threeDigits) < 256) {
        newRemaining = remainingStr.substring(3);
        newCurrStr =
            newRemaining.isEmpty() ? currStr + threeDigits : currStr + threeDigits + ".";
        if (threeDigits.charAt(0) != '0') {
          backtrack(newCurrStr, newRemaining, res, countOfBlocks + 1);
        }
      }
    }
  }

}
