package java8.functionalinterfaceextensions;

public interface InterfaceOne {
    public default void method() {
        System.out.println("Default method from InterfaceOne");
    }
}
