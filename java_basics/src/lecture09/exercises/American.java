package lecture09.exercises;

public class American extends Person {
    public American(String name, String sex, String religion, String job, String id) {
        super(name, sex, religion, "English", job, "American", "USA", id);
    }

    public void celebrateThanksgiving() {
        System.out.println("I am celebrating Thanksgiving!");
    }
}
