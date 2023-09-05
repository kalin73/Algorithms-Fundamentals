import java.util.Arrays;
import java.util.Scanner;

public class TheMatrix {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] dementions = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		char[][] matrix = new char[dementions[0]][dementions[1]];

		for (int i = 0; i < dementions[0]; i++) {
			matrix[i] = sc.nextLine().replaceAll(" ", "").toCharArray();
		}

		char target = sc.nextLine().charAt(0);

		int[] startCoords = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int startRow = startCoords[0];
		int startCol = startCoords[1];

		char startChar = matrix[startRow][startCol];

		draw(matrix, target, startRow, startCol, startChar);
		printResult(matrix);

		sc.close();
	}

	private static void draw(char[][] matrix, char target, int row, int col, char startChar) {
		if (isOutOfBounds(matrix, row, col) || matrix[row][col] != startChar) {
			return;
		}

		matrix[row][col] = target;

		draw(matrix, target, row, col + 1, startChar);
		draw(matrix, target, row + 1, col, startChar);
		draw(matrix, target, row, col - 1, startChar);
		draw(matrix, target, row - 1, col, startChar);
	}

	private static boolean isOutOfBounds(char[][] matrix, int row, int col) {
		return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
	}

	private static void printResult(char[][] matrix) {
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				System.out.print(matrix[row][col]);
			}
			System.out.println();
		}
	}

}
