import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int[] prev = new int[arr.length];
		int[] length = new int[arr.length];

		Arrays.fill(prev, -1);

		int maxLength = 0, maxIndex = -1;

		for (int i = 0; i < arr.length; i++) {
			int current = arr[i];
			int bestLength = 1;
			int bestIndex = -1;

			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] < current && length[j] + 1 >= bestLength) {
					bestLength = length[j] + 1;
					bestIndex = j;

				}
			}
			prev[i] = bestIndex;
			length[i] = bestLength;

			if (maxLength < bestLength) {
				maxLength = bestLength;
				maxIndex = i;
			}
		}
		List<Integer> lis = new ArrayList<>();

		int index = maxIndex;

		while (index != -1) {
			lis.add(arr[index]);
			index = prev[index];
		}

		for (int i = lis.size() - 1; i >= 0; i--) {
			System.out.print(lis.get(i) + " ");

		}

		sc.close();
	}

}
