import java.util.Scanner;

public class CombinationsWithoutRepetition {
	private static int[] combos;
	private static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = Integer.parseInt(sc.nextLine());
		int k = Integer.parseInt(sc.nextLine());

		combos = new int[k];

		combinations(0, 1);

		sc.close();
	}

	private static void combinations(int index, int start) {
		if (index == combos.length) {
			print();
			return;
		}
		for (int i = start; i <= n; i++) {
			combos[index] = i;
			combinations(index + 1, i + 1);

		}

	}

	private static void print() {
		for (int i = 0; i < combos.length; i++) {
			System.out.print(combos[i] + " ");
		}
		System.out.println();
	}

}
