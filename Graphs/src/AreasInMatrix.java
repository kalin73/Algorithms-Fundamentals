import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AreasInMatrix {
	private static boolean[][] visited;
	private static int areasCount = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		Map<Character, Integer> areas = new TreeMap<>();

		char[][] matrix = new char[n][n];
		visited = new boolean[n][0];

		for (int i = 0; i < n; i++) {
			char[] input = sc.nextLine().toCharArray();

			matrix[i] = input;
			visited[i] = new boolean[input.length];
		}

		for (int row = 0; row < n; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				if (!visited[row][col]) {
					char curr = matrix[row][col];

					findAreas(matrix, curr, row, col);
					areas.put(curr, areas.getOrDefault(curr, 0) + 1);
					areasCount++;
				}
			}
		}
		System.out.println("Areas: " + areasCount);
		areas.forEach((k, v) -> System.out.printf("Letter '%s' -> %d%n", k, v));

		sc.close();

	}

	private static void findAreas(char[][] matrix, char c, int row, int col) {
		if (isOutOfBounds(matrix, row, col) || visited[row][col] || matrix[row][col] != c) {
			return;
		}
		visited[row][col] = true;

		findAreas(matrix, c, row, col + 1);
		findAreas(matrix, c, row + 1, col);
		findAreas(matrix, c, row, col - 1);
		findAreas(matrix, c, row - 1, col);
	}

	private static boolean isOutOfBounds(char[][] matrix, int row, int col) {
		return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
	}
}
