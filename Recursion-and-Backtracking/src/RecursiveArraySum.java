import java.util.Arrays;
import java.util.Scanner;

public class RecursiveArraySum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
		System.out.println(recursive(nums, 0));
		
		sc.close();
	}

	static int recursive(int[] nums, int i) {
		if (i == nums.length - 1) {
			return nums[i];
		}

		return nums[i] + recursive(nums, i + 1);

	}
}
