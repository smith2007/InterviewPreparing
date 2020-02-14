package math;

public class BinaryStringOddEvenReducer {

	public static void main(String[] args) {
		String s = "011100"; //28

		System.out.println(distinct(s));
	}

	static int distinct(String binary) {

		if (binary == null) {
			return 0;
		}

		char[] chars = binary.toCharArray();
		int count = 0;
		int lastIndex = binary.length() - 1;

		while (lastIndex != 0) {
			if (chars[lastIndex] == '1') {
				chars[lastIndex] = '0';
			} else {
				lastIndex--;
			}
			count++;
		}

		return count - 1;

	}
}
