import java.util.Scanner;

public class ReverseArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] elements = sc.nextLine().split(" ");

		reverse(elements, 0);

		String reversedList = String.join(" ", elements);

		System.out.println(reversedList);

		sc.close();
	}

	private static void reverse(String[] elements, int index) {
		if (index == elements.length / 2) {
			return;
		}
		swap(elements, index, elements.length - 1 - index);

		reverse(elements, index + 1);
	}

	private static void swap(String[] elements, int index1, int index2) {
		String temp = elements[index1];
		elements[index1] = elements[index2];
		elements[index2] = temp;

	}
}
