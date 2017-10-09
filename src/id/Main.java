package id;

//  110184200606308769 暴雪

public class Main {

	static int[] xishu = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };

//	static int[] sf17 = { 1, 3, 1, 1, 2, 7, 1, 9, 8, 6, 0, 2, 0, 1, 0, 0, 1 };
	
//	static int[] sf17 = { 1, 3, 0, 6, 8, 4, 2, 0, 1, 6, 0, 6, 3, 0, 0, 0, 6 };
	
	static int[] sf17 = { 1, 1, 0, 1, 8, 4, 1, 9, 8, 6, 0, 6, 3, 0, 0, 0, 5 };

	static int[] zh = { 1, 0, -1, 9, 8, 7, 6, 5, 4, 3, 2 };

	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 1; k < 10; k = k + 2) {

					String str = "";
					int sum = 0;
					for (int p = 0; p < 17; p++) {
						sum += sf17[p] * xishu[p];
						str += sf17[p];
					}

					int ys = sum % 11;

					int z = zh[ys];

					// if (z == -1) {
					// str += "X";
					// } else {
					// str += z;
					// System.out.println(str);
					// }
					
					str += z;
					System.out.println(str);

					
				}
			}
		}

	}

}
