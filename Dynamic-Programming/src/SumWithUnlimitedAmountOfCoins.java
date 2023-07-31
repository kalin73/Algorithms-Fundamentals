import java.util.Arrays;
import java.util.Scanner;

public class SumWithUnlimitedAmountOfCoins {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] coins = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int targetSum = Integer.parseInt(sc.nextLine());

		int[] dp = new int[targetSum + 1];
		dp[0] = 1;

		for (int i = 0; i < coins.length; i++) {
			for (int j = coins[i]; j <= targetSum; j++) {
				dp[j] += dp[j - coins[i]];
			}
		}
		System.out.println(dp[targetSum]);
		
		sc.close();
	}

}
