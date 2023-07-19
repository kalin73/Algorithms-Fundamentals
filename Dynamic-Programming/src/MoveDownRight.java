import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MoveDownRight {
	private static List<StringBuilder> list = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int rows = Integer.parseInt(sc.nextLine());
		int cols = Integer.parseInt(sc.nextLine());

		int[][] arr = new int[rows][cols];

		for (int row = 0; row < rows; row++) {
			arr[row] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		int[][] dp = new int[rows][cols];

		dp[0][0] = arr[0][0];

		for (int col = 1; col < cols; col++) {
			dp[0][col] = dp[0][col - 1] + arr[0][col];
		}

		for (int row = 1; row < rows; row++) {
			dp[row][0] = dp[row - 1][0] + arr[row][0];

		}

		for (int row = 1; row < rows; row++) {
			for (int col = 1; col < cols; col++) {
				int top = dp[row - 1][col] + arr[row][col];
				int left = dp[row][col - 1] + arr[row][col];

				dp[row][col] = Math.max(top, left);
			}

		}
		findPath(dp);

		Collections.reverse(list);

		System.out.println(String.join(" ", list));

		sc.close();

	}

	private static void findPath(int[][] arr) {
		int row = arr.length - 1;
		int col = arr[row].length - 1;

		while (row > 0 || col > 0) {
			list.add(new StringBuilder("[" + row + ", " + col + "]"));

			int up = Integer.MIN_VALUE;
			int left = Integer.MIN_VALUE;

			if (row > 0) {
				up = arr[row - 1][col];
			}
			if (col > 0) {
				left = arr[row][col - 1];
			}

			if (up > left) {
				row--;
			} else {
				col--;
			}

		}
		list.add(new StringBuilder("[" + 0 + ", " + 0 + "]"));

	}
}
