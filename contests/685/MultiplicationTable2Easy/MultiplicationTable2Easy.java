import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class MultiplicationTable2Easy {

	public static boolean contains(int[] A, int x) {
		for (int i = 0; i < A.length; i++) {
			if (x == A[i]) {
				return true;
			}
		}
		return false;
	}

	public static boolean isGoodSet(int[][] D, int[] A) {
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length; j++) {
				if (!contains(A, D[i][j])) {
					return false;
				}
			}
		}
		return true;
	}

	public static String isGoodSet(int[] T, int[] A) {
		int n = (int)Math.sqrt(T.length);
		int[][] D = new int[n][n];
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				D[y][x] = T[y * n + x];
			}
		}
		return (isGoodSet(D, A)) ? "Good" : "Not Good";
	}

	public static void main(String[] args) {
		
	}

	static boolean DEBUG = true;
	
	static void debug(Object...os) {
		if (!DEBUG) { return; }
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}

}

