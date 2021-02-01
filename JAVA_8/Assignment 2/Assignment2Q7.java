import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
abstract class DesertItem {
    /*
     * method to be overridden
     */
    abstract public int getCost();
}
class Candy extends DesertItem {
    public int addCandies(int candies){
        return candies;
    }
    @Override
    /*
     * here shopkeeper takes money in rupees
     * does transaction in dollars,
     * returns output to calling function in terms of dollars..
     */
    public int getCost() {
        Scanner scanner = new Scanner(System.in);
        int cost = scanner.nextInt();
        cost = cost/60;
        return(cost-20)*60;
    }
}
class Cookie extends DesertItem {
    public int addCookies(int cookies){
        return cookies;
    }
    @Override
    /*
     * here shopkeeper takes money in rupees
     * does transaction in euros,
     * returns output to calling function in terms of euros..
     */
    public int getCost() {
        Scanner scanner = new Scanner(System.in);
        int cost = scanner.nextInt();
        cost = cost/70;
        return(cost-20)*70;
    }
}
class IceCream extends DesertItem {
    public int addIceCreams(int iceCream){
        return iceCream;
    }
    @Override
    /*
     * here normal transaction takes place
     * in terms of rupees...
     */
    public int getCost() {
        Scanner scanner = new Scanner(System.in);
        int cost = scanner.nextInt();
        return cost-1500;
    }
}
public class Assignment2Q7 {
    public static void main(String[] args) {
        Assignment2Q7 obj = new Assignment2Q7();
        obj.selectRoles();
    }
    /*
     * for selecting roles
     */
    private void selectRoles(){
        Scanner scan = new Scanner(System.in);
        Assignment2Q7 storage = new Assignment2Q7();

        System.out.println("``````````````````");
        System.out.println("ROLES Available : ");
        System.out.println("``````````````````");
        System.out.println("\t---> owner");
        System.out.println("\t---> customer");
        System.out.println("Enter the role : ");
        String role = storage.roles(scan.nextLine());
        switch (role) {
            case "owner" -> //break;
                    storage.addItems();
            case "customer" -> //break;
                    storage.placeOrder();
            default -> {
                System.out.println("Please enter correct role...");
                selectRoles();
                //break;
            }
        }
    }
    /*
     * @param role as input from user
     * @return the role
     */
    private String roles(String role){
        return role;
    }

