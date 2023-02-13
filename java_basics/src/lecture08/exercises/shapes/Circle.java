package lecture08.exercises.shapes;

public class Circle extends Shape {

    @Override
    public double getArea(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getPerimeter(double radius) {
        return 2 * Math.PI * radius;
    }
}
