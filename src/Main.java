public class Main {

	public static int[] w = //
	{ 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };

	public static String[] r = //
	{ "1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2" };

	public static int[] id17 = //
	{ 1, 3, 1, 1, 2, 7, 1, 9, 8, 6, 1, 0, 0, 3, 4, 4, 3 };

	public static void main(String[] args) {
		int total = 0;
		for (int i = 0; i < id17.length; i++) {
			total += (w[i] * id17[i]);
		}
		int mod = total % 11;
		System.out.println(r[mod]);
	}

}
