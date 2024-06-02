package java8.functionalinterfaceextensions;

@FunctionalInterface
public interface Interface {
    public void abstractMethod();
    public default void defaultMethod() {
        System.out.println("Interface default method");
    }
    // not inherited
    public static void staticMethod() {
        System.out.println("Interface static method");
    }
   /* public static void main(String[] args) {
        Interface.staticMethod();
    }*/
}
