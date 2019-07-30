public class Start {

	public static void main(String[] args) {
		// Find intersection points two circle.

		// data
		Point A = new Point(4, 4);
		double r = 2;
		Point B = new Point(6, 7);
		double R = 4;

		Point[] points = calcIntersectionTwoCircle(A, r, B, R);
		
		Point G = points[0];
		Point H = points[1];
		
		System.out.printf("G  ( %.2f , %.2f )%n", G.x, G.y);
		System.out.printf("H  ( %.2f , %.2f )%n", H.x, H.y);


	}
	
	public static Point[] calcIntersectionTwoCircle(
			Point A, double r, Point B, double R)
	{
		Point[] points = new Point[2];
		
		// variable		
		double w, a, b, c, sqrtDelta, y1, y2, x1, x2;
		// Move the layout to the coordinates of the first circle.
		Point C = new Point(B.x - A.x, B.y - A.y);
		
		// Check whether the sum of radius is not greater than
		// the distance between the centers of circles!
		if (Math.sqrt(C.x*C.x  + C.y*C.y) <= r + R) {
			// move w1 to 0,0 ; w2 calculate new position
			a = C.x * C.x + C.y * C.y;
			w = R * R - r * r - a;
			//System.out.println("w = " + w);
			//System.out.println("a = " + a);
			b = w * C.y;
			//System.out.println("b = " + b);
			c = (w * w) / 4 - C.x * C.x * r * r;
			//System.out.println("c = " + c);
			sqrtDelta = Math.sqrt(b * b - 4 * a * c);
			//System.out.println("sqrDelta = " + sqrtDelta);
			y1 = (-b - sqrtDelta) / (2 * a);
			//System.out.println("y1 = " + y1);
			y2 = (-b + sqrtDelta) / (2 * a);
			//System.out.println("y2 = " + y2);

			x1 = (C.y * y1 + w/2) / -C.x;
			x2 = (C.y * y2 + w/2) / -C.x;

			points[0] = new Point(x1+A.x, y1+A.y);
			points[1] = new Point(x2+A.x, y2+A.y);
		}
				
		return points;
	}

}



class Point {

	public double x, y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
}
