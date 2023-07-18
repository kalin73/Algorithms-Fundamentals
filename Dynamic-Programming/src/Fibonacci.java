import java.util.Scanner;

public class Fibonacci {
	private static long[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());

		dp = new long[n + 1];

		System.out.println(fib(n));

		sc.close();
	}

	private static long fib(int n) {
		if (n <= 2) {
			return 1;
		}

		if (dp[n] != 0) {
			return dp[n];
		}

		return dp[n] = fib(n - 1) + fib(n - 2);
		
	}

}
