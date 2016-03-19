import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class CoinFlipsDiv2 {

	public static int countCoins(String state) {
		char[] C = state.toCharArray();
		int count = 0;
		for (int i = 0; i < C.length; i++) {
			if ((i > 0 && C[i] != C[i - 1]) || (i < C.length - 1 && C[i] != C[i + 1])) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(countCoins(scanner.nextLine()));
	}

}

