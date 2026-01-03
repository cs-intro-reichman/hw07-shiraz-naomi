/** Draws ths Sierpinski Triangle fractal. */
public class Sierpinski {

	public static void main(String[] args) {
		sierpinski(Integer.parseInt(args[0]));
	}

	// Draws a Sierpinski triangle of depth n on the standard canvass.
	public static void sierpinski(int n) {
		double h = Math.sqrt(3) / 2;

		double x1 = 0;
		double x2 = 0;
		double x3 = 1.0 / 2.0;
		double y1 = 0;
		double y2 = 0;
		double y3 = h;
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.line(x1, y1, x2, y2);
		StdDraw.line(x2, y2, x3, y3);
		StdDraw.line(x3, y3, x1, y1);
		sierpinski(n, x1, x2, x3, y1, y2, y3);

	}

	// Does the actual drawing, recursively.
	private static void sierpinski(int n, double x1, double x2, double x3,
			double y1, double y2, double y3) {
		if (n == 0)
			return;

		double midX1 = (x1 + x2) / 2.0;
		double midY1 = (y1 + y2) / 2.0;

		double midX2 = (x2 + x3) / 2.0;
		double midY2 = (y2 + y3) / 2.0;

		double midX3 = (x3 + x1) / 2.0;
		double midY3 = (y3 + y1) / 2.0;

		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.line(midX1, midY1, midX2, midY2);
		StdDraw.line(midX2, midY2, midX3, midY3);
		StdDraw.line(midX3, midY3, midX1, midY1);

		sierpinski(n - 1, x1, midX2, midX3, y1, midY2, midY3);
		sierpinski(n - 1, midX1, x2, midX3, midY2, y2, midY3);
		sierpinski(n - 1, midX1, midX2, x3, midY2, midY2, y3);
	}
}
