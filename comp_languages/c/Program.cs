using System;

namespace Equation
{
    class Program
    {
        static void Main(string[] args)
        {
            // Find intersection points two circle.

            Point A = new Point(4, 4);
            double r = 2;
            Point B = new Point(6, 7);
            double R = 4;

            Point[] points = CalcIntersectionTwoCircle(A, r, B, R);

            Console.WriteLine("G " + points[0]);
            Console.WriteLine("H " + points[1]);
            Console.ReadKey();

        }

        static Point[] CalcIntersectionTwoCircle(
            Point A, double r, Point B, double R)
        {
            Point[] points = new Point[2];

            // variable		
            double w, a, b, c, sqrtDelta, y1, y2, x1, x2;
            // Move the layout to the coordinates of the first circle.
            Point C = new Point(B.X - A.X, B.Y - A.Y);

            // Check whether the sum of radius is not greater than
            // the distance between the centers of circles!
            a = C.X * C.X + C.Y * C.Y;
            if (Math.Sqrt(a) <= r + R)
            {
                // move w1 to 0,0 ; w2 calculate new position
                w = R * R - r * r - a;
                b = w * C.Y;
                c = (w * w) / 4 - C.X * C.X * r * r;
                sqrtDelta = Math.Sqrt(b * b - 4 * a * c);

                y1 = (-b - sqrtDelta) / (2 * a);
                y2 = (-b + sqrtDelta) / (2 * a);

                x1 = (C.Y * y1 + w / 2) / -C.X;
                x2 = (C.Y * y2 + w / 2) / -C.X;

                points[0] = new Point(x1 + A.X, y1 + A.Y);
                points[1] = new Point(x2 + A.X, y2 + A.Y);
            }


            return points;
        }

    }

    // Helper class
    class Point
    {
        public double X { get; set; }
        public double Y { get; set; }

        public Point(double x, double y)
        {
            X = x;
            Y = y;
        }

        public override string ToString()
        {
            return "( " + X.ToString("F2") + ", " + Y.ToString("F2") + " )";
        }
    }
}
