import java.util.Scanner;

public class RecursiveDrawing {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = Integer.parseInt(sc.nextLine());

		draw(n);

		sc.close();
	}

	private static void draw(int n) {
		if (n == 0) {
			return;
		}

		drawLine(n, '*');

		draw(n - 1);

		drawLine(n, '#');

	}

	private static void drawLine(int n, char symbol) {
		for (int i = 0; i < n; i++) {
			System.out.print(symbol);
		}
		System.out.println();
	}

}
