import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CyclesInGraph {
	private static char parent;
	private static boolean isAcyclic = true;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Map<Character, List<Character>> graph = new HashMap<>();
		Set<Character> visited = new HashSet<>();

		String input = sc.nextLine();
		char firstNode = input.split("-")[0].charAt(0);

		while (!input.equals("End")) {
			char key = input.split("-")[0].charAt(0);
			char val = input.split("-")[1].charAt(0);

			if (graph.containsKey(key)) {
				graph.get(key).add(val);

			} else {
				ArrayList<Character> list = new ArrayList<>();
				list.add(val);

				graph.put(key, list);

				if (graph.containsKey(val)) {
					graph.get(val).add(key);
				}

				graph.put(val, graph.getOrDefault(val, new ArrayList<>(List.of(val))));
			}

			input = sc.nextLine();
		}
		parent = firstNode;

		dfs(graph, visited, firstNode);

		String result = isAcyclic ? "Acyclic: Yes" : "Acyclic: No";

		System.out.println(result);

		sc.close();
	}

	private static void dfs(Map<Character, List<Character>> graph, Set<Character> visited, char node) {
		visited.add(node);

		for (Character c : graph.get(node)) {
			if (visited.contains(c) && c != parent) {
				isAcyclic = false;
				return;

			} else if (c != parent) {
				parent = c;
				dfs(graph, visited, c);
			}
		}
	}
}
