import java.util.Scanner;

public class CombinationsWithRepetition {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] elements = sc.nextLine().split(" ");

		int k = Integer.parseInt(sc.nextLine());

		String[] slots = new String[k];

		combinations(elements, slots, 0, 0);

		sc.close();

	}

	private static void combinations(String[] elements, String[] slots, int index, int start) {
		if (index == slots.length) {
			print(slots);

		} else {
			for (int i = start; i < elements.length; i++) {
				slots[index] = elements[i];

				combinations(elements, slots, index + 1, i);
			}

		}

	}

	private static void print(String[] permutes) {
		System.out.println(String.join(" ", permutes));

	}
}
