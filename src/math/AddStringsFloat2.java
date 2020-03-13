package math;

public class AddStringsFloat2 {

  public static void main(String[] args) {
    System.out.println(addStrings("3.14", "0.9"));
  }

  static String addStrings(String str1, String str2) {

    if (str1 == null || str2 == null) {
      return null;
    }

    String[] first = str1.split("\\.");
    String[] second = str2.split("\\.");

    String firstSecondPart = first[1];
    String secondSecondPart = second[1];

    int i = Math.max(firstSecondPart.length() - 1, secondSecondPart.length() - 1);
    int cary = 0;

    StringBuilder sb = new StringBuilder();
    while (i >= 0) {

      int f = i >= firstSecondPart.length() ? 0 : firstSecondPart.charAt(i) - '0';
      int s = i >= secondSecondPart.length() ? 0 : secondSecondPart.charAt(i) - '0';

      int sum = f + s + cary;

      cary = 0;
      if (sum >= 0 && sum <= 9) {
        sb.insert(0, sum);
      } else {
        sb.insert(0, sum % 10);
        cary = sum / 10;
      }
      i--;
    }

    sb.insert(0, ".");

    String firstFirstPart = first[0];
    String secondFirstPart = second[0];

    i = firstFirstPart.length() - 1;
    int j = secondFirstPart.length() - 1;

    while (i >= 0 || j >= 0) {
      int f = i >= 0 ? firstFirstPart.charAt(i) - '0' : 0;
      int s = j >= 0 ? secondFirstPart.charAt(j) - '0' : 0;

      int sum = f + s + cary;
      cary = 0;
      if (sum >= 0 && sum <= 9) {
        sb.insert(0, sum);
      } else {
        sb.insert(0, sum % 10);
        cary = sum / 10;
      }
      i--;
      j--;
    }

    return sb.toString();
  }

}
