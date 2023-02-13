package lecture09.exercises;

public class Child extends Person {
    public Child(String name, String sex, String religion, String language, String nationality, String country, long egn) {
        super(name, sex, religion, language, null, nationality, country, egn);
    }

    @Override
    public boolean isAdult() {
        return false;
    }

    @Override
    public boolean canTakeLoan() {
        return false;
    }

    public void play(String toy) {
        System.out.println("I am playing with a " + toy);
    }
}
