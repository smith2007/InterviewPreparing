package math;

public class AddDigits {

  public static void main(String[] args) {

    System.out.println(addDigits(38));
  }

  static int addDigits(int num) {
    while (num > 9) {
      int localSum = 0;
      while (num > 9) {
        localSum += num % 10;
        num /= 10;
      }
      localSum+=num;
      num = localSum;
    }
    return num;
  }

}
