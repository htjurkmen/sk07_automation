package lecture06.examples.finals;

class ClassWithFinalMethod {
    final void m1() {
        System.out.println("This is a final method.");
    }
}

class SomeClass extends ClassWithFinalMethod {
//    void m1() {
//       // COMPILE-ERROR! Can't override a final method.
//        System.out.println("Illegal!");
//    }
}

