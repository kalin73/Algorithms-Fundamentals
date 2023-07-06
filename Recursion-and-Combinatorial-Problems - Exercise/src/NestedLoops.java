import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class NestedLoops {
	private static StringBuilder result = new StringBuilder();
	private static int[] elements;
	private static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(reader.readLine());
		elements = new int[n];

		permute(0);

		System.out.println(result);

		reader.close();

	}

	private static void permute(int index) {
		if (index == elements.length) {
			print();

			return;
		}

		for (int i = 1; i <= n; i++) {
			elements[index] = i;
			permute(index + 1);
		}

	}

	private static void print() {
		result.append(Arrays.stream(elements).mapToObj(String::valueOf).collect(Collectors.joining(" ")));

		result.append(System.lineSeparator());
	}

}
