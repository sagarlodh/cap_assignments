import java.util.Scanner;
class Login{
    String userId = "Ajay",password = "password";
    static int count=0;
    public String loginUser(String user, String pass) {
        if(userId.equals(user)){
            if(password.equals(pass)) {
                System.out.println("Welcome Ajay");
            }
            else {
                count += 1;
                if(count<3){
                    System.out.println("You have entered wrong credentials ,please enter the right credentials.");
                    Assignment1Q6.main(null);
                    //count = 0;
                }
                else{
                    System.out.println("You have entered wrong credentials 3 times");
                    System.out.println("Contact Admin");
                    System.exit(0);
                }
            }
        }
        else {
            count += 1;
            if(count<3){
                System.out.println("You have entered wrong credentials ,please enter the right credentials.");
                Assignment1Q6.main(null);
            }
            else{
                System.out.println("You have entered wrong credentials 3 times");
                System.out.println("Contact Admin");
                System.exit(0);
            }
        }
        return null;
    }
}
public class Assignment1Q6 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
            System.out.println("Enter userID : ");
            String userName = scan.nextLine();
            System.out.println("Enter password : ");
            String userPass = scan.nextLine();
        Login login = new Login();
        login.loginUser(userName,userPass);
    }
}