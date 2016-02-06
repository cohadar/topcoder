import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class ExplodingRobots {

	static class Point {
		final int dx;
		final int dy;
		Point(int dx, int dy) {
			this.dx = dx;
			this.dy = dy;
		}
		Point move(char c, int m1, int m2) {
			int tx = this.dx;
			int ty = this.dy;
			switch (c) {
				case 'U':
					ty += (m2 - m1);
				break;
				case 'D':
					ty += -(m2 - m1);
				break;
				case 'R':
					tx += (m2 - m1);
				break;
				case 'L':
					tx += -(m2 - m1);
				break;
			}
			return new Point(tx, ty);
		}
		Point moveFirst(char c) {
			return this.move(c, 1, 0);
		}
		Point moveSecond(char c) {
			return this.move(c, 0, 1);
		}
		Point moveBoth(char c) {
			return this.move(c, 1, 1);
		}
		public String toString() {
			return String.format("(dx=%d, dy=%d)", dx, dy);
		}	
	}

	private int OFFSET = 75;
	private int NULL = 0;
	private int EXPLODE = 1;
	private int MISS = 2;
	private int[][][] D; 
	private char[] I;

	private boolean canExplode(Point p, int n) {
		int dx = p.dx;
		int dy = p.dy;
		if (D[OFFSET + dx][OFFSET + dy][n] != NULL) {
			return D[OFFSET + dx][OFFSET + dy][n] == EXPLODE;
		}
		if (dx == 0 && dy == 0) {
			D[OFFSET + dx][OFFSET + dy][n] = EXPLODE;
			return true;
		}
		if (n >= I.length) {
			D[OFFSET + dx][OFFSET + dy][n] = MISS;
			return false;
		}
		if (canExplode(p, n + 1)) {
			D[OFFSET + dx][OFFSET + dy][n] = EXPLODE;
			return true;
		}
		if (canExplode(p.moveFirst(I[n]), n + 1)) {
			D[OFFSET + dx][OFFSET + dy][n] = EXPLODE;
			return true;
		}
		if (canExplode(p.moveSecond(I[n]), n + 1)) {
			D[OFFSET + dx][OFFSET + dy][n] = EXPLODE;
			return true;
		}
		if (canExplode(p.moveBoth(I[n]), n + 1)) {
			D[OFFSET + dx][OFFSET + dy][n] = EXPLODE;
			return true;
		}
		D[OFFSET + dx][OFFSET + dy][n] = MISS;
		return false;
	}

	public String canExplode(int x1, int y1, int x2, int y2, String instructions) {
		this.I = instructions.toCharArray();
		this.D = new int[151][151][51];
		return (canExplode(new Point(x2 - x1, y2 - y1), 0)) ? "Explosion" : "Safe";
	}

}

