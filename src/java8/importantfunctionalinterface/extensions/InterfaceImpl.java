package java8.importantfunctionalinterface.extensions;

public class InterfaceImpl implements Interface {
    @Override
    public void abstractMethod() {
        System.out.println("Implementation of the Abstract method");
    }

    public static void main(String[] args) {
        Interface.staticMethod();

        Interface i = new InterfaceImpl();
        i.abstractMethod();
        i.defaultMethod();
    }
}
