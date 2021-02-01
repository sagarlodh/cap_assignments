import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Assignment4Q2 {
   // private int totalPrice;
    //private String status;

    // class cast error not solved
    public static ArrayList listOfOrders(ArrayList orders) {
        //orders.removeIf(w -> (((w.equals("ACCEPTED"))||(w.equals("COMPLETED"))) || w.totalPrice > 10000));
        ArrayList e =new ArrayList();
        Iterator orders1 = orders.iterator();
        while (orders1.hasNext()) {
            if(orders1.next()=="ACCEPTED" || orders1.next()=="COMPLETED" || (int)orders1.next() > 10000){
                //e.add(orders1.next());
                System.out.println(orders1.next());
            }
        }
        return orders;
    }
    public static void main(String[] args) {
        ArrayList t = new ArrayList();
        //ArrayList<String> s = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Assignment4Q2 a = new Assignment4Q2();
        System.out.println("Enter item nos. : ");
        int n = scanner.nextInt();
        for(int i= 0;i<n;i++) {
            System.out.println("Enter the price for "+(i+1)+": ");
            int totalPrice = scanner.nextInt();
            System.out.println("Enter the status for "+(i+1)+": ");
            String Status = scanner.next();
            t.add(totalPrice);
            t.add(Status);
        }
        System.out.println(listOfOrders(t));
    }
}
