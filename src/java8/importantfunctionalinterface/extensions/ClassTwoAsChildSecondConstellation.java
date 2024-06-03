package java8.importantfunctionalinterface.extensions;

public class ClassTwoAsChildSecondConstellation implements InterfaceOne, InterfaceTwo {
    @Override // ambiguity so we must override
    public void method() {
        InterfaceOne.super.method();
        //InterfaceTwo.super.method();
    }
    public static void main(String[] args) {
        ClassTwoAsChildSecondConstellation classTwoAsChildSecondConstellation = new ClassTwoAsChildSecondConstellation();
        classTwoAsChildSecondConstellation.method();

    }
}
