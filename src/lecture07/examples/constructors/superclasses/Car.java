package lecture07.examples.constructors.superclasses;

public class Car extends Vehicle {
    private String brand = null;

    public Car(String brand, String regNo) {
        super(regNo);
        this.brand = brand;
    }
}
