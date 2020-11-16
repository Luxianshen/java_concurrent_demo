package reference;

public class StrongReferenceDemo {

    public static void main(String[] args) {
        Object a = new Object();
        Object b = a;
        a= null;
        System.gc();
        System.out.println(b);

    }
}
