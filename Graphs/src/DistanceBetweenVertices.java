import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class DistanceBetweenVertices {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<Integer, List<Integer>> graph = new HashMap<>();

		int nodes = Integer.parseInt(sc.nextLine());
		int pairs = Integer.parseInt(sc.nextLine());

		for (int i = 0; i < nodes; i++) {
			String[] input = sc.nextLine().split(":");
			int key = Integer.parseInt(input[0]);

			if (input.length > 1) {
				List<Integer> children = Arrays.stream(input[1].split(" ")).map(Integer::parseInt)
						.collect(Collectors.toList());

				graph.put(key, children);

			} else {
				graph.put(key, new ArrayList<>());
			}
		}

		for (int i = 0; i < pairs; i++) {
			int[] pair = Arrays.stream(sc.nextLine().split("-")).mapToInt(Integer::parseInt).toArray();

			findDistance(graph, pair[0], pair[1]);
		}

		sc.close();
	}

	private static void findDistance(Map<Integer, List<Integer>> graph, int start, int end) {
		Map<Integer, Integer> paths = new HashMap<>();

		Set<Integer> visited = new HashSet<>();

		ArrayDeque<Integer> queue = new ArrayDeque<>();
		queue.offer(start);
		int parent = -1;

		visited.add(start);
		paths.put(start, parent);

		while (!queue.isEmpty()) {
			parent = queue.poll();

			for (Integer child : graph.get(parent)) {
				if (!visited.contains(child)) {
					paths.put(child, parent);
					queue.offer(child);
					visited.add(child);

					if (child == end) {
						break;
					}
				}
			}
		}
		printResult(paths, start, end);
	}

	private static void printResult(Map<Integer, Integer> paths, int start, int end) {
		int counter = 0;
		int parent = paths.containsKey(end) ? paths.get(end) : -1;

		while (parent != -1) {
			counter++;
			parent = paths.get(parent);
		}

		counter = counter == 0 ? -1 : counter;
		String result = String.format("{%d, %d} -> %d", start, end, counter);

		System.out.println(result);
	}

}
