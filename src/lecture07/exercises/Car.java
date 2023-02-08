package lecture07.exercises;

public class Car {
    private String name;
    private String color;
    private int releaseYear;
    private int horsePower;
    boolean secondHandTick;

    public Car(String name, String color, int releaseYear, int horsePower, boolean secondHandTick) {
        this.name = name;
        this.color = color;
        this.releaseYear = releaseYear;
        this.horsePower = horsePower;
        this.secondHandTick = secondHandTick;
    }

    public Car(String name, String color, boolean secondHandTick) {
        this(name, color, -1, -1, secondHandTick);
    }

    public Car(String name, String color, int releaseYear, int horsePower){
        this(name, color, releaseYear, horsePower, false);
    }

    public Car(String name, int releaseYear, int horsePower, boolean secondHandTick){
        this(name, "N/A", releaseYear, horsePower, secondHandTick);
    }

    public Car() {
    }

}
