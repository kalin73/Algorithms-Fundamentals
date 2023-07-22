import java.util.Arrays;
import java.util.Scanner;

public class Quicksort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		quickSort(arr, 0, arr.length - 1);

		for (int i : arr) {
			System.out.print(i + " ");
		}
		
		sc.close();
	}

	private static void quickSort(int[] arr, int start, int end) {
		if (start >= end) {
			return;
		}

		int pivot = arr[end];

		int left = start;
		int right = end;

		while (left < right) {
			while (arr[left] <= pivot && left < right) {
				left++;
			}

			while (arr[right] >= pivot && left < right) {
				right--;
			}

			swap(arr, left, right);
		}
		swap(arr, left, end);

		quickSort(arr, start, left - 1);
		quickSort(arr, left + 1, end);
	}

	private static void swap(int[] arr, int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
}
