package java8.importantfunctionalinterface.extensions;

public class ClassTwoAsChildFirstConstellation extends ClassOne implements InterfaceOne {
    public static void main(String[] args) {
        // class has always right of way
        ClassTwoAsChildFirstConstellation classTwoAsChildFirstConstellation = new ClassTwoAsChildFirstConstellation();
        classTwoAsChildFirstConstellation.method();
        ((InterfaceOne) classTwoAsChildFirstConstellation).method();

        InterfaceOne interfaceOne = new ClassTwoAsChildFirstConstellation();
        interfaceOne.method();
    }
}
