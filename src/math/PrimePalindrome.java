package math;

public class PrimePalindrome {

  public static void main(String[] args) {

  }


  /**
   * For each palindromic root, let's find the two associated palindromes (one with an odd number of
   * digits, and one with an even number.)
   * <p>
   * https://leetcode.com/problems/prime-palindrome/solution/
   *
   * проверям для четной длинный палиндрома и не четной длинны палиндрома
   * идея близкая к тому что мы делалил с reverse integer
   */
  public int primePalindrome(int n) {

    for (int l = 1; l <= 5; ++l) {
      //Check for odd-length palindromes
      //проверяем для не четной длинны палиндром
      for (int root = (int) Math.pow(10, l - 1); root < (int) Math.pow(10, l); ++root) {
        StringBuilder sb = new StringBuilder(Integer.toString(root));
        for (int k = l - 2; k >= 0; --k) {
          sb.append(sb.charAt(k));
        }
        int x = Integer.parseInt(sb.toString());
        if (x >= n && isPrime(x)) {
          return x;
        }
        //If we didn't check for even-length palindromes:
        //return N <= 11 ? min(x, 11) : x
      }

      //Check for even-length palindromes
      //проверяем для четной длинны палиндрома
      for (int root = (int) Math.pow(10, l - 1); root < (int) Math.pow(10, l); ++root) {
        StringBuilder sb = new StringBuilder(Integer.toString(root));
        for (int k = l - 1; k >= 0; --k) {
          sb.append(sb.charAt(k));
        }
        int x = Integer.parseInt(sb.toString());
        if (x >= n && isPrime(x)) {
          return x;
        }
      }
    }
    return -1;
  }

  public boolean isPrime(int n) {
    if (n < 2) {
      return false;
    }
    int r = (int) Math.sqrt(n);
    for (int d = 2; d <= r; ++d) {
      if (n % d == 0) {
        return false;
      }
    }
    return true;
  }

}
