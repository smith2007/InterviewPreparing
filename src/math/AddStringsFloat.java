package math;

public class AddStringsFloat {

  public static void main(String[] args) {
    System.out.println(addStrings("3.14", "0.9"));
  }

  static String addStrings(String b1, String b2) {

    StringBuilder sb = new StringBuilder();
    int i = b1.length() - 1;
    int j = b2.length() - 1;
    int carry = 0;

    int b1DecPoint = Math.abs(b1.indexOf('.') - i - 1);
    int b2DecPoint = Math.abs(b2.indexOf('.') - j - 1);

    while (i >= 0 || j >= 0) {
      int sum = carry;

      if (b1.charAt(i) == '.' && b2.charAt(j) == '.') {
        sb.insert(0, '.');
        i--;
        j--;
      } else {
        if (i >= 0 && b1DecPoint >= b2DecPoint) {
          sum += b1.charAt(i--) - '0';
        }

        if (j >= 0 && b2DecPoint >= b1DecPoint) {
          sum += b2.charAt(j--) - '0';
        }

        if (b1DecPoint > b2DecPoint) {
          b1DecPoint--;
        }
        if (b2DecPoint > b1DecPoint) {
          b2DecPoint--;
        }

        sb.insert(0, sum % 10);
        carry = sum / 10;
      }
    }

    if (carry > 0) {
      sb.insert(0, carry);
    }

    return sb.toString();
  }

}
