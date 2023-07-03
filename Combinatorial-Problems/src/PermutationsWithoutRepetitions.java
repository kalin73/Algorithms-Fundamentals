import java.util.Scanner;

public class PermutationsWithoutRepetitions {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] elements = sc.nextLine().split(" ");
		String[] permutes = new String[elements.length];
		boolean[] used = new boolean[elements.length];

		permute(elements, permutes, used, 0);

		sc.close();

	}

	private static void permute(String[] elements, String[] permutes, boolean[] used, int index) {
		if (index == elements.length) {
			print(permutes);
			return;
		}

		for (int i = 0; i < elements.length; i++) {
			if (!used[i]) {
				used[i] = true;

				permutes[index] = elements[i];
				permute(elements, permutes, used, index + 1);

				used[i] = false;
			}
		}

	}

	private static void print(String[] permutes) {
		System.out.println(String.join(" ", permutes));

	}

}
