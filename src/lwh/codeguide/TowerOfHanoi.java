package lwh.codeguide;

public class TowerOfHanoi {

    public static void main(String[] args) {
        int n = 3;
        printSteps(3);
    }

    public static void printSteps(int n) {
        if (n > 0) {
            printStepRecursive(n, "left", "right", "mid");
        }
    }

    public static void printStepRecursive(int n, String from, String to, String help) {
        if (n == 1) {
            System.out.println("move 1 from " + from + " to " + to);
        } else {
            printStepRecursive(n - 1, from, help, to);
            System.out.println("move " + n + " from " + from + " to " + to);
            printStepRecursive(n - 1, help, to, from);
        }
    }
}
