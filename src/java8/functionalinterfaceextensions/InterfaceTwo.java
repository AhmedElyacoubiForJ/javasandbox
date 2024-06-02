package java8.functionalinterfaceextensions;

public interface InterfaceTwo {
    public default void method() {
        System.out.println("Default method from InterfaceTwo");
    }
}
