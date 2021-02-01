import java.util.Scanner;
/**
 * Used 'public Int' instead of 'public Boolean'
 */
class ArmstrongOrNot {
    public int armstrongCheck(int num) {
        int n=num;
        int r;int sum=0;
        while(n!=0){
            r = n%10;
            n = n/10;
            sum = sum + r*r*r;
        }
        return sum;
    }
}
public class Assignment1Q1 {
        public static void main(String[] args) {
            int num,finalResult;
            Scanner s = new Scanner(System.in);
            System.out.println("Enter number : ");
            num = s.nextInt();
            ArmstrongOrNot arm = new ArmstrongOrNot();
            finalResult = arm.armstrongCheck(num);
            if(finalResult==num){
                System.out.println("Armstrong num");
            }
            else{
                System.out.println("not Armstrong num");
            }
        }
}