    /*
     * for updating the number of items in List
     */
    private void addItems() {
        Assignment2Q7 storage1 = new Assignment2Q7();
        System.out.println("``````````````````````````");
        System.out.println("Available Desert Items : ");
        System.out.println("``````````````````````````");
        System.out.println("[1] Add Candy");
        System.out.println("[2] Add Cookie");
        System.out.println("[3] Add Ice Cream");
        System.out.println("Enter desert items to update : ");
        Scanner scan1 = new Scanner(System.in);
        int itemId = storage1.addItemsOperation(scan1.nextInt());
        /*
         we can create two LINKED LISTs and keep on adding ITEM_NAME to one list
         and ITEM_COUNT to the other one, and later print them both
         upon each update....    (not achieved)
         * (alternative achieved - separate lists)
         */
        switch (itemId) {
            case 1 -> {
                Candy candy = new Candy();
                System.out.println("Enter the number of candies to be updated : ");
                int noCandies = scan1.nextInt();
                List<String> nameCandyList = new ArrayList<>();
                List<Integer> noOfCandyItemList = new ArrayList<>();
                /*
                 same as 'obj.add(...)'
                 */
                nameCandyList.add(0, "Candy");
                noOfCandyItemList.add(0, candy.addCandies(noCandies));

                System.out.println("Candy added..."+"\n"+nameCandyList+"\n"
                                    +"Entered no. of candies updated..."+"\n"+noOfCandyItemList);
                storage1.selectRoles();
                //break;
            }
            case 2 -> {
                Cookie cookie = new Cookie();
                System.out.println("Enter the number of cookies to be added : ");
                int noCookies = scan1.nextInt();
                List<String> nameCookieList = new ArrayList<>();
                List<Integer> noOfCookieItemList = new ArrayList<>();

                nameCookieList.add(0, "Cookie");
                noOfCookieItemList.add(0, cookie.addCookies(noCookies));

                System.out.println("Cookie added..."+"\n"+nameCookieList+"\n"
                                    +"Entered no. of cookies updated..."+"\n"+noOfCookieItemList);
                storage1.selectRoles();
                //break;
            }
            case 3 -> {
                IceCream iceCream = new IceCream();
                System.out.println("Enter the number of Ice-Creams to be added : ");
                int noIceCream = scan1.nextInt();
                List<String> nameIceList = new ArrayList<>();
                List<Integer> noOfIceItemList = new ArrayList<>();

                nameIceList.add(0, "Ice Cream");
                noOfIceItemList.add(0, iceCream.addIceCreams(noIceCream));

                System.out.println("Ice-Cream added..."+"\n"+nameIceList+"\n"
                                    +"Entered no. of ice-creams updated..."+"\n"+noOfIceItemList);
                storage1.selectRoles();
                //break;
            }
            default -> {
                System.out.println("Please enter correct number...");
                addItems();
                //break;
            }
        }
    }
    private int addItemsOperation(int choice) {
        return choice;
    }
    private void placeOrder() {
        int candyReturnCost,cookieReturnCost,iceCreamReturnCost;
        Assignment2Q7 storage2 = new Assignment2Q7();
        System.out.println("``````````````````````````");
        System.out.println("Available Desert Items : ");
        System.out.println("``````````````````````````");
        System.out.println("[1] Add Candy           : $20");
        System.out.println("[2] Add Cookie          : €15");
        System.out.println("[3] Add Ice Cream       : ₹1500");
        System.out.println("Enter number to order item : ");
        Scanner scan2 = new Scanner(System.in);
        int orderId = storage2.placeOrderOperation(scan2.nextInt());
        switch (orderId) {
            case 1 -> {
                Candy costCandy = new Candy();

                /* we take that customer always pays in RUPEES
                 * 1 dollar = 60 rupees
                 * 1 euro = 70 rupees
                 */
                System.out.println("Enter your pay amount (in RUPEES): ");
                candyReturnCost = costCandy.getCost();
                if (candyReturnCost == 0) {
                    System.out.println("Payment paid...."
                                        + "\nPlease collect candy....");
                } else if(candyReturnCost > 0){
                    System.out.println("Payment paid...."
                                        + "\nPlease collect : $"
                                            + candyReturnCost+ "\nand collect candy...");
                    // insert wait time
                } else{
                    System.out.println("Please pay Full amount...");
                }
                storage2.selectRoles();
                //break;
            }
            case 2 -> {
                Cookie costCookie = new Cookie();
                System.out.println("Enter your pay amount : ");
                cookieReturnCost = costCookie.getCost();
                if (cookieReturnCost == 0) {
                    System.out.println("Payment paid...."
                                        + "\nPlease collect cookie....");
                } else if(cookieReturnCost > 0){
                    System.out.println("Payment paid...."
                                        + "\nPlease collect : €"
                                            + cookieReturnCost + "\nand collect cookie...");
                    // insert wait time
                } else{
                    System.out.println("Please pay Full amount...");
                }
                storage2.selectRoles();
                //break;
            }
            case 3 -> {
                IceCream costIceCream = new IceCream();
                System.out.println("Enter your pay amount : ");
                iceCreamReturnCost = costIceCream.getCost();
                if (iceCreamReturnCost == 0) {
                    System.out.println("Payment paid...."
                                        + "\nPlease collect ice-cream....");
                } else if(iceCreamReturnCost > 0){
                    System.out.println("Payment paid...."
                                        + "\nPlease collect : ₹"
                                            + iceCreamReturnCost+ "\nand collect ice cream...");
                    // insert wait time
                } else{
                    System.out.println("Please pay Full amount...");
                }
                storage2.selectRoles();
                //break;
            }
            default -> {
                System.out.println("Please enter the correct item no. to order...");
                placeOrder();
                //break;
            }
        }
    }
    private int placeOrderOperation(int choice) {
        return choice;
    }
}