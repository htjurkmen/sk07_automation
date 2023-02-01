package lecture06.examples.immutable;

// Immutable class
public final class Student {
    final String name;
    final int regNo;

    public Student(String name, int regNo) {
        this.name = name;
        this.regNo = regNo;
    }

    public String getName() {
        return name;
    }

    public int getRegNo() {
        return regNo;
    }
}

class Test {
    public static void main(String[] args) {
        Student s = new Student("Harry", 777);
        System.out.println(s.getName());
        System.out.println(s.getRegNo());
        // Uncommenting the below line causes an error
        // s.regNo = 708;
    }
}