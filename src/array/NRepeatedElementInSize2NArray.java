package array;

import java.util.HashSet;
import java.util.Set;

public class NRepeatedElementInSize2NArray {


	public static void main(String[] args) {
		int[] arr = {2, 1, 2, 5, 3, 2};
		System.out.println(repeatedNTimes(arr));
	}

	//простое решение через хешсет
	static int repeatedNTimes(int[] a) {

		Set<Integer> set = new HashSet<>();

		for (int elm : a) {
			if (set.contains(elm)){
				return elm;
			} else {
				set.add(elm);
			}
		}
		return -1;

	}
}
