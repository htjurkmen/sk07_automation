package lecture06.examples;

class Person {
    public int age;
    public String name;

    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        if (age >= 0) {
            age = age;
        }
    }
}

class Test {
    public static void main(String[] args) {
        Person person = new Person();
        person.age = 5;
        System.out.println(person.getAge());
    }
}