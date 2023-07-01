import java.util.Scanner;

public class GeneratingVectors {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = Integer.parseInt(sc.nextLine());

		Integer[] memory = new Integer[n];

		fillVector(memory, 0);

		sc.close();
	}

	private static void fillVector(Integer[] memory, int index) {
		if (index >= memory.length) {
			print(memory);
			return;
		}
		for (int i = 0; i <= 1; i++) {
			memory[index] = i;
			fillVector(memory, index + 1);
		}

	}

	private static void print(Integer[] memory) {
		for (Integer num : memory) {
			System.out.print(num);
		}
		System.out.println();

	}

}
