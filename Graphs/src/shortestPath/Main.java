package shortestPath;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
	private static boolean[] visited;
	private static int[] prevNodes;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = Integer.parseInt(sc.nextLine());

		List<List<Integer>> graph = new ArrayList<>();

		for (int i = 0; i < n + 1; i++) {
			graph.add(new ArrayList<>());
		}

		int edges = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < edges; i++) {
			int[] paths = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			graph.get(paths[0]).add(paths[1]);
		}

		int source = Integer.parseInt(sc.nextLine());
		int destination = Integer.parseInt(sc.nextLine());

		visited = new boolean[n + 1];
		prevNodes = new int[n + 1];

		Arrays.fill(prevNodes, -1);

		bfs(graph, source, destination);

		List<Integer> path = new ArrayList<>();

		path.add(destination);

		int prevNode = prevNodes[destination];

		while (prevNode != -1) {
			path.add(prevNode);

			prevNode = prevNodes[prevNode];
		}
		System.out.println("Shortest path length is: " + (path.size() - 1));

		for (int i = path.size() - 1; i >= 0; i--) {
			System.out.print(path.get(i) + " ");
		}

		sc.close();
	}

	private static void bfs(List<List<Integer>> graph, int source, int destination) {
		ArrayDeque<Integer> queue = new ArrayDeque<>();

		queue.offer(source);
		visited[source] = true;

		while (!queue.isEmpty()) {
			int node = queue.poll();

			if (node == destination) {
				return;
			}

			for (int child : graph.get(node)) {
				if (!visited[child]) {
					visited[child] = true;
					prevNodes[child] = node;

					queue.offer(child);
				}
			}
		}

	}

	public static Collection<String> topSort(Map<String, List<String>> graph) {
		Set<String> visited = new HashSet<>();
		Set<String> detectCycles = new HashSet<>();

		List<String> sorted = new ArrayList<>();

		for (Map.Entry<String, List<String>> node : graph.entrySet()) {
			dfs(node.getKey(), visited, graph, sorted, detectCycles);

		}

		Collections.reverse(sorted);

		return sorted;

	}

	private static void dfs(String key, Set<String> visited, Map<String, List<String>> graph, List<String> sorted,
			Set<String> detectCycles) {
		if (detectCycles.contains(key)) {
			throw new IllegalArgumentException();
		}

		if (!visited.contains(key)) {
			visited.add(key);
			detectCycles.add(key);

			for (String child : graph.get(key)) {
				dfs(child, visited, graph, sorted, detectCycles);

			}

			detectCycles.remove(key);
			sorted.add(key);
		}
	}
}
