import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReverseArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<Integer> list = Arrays
				.stream(sc.nextLine().split(" "))
				.map(Integer::parseInt)
				.collect(Collectors.toList());

		reverse(list, 0);
		
		String reversedList = list
				.stream()
				.map(String::valueOf)
				.collect(Collectors.joining(" "));

		System.out.println(reversedList);
		
		sc.close();
	}

	private static void reverse(List<Integer> list, int index) {
		if (index == list.size() / 2) {
			return;
		}
		swap(list, index, list.size() - 1 - index);

		reverse(list, index + 1);
	}

	private static void swap(List<Integer> list, int index1, int index2) {
		int temp = list.get(index1);
		list.set(index1, list.get(index2));
		list.set(index2, temp);

	}
}
