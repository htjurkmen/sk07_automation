package lecture09.exercises;

import java.util.List;

public class Italian extends Person {
    public Italian(String name, String sex, String religion, String job, long egn) {
        super(name, sex, religion, "Italian", job, "Italian", "Italy", egn);
    }

    public void cookSpaghetti() {
        System.out.println("Cooking spaghetti!");
    }
    @Override
    public void sayHello() {
        System.out.println("Bonjourno Italiano!");
    }
    public void makePizza(List<String> ingredients) {
        System.out.println("I am making a pizza with the following ingredients: " + ingredients);
    }
}
