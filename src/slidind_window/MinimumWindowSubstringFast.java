package slidind_window;

public class MinimumWindowSubstringFast {

  public String minWindow(String str, String target) {
    if (str.length() < target.length()) {
      return "";
    }

    int[] hash = new int[256];

    char[] charsStr = str.toCharArray();
    char[] charsTarget = target.toCharArray();

    for (char ch : charsTarget) {
      hash[ch]++;
    }

    int[] res = new int[2];

    int i = 0;
    int j = 0;

    int count = charsTarget.length;

    int minLen = Integer.MAX_VALUE;

    while (j < charsStr.length) {
      char charStrJ = charsStr[j];
      if (hash[charStrJ] >= 1) {
        count--;
      }
      hash[charStrJ]--;
      j++;

      while (count == 0) {
        if (j - i < minLen) {
          minLen = j - i;
          res[0] = i;
          res[1] = j;
        }
        char prev = charsStr[i++];
        if (hash[prev]++ >= 0) {
          count++;
        }
      }
    }
    return str.substring(res[0], res[1]);
  }

}
