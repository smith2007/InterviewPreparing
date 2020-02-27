package array;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {

	public static void main(String[] args) {

		int[][] a = new int[4][2];
	}

	static int[][] intervalIntersection(int[][] a, int[][] b) {

		if (a.length == 0 || b.length == 0) {
			return new int[0][0];
		}

		List<int[]> result = new ArrayList<>();

		int i = 0;
		int j = 0;

		while (i<a.length && j<b.length) {
			int[] first = a[i];
			int[] second = b[j];


			int[] intersection = new int[2];
			intersection[0] = Math.max(first[0], second[0]);
			intersection[1] = Math.min(first[1], second[1]);

			result.add(intersection);

			i++;
			j++;
		}

		int[][] res = new int[result.size()][2];

		for (int k = 0; k < result.size(); k++) {
			res[k][0] = result.get(k)[0];
			res[k][1] = result.get(k)[1];
		}

		return res;
	}
}
