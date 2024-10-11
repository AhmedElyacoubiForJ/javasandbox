package patternprinter;

public class HalfPyramidMuster {
    public static void main(String[] args) {
        printPattern(6, '*');
    }

    public static void printPattern(int rows, char symbol) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(symbol + "  ");
            }
            System.out.println("");
        }
    }
}
