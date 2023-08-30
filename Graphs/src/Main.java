import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());

		List<List<Integer>> graph = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String nextLine = sc.nextLine();

			if (nextLine.trim().equals("")) {
				graph.add(new ArrayList<>());

			} else {
				graph.add(Arrays.stream(nextLine.split(" ")).map(Integer::parseInt).collect(Collectors.toList()));
			}
		}

		List<Deque<Integer>> connectedComponents = getConnectedComponents(graph);

		for (Deque<Integer> deque : connectedComponents) {
			System.out.print("Connected component: ");

			for (int i : deque) {
				System.out.print(i + " ");
			}
			System.out.println();
		}

		sc.close();

	}

	public static List<Deque<Integer>> getConnectedComponents(List<List<Integer>> graph) {
		boolean[] visited = new boolean[graph.size()];
		List<Deque<Integer>> componenets = new ArrayList<>();

		for (int i = 0; i < graph.size(); i++) {
			if (!visited[i]) {
				componenets.add(new ArrayDeque<>());

				dfs(i, graph, componenets, visited);
			}
		}

		return componenets;
	}

	private static void dfs(int node, List<List<Integer>> graph, List<Deque<Integer>> componenets, boolean[] visited) {
		if (!visited[node]) {
			visited[node] = true;

			for (int child : graph.get(node)) {
				dfs(child, graph, componenets, visited);
			}

			componenets.get(componenets.size() - 1).offer(node);
		}

	}

	public static Collection<String> topSort(Map<String, List<String>> graph) {
		Map<String, Integer> dependenciesCount = getDependenciesCount(graph);
		List<String> sorted = new ArrayList<>();

		while (!graph.isEmpty()) {
			String key = graph.keySet().stream().filter(k -> dependenciesCount.get(k) == 0).findFirst().orElse(null);

			if (key == null) break;

			for (String child : graph.get(key)) {
				dependenciesCount.put(child, dependenciesCount.get(child) - 1);
			}

			sorted.add(key);
			graph.remove(key);
		}
		
		if(!graph.isEmpty()) throw new IllegalArgumentException();
		
		
		return sorted;

	}

	private static Map<String, Integer> getDependenciesCount(Map<String, List<String>> graph) {
		Map<String, Integer> dependenciesCount = new LinkedHashMap<>();

		for (Map.Entry<String, List<String>> node : graph.entrySet()) {
			dependenciesCount.putIfAbsent(node.getKey(), 0);

			for (String child : node.getValue()) {
				dependenciesCount.put(child, dependenciesCount.getOrDefault(child, 0) + 1);
			}

		}

		return dependenciesCount;
	}
}
