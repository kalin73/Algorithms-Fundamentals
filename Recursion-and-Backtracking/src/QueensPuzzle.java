import java.util.Scanner;

public class QueensPuzzle {
	private static char[][] chessBoard = { { '-', '-', '-', '-', '-', '-', '-', '-' },
			{ '-', '-', '-', '-', '-', '-', '-', '-' }, { '-', '-', '-', '-', '-', '-', '-', '-' },
			{ '-', '-', '-', '-', '-', '-', '-', '-' }, { '-', '-', '-', '-', '-', '-', '-', '-' },
			{ '-', '-', '-', '-', '-', '-', '-', '-' }, { '-', '-', '-', '-', '-', '-', '-', '-' },
			{ '-', '-', '-', '-', '-', '-', '-', '-' } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		findQueenPosition(0);

		sc.close();

	}

	private static void findQueenPosition(int row) {
		if (row == 8) {
			printSolution();
		} else {
			for (int col = 0; col < 8; col++) {
				if (canPlaceQueen(row, col)) {
					putQueen(row, col);

					findQueenPosition(row + 1);

					removeQueen(row, col);
				}
			}
		}
	}

	private static void putQueen(int row, int col) {
		if (canPlaceQueen(row, col)) {
			chessBoard[row][col] = '*';
		}

	}

	private static boolean canPlaceQueen(int row, int col) {
		for (int r = 0; r < 8; r++) {
			if (chessBoard[r][col] == '*') {
				return false;
			}
		}

		int r = row, c = col;

		while (r >= 0 && c >= 0) {
			if (chessBoard[r--][c--] == '*') {
				return false;
			}
		}

		r = row;
		c = col;

		while (r < 8 && c < 8) {
			if (chessBoard[r++][c++] == '*') {
				return false;
			}
		}

		r = row;
		c = col;

		while (r >= 0 && c < 8) {
			if (chessBoard[r--][c++] == '*') {
				return false;
			}
		}

		r = row;
		c = col;

		while (r < 8 && c >= 0) {
			if (chessBoard[r++][c--] == '*') {
				return false;
			}
		}
		return true;
	}

	private static void removeQueen(int row, int col) {
		chessBoard[row][col] = '-';
	}

	private static void printSolution() {
		for (int row = 0; row < chessBoard.length; row++) {
			for (int col = 0; col < chessBoard[row].length; col++) {
				System.out.print(chessBoard[row][col]+" ");
			}
			System.out.println();
		}

		System.out.println();

	}
}
