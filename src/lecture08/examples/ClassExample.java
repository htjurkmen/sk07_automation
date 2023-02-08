package lecture08.examples;

public class ClassExample {
    static int attr = 5;
    int attr2 = 8;

    public static void printHello() {
        System.out.println("Hello. This method can be called WITHOUT creating object of class ClassExample");
    }

    public void printHelloOfObject() {
        System.out.println("Hello. This method can be called only if you create an object of class ClassExample");
        System.out.println("Non-static variables as attr2 can be accessed ONLY by non-static (object) methods");
        System.out.println("The value of attr2 is: " + this.attr2 + " The value of x is accessed by method printHelloOfObject.");
    }

}
