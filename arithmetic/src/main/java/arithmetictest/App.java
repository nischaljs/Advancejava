package arithmetictest;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Simple OOP Calculator ===");

        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        Arithmetic calc = new Arithmetic(num1, num2);

        System.out.println("Choose operation: + - * /");
        char op = scanner.next().charAt(0);

        double result = 0;

        switch (op) {
            case '+': result = calc.add(calc.getNum1(), calc.getNum2()); break;
            case '-': result = calc.subtract(calc.getNum1(), calc.getNum2()); break;
            case '*': result = calc.multiply(calc.getNum1(), calc.getNum2()); break;
            case '/': result = calc.divide(calc.getNum1(), calc.getNum2()); break;
            default:
                System.out.println("Invalid operation!");
                scanner.close();
                return;
        }

        System.out.println("Result: " + result);
        scanner.close();
    }
}

