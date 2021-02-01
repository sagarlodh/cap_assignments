@FunctionalInterface
public interface Calculator {
    Double calculate(double num1, double num2 );
}

public class Assignment4Q1 {
    public Double addition( int num1, int num2, Calculator calculator ) {
        return calculator.calculate( num1, num2 );
    }
    public Double subtraction(int num1, int num2, Calculator calculator){
        return calculator.calculate( num1, num2);
    }
    public Double division(double num1, double num2, Calculator calculator ) {
        return calculator.calculate( num1, num2 );
    }
    public Double multiplication(int num1, int num2, Calculator calculator){
        return calculator.calculate( num1, num2);
    }
    public static void main(String[] args) {
        Assignment4Q1 a = new Assignment4Q1();

        System.out.println(a.addition(13, 5, (num1, num2) -> num1 + num2));
        System.out.println(a.subtraction(13, 5, (num1, num2) -> num1 - num2));
        System.out.println(a.multiplication(13,5,(num1,num2) -> num1 * num2));
        System.out.println(a.division(13, 5, (num1, num2) -> num1 / num2));
    }
}