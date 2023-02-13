package lecture09.exercises;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Harry", "Male", "Dark", "English", "Magician", "English", "UK", 8103245060l);
        Italian italian = new Italian("Francesco", "Male", "Catholic", "Chef",  7605108945l);
        Bulgarian bulgarian = new Bulgarian("Boryana", "Female", "Orthodox", "Manager",  9112239583l);
        American american = new American("John", "Male", "Catholic", "CEO",  6811125584l);
        Child child = new Child("Ivancho", "Male", "Orthodox", "Bulgarian", "Bulgaria", "Bulgaria", 9912239583l);

        //Common actions
        executePersonActions(person);
        executePersonActions(italian);
        executePersonActions(bulgarian);
        executePersonActions(american);
        executePersonActions(child);
    }

    private static void executePersonActions(Person person) {
        System.out.println("===============================================================\n");
        System.out.println("Execute actions for class " + person.getClass().getSimpleName());
        System.out.println(person.toString());
        person.celebrateEaster();
        person.sayHello();
        person.canTakeLoan();
        person.isAdult();
        if (person instanceof American ) {
            ((American) person).celebrateThanksgiving();
        } else if (person instanceof Bulgarian) {
            ((Bulgarian) person).danceHoro();
        } else if (person instanceof Italian) {
            ((Italian) person).makePizza(Arrays.asList("Cheese", "Mushrooms", "Olives"));
        }
        else if (person instanceof Child) {
            ((Child) person).play("Ball");
        }
    }
}
