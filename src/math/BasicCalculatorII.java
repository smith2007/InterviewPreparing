package math;

public class BasicCalculatorII {

  public static void main(String[] args) {
    System.out.println(calculate("5-2*3-4"));

    //System.out.println(calculate("100000000/1/2/3/4/5/6/7/8/9/10"));
  }


  static int calculate(String str) {
    if (str == null) {
      return 0;
    }
    str = str.trim().replaceAll(" +", "");
    int length = str.length();

    int res = 0;
    long preVal = 0; // initial preVal is 0
    char sign = '+'; // initial sign is +
    int i = 0;
    while (i < length) {
      long curVal = 0;
      while (i < length && (int) str.charAt(i) <= 57 && (int) str.charAt(i) >= 48) { // int
        curVal = curVal * 10 + (str.charAt(i) - '0');
        i++;
      }
      if (sign == '+') {
        res += preVal;  // update res
        preVal = curVal;
      } else if (sign == '-') {
        res += preVal;  // update res
        preVal = -curVal;
      } else if (sign == '*') {
        preVal = preVal * curVal; // not update res, combine preVal & curVal and keep loop
      } else if (sign == '/') {
        preVal = preVal / curVal; // not update res, combine preVal & curVal and keep loop
      }
      if (i < length) { // getting new sign
        sign = str.charAt(i);
        i++;
      }
    }
    res += preVal;
    return res;
  }

}
