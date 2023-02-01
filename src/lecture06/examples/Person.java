package lecture06.examples;

public class Person {
    public static int age;
    public static String name;

    public static int getAge() {
        return age;
    }
    public static void setAge(int age) {
        if (age >= 0) {
            age = age;
        }
    }
}
