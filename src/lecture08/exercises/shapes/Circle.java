package lecture08.exercises.shapes;

public class Circle extends Shape {
    private final double pi = 3.14;

    @Override
    public double getArea(double radius) {
        return pi * Math.pow(radius, 2);
    }

    @Override
    public double getPerimeter(double radius) {
        return 2 * pi * radius;
    }
}
