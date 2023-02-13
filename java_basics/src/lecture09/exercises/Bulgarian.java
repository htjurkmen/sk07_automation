package lecture09.exercises;

public class Bulgarian extends Person {
    public Bulgarian(String name, String sex, String religion, String job, long egn) {
        super(name, sex, religion, "Bulgarian", job, "Bulgarian", "Bulgaria", egn);
    }
    @Override
    public void sayHello() {
        System.out.println("Здрасти, ко правиш?");
    }
    public void danceHoro() {
        System.out.println("Танцувам хоро!");
    }
}
