import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CombinationsWithRepetition {

	private static int[] elements;
	private static int n;
	private static int k;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(reader.readLine());
		k = Integer.parseInt(reader.readLine());
		elements = new int[k];

		combinations(0, 1);

		reader.close();

	}

	private static void combinations(int index, int start) {
		if (index == elements.length) {
			print();
			return;
		}

		for (int i = start; i <= n; i++) {
			elements[index] = i;
			combinations(index + 1, i);
		}

	}

	private static void print() {
		for (int i = 0; i < elements.length; i++) {
			System.out.print(elements[i] + " ");
		}
		System.out.println();

	}

}
