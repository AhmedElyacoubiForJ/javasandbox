package patternprinter;

public class SquareEmptyPattern {
    public static void main(String[] args) {
        int n = 6;
        for (int row = 1; row <= n; row++) {
            for (int column = 1; column <= n; column++) {
                if (row == 1 || row == n || column == 1 || column == n) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println("");

        }
    }
}
