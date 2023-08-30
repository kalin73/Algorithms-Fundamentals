package topologicalSorting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
	public static void main(String[] args) {

	}

	public static Collection<String> topSort(Map<String, List<String>> graph) {
		Map<String, Integer> dependenciesCount = getDependenciesCount(graph);
		List<String> sorted = new ArrayList<>();

		while (!graph.isEmpty()) {
			String key = graph.keySet().stream().filter(k -> dependenciesCount.get(k) == 0).findFirst().orElse(null);

			if (key == null)
				break;

			for (String child : graph.get(key)) {
				dependenciesCount.put(child, dependenciesCount.get(child) - 1);
			}

			sorted.add(key);
			graph.remove(key);
		}

		if (!graph.isEmpty())
			throw new IllegalArgumentException();

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
