import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int n = Integer.parseInt(sc.nextLine());

		System.out.println(find(arr, n));

		sc.close();
	}

	private static int find(int[] arr, int n) {
		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			int middleIndex = (right + left) / 2;
			int middleNumber = arr[middleIndex];

			if (middleNumber > n) {
				right = middleIndex - 1;

			} else if (middleNumber < n) {
				left = middleIndex + 1;

			} else {
				return middleIndex;
			}

		}

		return -1;
	}

}
