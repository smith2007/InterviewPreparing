package matrix;

public class RotateImage {

	public static void main(String[] args) {
		int[][] matrix = {{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}};

		rotate(matrix);

	}

	static void rotate(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i; j < matrix[0].length; j++) {
				int tmp = matrix[j][i];
				matrix[j][i] = matrix[i][j];
				matrix[i][j] = tmp;
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

		// reverse each row
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length / 2; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[i][matrix[0].length - j - 1];
				matrix[i][matrix[0].length - j - 1] = tmp;
			}
		}
	}

}
