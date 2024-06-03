package java8.importantfunctionalinterface.extensions;

public interface InterfaceOne {
    public default void method() {
        System.out.println("Default method from InterfaceOne");
    }
}
