import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Cinema {
	private static String[] seats;
	private static String[] combinations;
	private static boolean[] used;
	private static List<String> people;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		people = Arrays.stream(sc.nextLine().split(", ")).collect(Collectors.toList());

		seats = new String[people.size()];

		String command = sc.nextLine();

		while (!command.equals("generate")) {
			String[] tokens = command.split(" - ");

			String name = tokens[0];
			int position = Integer.parseInt(tokens[1]) - 1;

			seats[position] = name;

			people.remove(name);

			command = sc.nextLine();
		}
		combinations = new String[people.size()];
		used = new boolean[people.size()];

		permute(0);

		System.out.print(sb);

		sc.close();

	}

	private static void permute(int index) {
		if (index == combinations.length) {
			print();

			return;
		}

		for (int i = 0; i < people.size(); i++) {
			if (!used[i]) {
				combinations[index] = people.get(i);

				used[i] = true;
				permute(index + 1);
				used[i] = false;

			}
		}

	}

	private static void print() {
		int index = 0;

		String[] result = new String[seats.length];

		for (int i = 0; i < seats.length; i++) {
			if (seats[i] != null) {
				result[i] = seats[i];

			} else {
				result[i] = combinations[index++];
			}
		}
		sb.append(String.join(" ", result)).append(System.lineSeparator());
	}
}
