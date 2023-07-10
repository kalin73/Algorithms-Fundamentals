import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SchoolTeams {
	public static String[] boys;
	public static String[] girls;

	public static List<String> allGirls = new ArrayList<>();

	public static List<String> allBoys = new ArrayList<>();

	public static String[] boysCombinations = new String[2];
	public static String[] girlsCombinations = new String[3];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		girls = sc.nextLine().split(", ");
		boys = sc.nextLine().split(", ");

		combineGirls(0, 0);

		combineBoys(0, 0);

		for (String girl : allGirls) {
			for (String boy : allBoys) {
				System.out.println(girl + ", " + boy);
			}
		}

		sc.close();

	}

	private static void combineGirls(int index, int start) {
		combine(index, start, girls, girlsCombinations, allGirls);

	}

	private static void combineBoys(int index, int start) {
		combine(index, start, boys, boysCombinations, allBoys);
	}

	private static void combine(int index, int start, String[] kids, String[] combinations, List<String> result) {
		if (index == combinations.length) {
			result.add(String.join(", ", combinations));

			return;
		}

		for (int i = start; i < kids.length; i++) {
			combinations[index] = kids[i];
			combine(index + 1, i + 1, kids, combinations, result);

		}
	}
}
