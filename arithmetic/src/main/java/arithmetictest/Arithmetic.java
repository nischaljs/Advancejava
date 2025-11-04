package arithmetictest;

// 🔹 Inheritance: Arithmetic inherits Calculator
public class Arithmetic extends Calculator {
    private double num1;
    private double num2;

    // Constructor
    public Arithmetic(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    // Encapsulation: getters & setters
    public double getNum1() { return num1; }
    public void setNum1(double num1) { this.num1 = num1; }

    public double getNum2() { return num2; }
    public void setNum2(double num2) { this.num2 = num2; }

    // Overriding methods
    @Override
    public double add(double a, double b) { return a + b; }

    @Override
    public double subtract(double a, double b) { return a - b; }

    @Override
    public double multiply(double a, double b) { return a * b; }

    @Override
    public double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero!");
            return 0;
        }
        return a / b;
    }

    // Polymorphism: Method overloading
    public int add(int a, int b) { return a + b; }
    public double add(double a, double b, double c) { return a + b + c; }
}
