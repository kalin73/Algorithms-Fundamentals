import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FindAllPathsInALabyrinth {
	private static List<Character> path = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int rows = Integer.parseInt(sc.nextLine());
		int cols = Integer.parseInt(sc.nextLine());

		char[][] labyrinth = new char[rows][cols];

		for (int row = 0; row < rows; row++) {
			labyrinth[row] = sc.nextLine().toCharArray();
		}

		findPath(labyrinth, 0, 0, ' ');
		
		sc.close();

	}

	private static void findPath(char[][] labyrinth, int row, int col, char direction) {
		if (!isInBounds(labyrinth, row, col) || labyrinth[row][col] == 'V' || labyrinth[row][col] == '*') {
			return;
		}
		
		path.add(direction);

		if (labyrinth[row][col] == 'e') {
			printPath();
			path.remove(path.size() - 1);
			return;
		}
		
		labyrinth[row][col] = 'V';

		findPath(labyrinth, row, col + 1, 'R');
		findPath(labyrinth, row + 1, col, 'D');
		findPath(labyrinth, row - 1, col, 'U');
		findPath(labyrinth, row, col - 1, 'L');

		labyrinth[row][col] = '-';
		path.remove(path.size() - 1);
	}

	private static void printPath() {
		String result = path.stream().map(String::valueOf).collect(Collectors.joining("")).trim();

		System.out.println(result);
	}

	private static boolean isInBounds(char[][] labyrinth, int row, int col) {
		return row < labyrinth.length && row >= 0 && col < labyrinth[row].length && col >= 0;
	}
}
