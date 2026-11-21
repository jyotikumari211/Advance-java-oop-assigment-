import java.util.*;

interface Drawable { void draw(); }
abstract class Shape implements Drawable {
    public abstract double area();
    public void describe() { System.out.printf("%s area = %.2f%n", getClass().getSimpleName(), area()); }
}
class Circle extends Shape {
    private final double radius;
    Circle(double radius) { if (radius <= 0) throw new IllegalArgumentException("Radius must be positive"); this.radius = radius; }
    public double area() { return Math.PI * radius * radius; }
    public void draw() { System.out.println("Drawing a circle"); }
}
class Rectangle extends Shape {
    private final double length, width;
    Rectangle(double length, double width) {
        if (length <= 0 || width <= 0) throw new IllegalArgumentException("Dimensions must be positive");
        this.length = length; this.width = width;
    }
    public double area() { return length * width; }
    public void draw() { System.out.println("Drawing a rectangle"); }
}
public class ShapeInterfaceDemo {
    public static void main(String[] args) {
        List<Shape> shapes = Arrays.asList(new Circle(4), new Rectangle(5, 3));
        for (Shape shape : shapes) { shape.draw(); shape.describe(); }
    }
}
