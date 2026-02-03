import java.io.Console;

class Arithmetic {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

class Calculator extends Arithmetic {
    public int divide(int a, int b) {
        return a / b;
    }

    @Override
    public int subtract(int a, int b) {
        System.out.println("We reached the subctract class in calculator");
        return a - b;
    }
}

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println("Calling the overridden subtract" + calc.subtract(12, 4));
        Arithmetic arith = new Arithmetic();
        System.out.println("Calling the subtract of the arithmetic class" + arith.subtract(9, 1));
    }
}
