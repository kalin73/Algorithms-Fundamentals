import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		sort(arr);

		StringBuilder result = new StringBuilder();

		for (int i : arr) {
			result.append(i).append(" ");
		}

		System.out.println(result);

		sc.close();
	}

	private static void sort(int[] arr) {
		mergeSort(arr, 0, arr.length - 1);

	}

	private static void mergeSort(int[] arr, int begin, int end) {
		if (begin >= end) {
			return;
		}

		int mid = (begin + end) / 2;

		mergeSort(arr, begin, mid);
		mergeSort(arr, mid + 1, end);

		merge(arr, begin, mid, end);

	}

	private static void merge(int[] arr, int begin, int mid, int end) {
		if (mid < 0 || mid >= arr.length || arr[mid] < arr[mid + 1]) {
			return;
		}
		int left = begin;
		int right = mid + 1;

		int[] helper = new int[end + 1];

		for (int i = begin; i <= end; i++) {
			helper[i] = arr[i];
		}

		for (int i = begin; i <= end; i++) {

			if (left > mid) {
				arr[i] = helper[right++];

			} else if (right > end) {
				arr[i] = helper[left++];

			} else if (helper[left] < helper[right]) {
				arr[i] = helper[left++];

			} else {
				arr[i] = helper[right++];

			}
		}
	}

}
