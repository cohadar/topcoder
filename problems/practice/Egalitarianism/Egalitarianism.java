import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class Egalitarianism {

	static final int INF = Integer.MAX_VALUE / 2;

	public static int[][] distanceMatrix(int n, String[] isFriend) {
		int[][] D = new int[n][n];
		for (int y = 0; y < n; y++) {
			Arrays.fill(D[y], INF);
		}
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				if (y == x) {
					D[y][x] = 0;
				} else if (isFriend[y].charAt(x) == 'Y') {
					D[y][x] = 1;
				}
			}
		}
		return D;
	}

	public static int maxDifference(String[] isFriend, int d) {
		int n = isFriend.length;
		int[][] D = distanceMatrix(n, isFriend);
		for (int m = 0; m < n; m++) {
			for (int a = 0; a < n; a++) {
				for (int b = 0; b < n; b++) {
					D[a][b] = Math.min(D[a][b], D[a][m] + D[m][b]);
				}
			}
		}
		int max = -INF;
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				max = Math.max(max, D[y][x]);
			}
		}
		if (max == INF) {
			return -1;
		}
		return max * d;
	}

	public static void main(String[] args) {
		debug(maxDifference(new String[]{"NYN", "YNY", "NYN"}, 10));
		debug(maxDifference(new String[]{"NN", "NN"}, 1));
		debug(maxDifference(new String[]{"NNYNNN", "NNYNNN", "YYNYNN", "NNYNYY", "NNNYNN", "NNNYNN"}, 1000));
		debug(maxDifference(new String[]{"NNYN", "NNNY", "YNNN", "NYNN"}, 584));
		debug(maxDifference(new String[]{"NYNYYYN", "YNNYYYN", "NNNNYNN", "YYNNYYN", "YYYYNNN", "YYNYNNY", "NNNNNYN"}, 5));
		debug(maxDifference(new String[]{"NYYNNNNYYYYNNNN", "YNNNYNNNNNNYYNN", "YNNYNYNNNNYNNNN", "NNYNNYNNNNNNNNN", "NYNNNNYNNYNNNNN", "NNYYNNYNNYNNNYN", "NNNNYYNNYNNNNNN", "YNNNNNNNNNYNNNN", "YNNNNNYNNNNNYNN", "YNNNYYNNNNNNNNY", "YNYNNNNYNNNNNNN", "NYNNNNNNNNNNNNY", "NYNNNNNNYNNNNYN", "NNNNNYNNNNNNYNN", "NNNNNNNNNYNYNNN"} , 747));
		debug(maxDifference(new String[]{"NY", "YN"}, 0));
	}

	static boolean DEBUG = true;
	
	static void debug(Object...os) {
		if (!DEBUG) { return; }
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}

}

