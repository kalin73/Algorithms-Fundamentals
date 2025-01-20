import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Salaries {
	private static List<List<Integer>> graph = new ArrayList<>();
	private static long[] salaries;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int employees = Integer.parseInt(sc.nextLine());

		salaries = new long[employees];

		int[] managersCount = new int[employees];

		for (int i = 0; i < employees; i++) {
			graph.add(new ArrayList<>());

			String line = sc.nextLine();

			for (int emp = 0; emp < line.length(); emp++) {
				char letter = line.charAt(emp);

				if (letter == 'Y') {
					managersCount[emp]++;
					graph.get(i).add(emp);
				}
			}
		}

		List<Integer> sources = new ArrayList<>();

		for (int i = 0; i < managersCount.length; i++) {
			if (managersCount[i] == 0) {
				sources.add(i);
			}
		}

		sources.forEach(source -> dfs(source));

		long sum = Arrays.stream(salaries).sum();

		System.out.println(sum);

		sc.close();
	}

	private static void dfs(int node) {
		if (graph.get(node).isEmpty()) {
			salaries[node] = 1;
			return;
		}

		for (Integer child : graph.get(node)) {
			if (salaries[child] == 0) {
				dfs(child);
			}
			salaries[node] += salaries[child];
		}
	}

}
