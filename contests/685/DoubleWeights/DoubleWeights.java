import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class DoubleWeights {

	static final int INF = 10000;

	public static int[][] transform(String[] W) {
		int n = W.length;
		int[][] D = new int[n][n];
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				if (W[y].charAt(x) != '.') {
					D[y][x] = W[y].charAt(x) - '0';				
				}
			}
		}
		return D;
	}


	public static void floydWarshallMul(int n, int[][] P, int[][] S1, int[][] S2) {
		for (int m = 0; m < n; m++) {
			for (int a = 0; a < n; a++) {
				for (int b = 0; b < n; b++) {
					int temp = (S1[a][m] + S1[m][b]) * (S2[a][m] + S2[m][b]);
					if (P[a][b] > temp) {
						P[a][b] = temp;
						S1[a][b] = S1[a][m] + S1[m][b];
						S2[a][b] = S2[a][m] + S2[m][b];
					}
				}
			}
		}
	}

	public static int minimalCost(int n, int[][] A1, int[][] A2) {
		int[][] P = new int[n][n];
		int[][] S1 = new int[n][n];
		int[][] S2 = new int[n][n];
		for (int y = 0; y < n; y++) {
			Arrays.fill(P[y], INF);
			P[y][y] = 0;
			Arrays.fill(S1[y], INF);
			S1[y][y] = 0;
			Arrays.fill(S2[y], INF);
			S2[y][y] = 0;
		}
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				if (A1[y][x] != 0) {
					P[y][x] = A1[y][x] * A2[y][x];
					S1[y][x] = A1[y][x];
					S2[y][x] = A2[y][x];
				}
			}
		}
		floydWarshallMul(n, P, S1, S2);
		int res = P[0][1];
		return (res == INF) ? -1 : res;
	}

	public static int minimalCost(String[] W1, String[] W2) {
		int n = W1.length;
		int[][] D1 = transform(W1);
		int[][] D2 = transform(W2);
		int ret = minimalCost(n, D1, D2);
		return (ret == INF) ? -1 : ret;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

	}

	static boolean DEBUG = true;
	
	static void debug(Object...os) {
		if (!DEBUG) { return; }
		System.err.printf("%.65536s\n", Arrays.deepToString(os));
	}

}

