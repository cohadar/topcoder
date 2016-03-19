import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class CliqueParty {

	static final int INF = Integer.MAX_VALUE / 2;

	public static boolean like(int[] A, int l, int r, int k) {
		if (l == r) {
			return true;
		}
		int min = INF;
		int max = -INF;
		for (int i = l; i <= r; i++) {
			for (int j = i + 1; j <= r; j++) {
				int d = Math.abs(A[i] - A[j]);
				min = Math.min(min, d);
				max = Math.max(max, d);
			}
		}
		return max <= k * min;
	}

	public static int maxsize(int[] A, int k) {
		Arrays.sort(A);
		int max = 1;
		for (int l = 0; l < A.length; l++) {
			for (int r = l; r < A.length; r++) {
				if (like(A, l, r, k)) {
					max = Math.max(max, r - l + 1);
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		debug(maxsize(new int[] {1,2,3}, 2));
		debug(maxsize(new int[] {1,2,3}, 1));
		debug(maxsize(new int[] {4,10,5,6}, 2));
		debug(maxsize(new int[] {1,2,3,4,5,6}, 3));
		debug(maxsize(new int[] {10,9,25,24,23,30}, 7));
	}

	static boolean DEBUG = true;
	
	static void debug(Object...os) {
		if (!DEBUG) { return; }
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}

}

