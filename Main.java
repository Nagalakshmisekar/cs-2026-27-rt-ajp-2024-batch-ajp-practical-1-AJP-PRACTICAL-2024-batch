class Point {
    double x, y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class Quadrilateral {
    Point p1, p2, p3, p4;

    Quadrilateral(Point p1, Point p2, Point p3, Point p4) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }
}

class Trapezoid extends Quadrilateral {
    Trapezoid(Point p1, Point p2, Point p3, Point p4) {
        super(p1, p2, p3, p4);
    }

    double area() {
        double b1 = Math.abs(p2.x - p1.x);
        double b2 = Math.abs(p3.x - p4.x);
        double h = Math.abs(p4.y - p1.y);
        return (b1 + b2) * h / 2;
    }
}

class Rectangle extends Trapezoid {
    Rectangle(Point p1, Point p2, Point p3, Point p4) {
        super(p1, p2, p3, p4);
    }

    double area() {
        double l = Math.abs(p2.x - p1.x);
        double w = Math.abs(p4.y - p1.y);
        return l * w;
    }
}

class Square extends Rectangle {
    Square(Point p1, double side) {
        super(
            p1,
            new Point(p1.x + side, p1.y),
            new Point(p1.x + side, p1.y + side),
            new Point(p1.x, p1.y + side)
        );
    }
}

public class Main {
    public static void main(String[] args) {

        Trapezoid t = new Trapezoid(
                new Point(0, 0),
                new Point(6, 0),
                new Point(4, 3),
                new Point(1, 3));

        Rectangle r = new Rectangle(
                new Point(0, 0),
                new Point(5, 0),
                new Point(5, 4),
                new Point(0, 4));

        Square s = new Square(new Point(0, 0), 4);

        System.out.println("Trapezoid Area = " + t.area());
        System.out.println("Rectangle Area = " + r.area());
        System.out.println("Square Area = " + s.area());
    }
}