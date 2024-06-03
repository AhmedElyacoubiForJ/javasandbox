package java8.importantfunctionalinterface.extensions;

public interface InterfaceTwo {
    public default void method() {
        System.out.println("Default method from InterfaceTwo");
    }
}
