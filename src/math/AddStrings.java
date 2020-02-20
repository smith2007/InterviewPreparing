package math;

public class AddStrings {

	public static void main(String[] args) {


		System.out.println(addStrings("179", "79"));
	}

	static String addStrings(String num1, String num2) {

		if (num1 == null || num2 == null) {
			return "";
		}

		int i = num1.length() - 1;
		int j = num2.length() - 1;

		int cary = 0;

		StringBuilder sb = new StringBuilder();
		while (i >= 0 || j >= 0 || cary != 0) {
			int c1 = i >= 0 ? num1.charAt(i) - '0' : 0;
			int c2 = j >= 0 ? num2.charAt(j) - '0' : 0;
			int sum = c1 + c2 + cary;
			if (sum % 10 == sum) {
				sb.append(sum);
				cary = 0;
			} else {
				sb.append(sum % 10);
				cary = sum / 10;
			}
			i--;
			j--;
		}
		return sb.reverse().toString();
	}
}
