import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SumOfCoins {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String[] elements = in.nextLine().substring(7).split(", ");
		int[] coins = new int[elements.length];
		for (int i = 0; i < coins.length; i++) {
			coins[i] = Integer.parseInt(elements[i]);
		}

		int targetSum = Integer.parseInt(in.nextLine().substring(5));

		Map<Integer, Integer> usedCoins = chooseCoins(coins, targetSum);

		for (Map.Entry<Integer, Integer> usedCoin : usedCoins.entrySet()) {
			System.out.println(usedCoin.getKey() + " -> " + usedCoin.getValue());
		}

		in.close();
	}

	public static Map<Integer, Integer> chooseCoins(int[] coins, int targetSum) {
		Map<Integer, Integer> usedCoins = new LinkedHashMap<>();
		coins = Arrays.stream(coins).boxed().sorted(Comparator.reverseOrder()).mapToInt(x -> x).toArray();
		int index = 0;

		while (targetSum > 0) {
			int coin = coins[index++];
			int count = targetSum / coin;

			if (count == 0) {
				continue;
			}

			targetSum %= coin;

			usedCoins.put(coin, count);
		}

		return usedCoins;
	}
}