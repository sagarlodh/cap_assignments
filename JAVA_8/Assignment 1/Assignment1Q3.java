import java.util.Scanner;
class SiCi {
    public double simpleInterest(double principalAmount,int time,double interestRate){
        double SI;
        SI = (principalAmount*time*interestRate)/100;
        return SI ;
    }
    public double compoundInterest(double principalAmount,int time,double interestRate){
        double CI;
        CI = (principalAmount * Math.pow((1.0+interestRate/100),time))-principalAmount;
        return CI;
    }
}
public class Assignment1Q3 {
    public static void main (String args[]) {
        double P,iR;int T;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the Principle Amount : ");
        P = scan.nextDouble();
        System.out.println("Enter the Time(in years) Amount : ");
        T = scan.nextInt();
        System.out.println("Enter the ROI Amount : ");
        iR = scan.nextDouble();
        SiCi sc = new SiCi();
        System.out.println(sc.simpleInterest(P,T,iR));
        System.out.println(sc.compoundInterest(P,T,iR));
    }
}