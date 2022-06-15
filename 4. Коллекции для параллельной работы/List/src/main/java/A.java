public class A {

    public void foo() {
        synchronized (this) {

        }
    }

    public static void bar() {
        synchronized (A.class) {

        }
    }
}
