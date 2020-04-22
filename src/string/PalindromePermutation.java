package string;

import java.util.HashSet;
import java.util.Set;

public class PalindromePermutation {

  /**
   * дана строка - пойми можно ли из ее пермутейшена сделать палиндром тут просто решается через хеш
   * сет надо просто учитывать что каждый символ должен встречаться 2 4 6 раз кроме одного
   */
  public boolean canPermutePalindrome(String s) {
    Set<Character> set = new HashSet<Character>();
    for (char c : s.toCharArray()) {
      if (set.contains(c)) {
        set.remove(c);// If char already exists in set, then remove it from set
      } else {
        set.add(c);// If char doesn't exists in set, then add it to set
      }
    }
    return set.size() <= 1;
  }

}
