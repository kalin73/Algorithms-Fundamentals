import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TowerOfHanoi {
	private static StringBuilder result = new StringBuilder();
	private static ArrayDeque<Integer> source = new ArrayDeque<>();
	private static ArrayDeque<Integer> spare = new ArrayDeque<>();
	private static ArrayDeque<Integer> destination = new ArrayDeque<>();
	private static int steps = 1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = Integer.parseInt(sc.nextLine());

		for (int i = n; i >= 1; i--) {
			source.push(i);
		}

		print();

		solve(n, source, destination, spare);

		System.out.println(result);

		sc.close();
	}

	private static void solve(int n, ArrayDeque<Integer> source, ArrayDeque<Integer> destination,
			ArrayDeque<Integer> spare) {
		if (n == 1) {
			destination.push(source.pop());
			result.append("Step #").append(steps++).append(": Moved disk").append(System.lineSeparator());

			print();

			return;
		}

		solve(n - 1, source, spare, destination);
		solve(1, source, destination, spare);
		solve(n - 1, spare, destination, source);

	}

	public static void print() {
		result.append(String.format("Source: %s%nDestination: %s%nSpare: %s%n", formatRod(source),
				formatRod(destination), formatRod(spare))).append(System.lineSeparator());
	}

	private static String formatRod(ArrayDeque<Integer> stack) {
		return stack.stream().sorted(Comparator.reverseOrder()).map(String::valueOf).collect(Collectors.joining(", "));
	}

}
