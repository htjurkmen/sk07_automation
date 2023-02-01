package lecture06.examples;

public class ReferenceFinalVariable {
    public static void main(String[] args) {
        // a final reference variable sb
        final StringBuilder sb = new StringBuilder("Geeks");

        // changing the internal state of the object reference
        // by final reference variable
        sb.append("ForGeeks");
        System.out.println(sb);
    }
}
