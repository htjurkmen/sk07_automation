package lecture09.exercises;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Dumbledore", "Male", "Dark", "English", "Magician", "English", "UK", "8123245060");
        Italian italian = new Italian("Francesco", "Male", "Catholic", "Chef",  "0345108945");
        Bulgarian bulgarian = new Bulgarian("Boryana", "Female", "Orthodox", "Manager",  "9112239583");
        American american = new American("John", "Male", "Catholic", "CEO",  "6811125584");
        Child child = new Child("Ivancho", "Male", "Orthodox", "Bulgarian", "Bulgaria", "Bulgaria", "1241239583");

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
