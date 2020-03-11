package string;

public class GoatLatin {

  public static void main(String[] args) {
    System.out.println(toGoatLatin("I speak Goat Latin"));
  }

  static String toGoatLatin(String str) {
    if (str == null) {
      return null;
    }

    StringBuilder sb = new StringBuilder();

    String[] arr = str.split(" +");

    for (int i = 0; i < arr.length; i++) {
      StringBuilder localSb = new StringBuilder();
      String word = arr[i];
      if (isVowel(word.charAt(0))) {
        localSb.append(word).append("ma");
      } else {
        localSb.append(word.substring(1)).append(word.charAt(0)).append("ma");
      }
     // localSb.append("a".repeat(i + 1));
      sb.append(localSb);
      if (i != arr.length - 1) {
        sb.append(" ");
      }
    }
    return sb.toString();
  }

  private static boolean isVowel(char c) {
    return "AEIOUaeiou".indexOf(c) != -1;
  }

}
