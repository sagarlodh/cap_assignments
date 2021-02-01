import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
class Trader {
    private String name;
    private String city;

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() { return name; }

    public String getCity() { return city; }
}
class Transaction {
    private Trader trader;
    private int year;
    private int value;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }
    public Trader getTrader() { return trader; }

    public int getYear() { return year; }

    public int getValue() { return value; }
}

public class Assignment5Q4 {

    public static List<Transaction> sortTransactions(List <Transaction> transactions) {
        transactions.stream().filter(o -> o.getYear()==2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .map(Transaction::getValue)
                .forEach(System.out::println);
        return null;
    }
    /*
     * accessing 'TRADER CITY' through the 'TRANSACTION' stream
     * and filtering for 'DELHI' to get the value of transaction
     */
    public static List<Integer> transactionsValuesDelhi(List<Transaction> transactions) {
        transactions.stream()
                    .filter(o -> o.getTrader().getCity().equals("delhi"))
                    .map(Transaction::getValue)
                    .forEach(System.out::println);
        return null;
    }

    /*
     * using the 'MAX' method to get the max value by comparing values
     */
    public static int highestTransaction(List<Transaction> transactions){
        Optional<Integer> max = transactions.stream()
                                        .max(Comparator.comparingInt(Transaction::getValue))
                                        .map(Transaction::getValue);
        if(max.isPresent()){
            System.out.println(max.get());
        }
        return 0;
    }

    /*
     * we can also reverse the 'MAX' method to get the smallest
     */
    public static int smallestTransaction(List<Transaction> transactions){
        Optional<Integer> min = transactions.stream()
                                    .min(Comparator.comparingInt(Transaction::getValue))
                                    .map(Transaction::getValue);
        if(min.isPresent()){
            System.out.println(min.get());
        }
        return 0;
    }

    public static void main(String[] args) {
        Transaction t1 = new Transaction(new Trader("A","goa"),2011,5000);
        Transaction t2 = new Transaction(new Trader("B","pune"),2002,7000);
        Transaction t3 = new Transaction(new Trader("C","mumbai"),2011,4000);
        Transaction t4 = new Transaction(new Trader("D","delhi"),2007,12000);
        Transaction t5 = new Transaction(new Trader("E","guwahati"),2004,9000);
        Transaction t6 = new Transaction(new Trader("F","delhi"),2011,8000);
        Transaction t7 = new Transaction(new Trader("G","calcutta"),2006,6000);

        ArrayList<Transaction> transactionArrayList = new ArrayList<>();
        transactionArrayList.add(t1);
        transactionArrayList.add(t2);
        transactionArrayList.add(t3);
        transactionArrayList.add(t4);
        transactionArrayList.add(t5);
        transactionArrayList.add(t6);
        transactionArrayList.add(t7);

        System.out.println("Transaction Values in year '2011' sorted in ascending order : ");
        sortTransactions(transactionArrayList);
        System.out.println("`````````````````````````````````````````````````````````````````````````");
        System.out.println("All transactions’ values from the traders living in Delhi : ");
        transactionsValuesDelhi(transactionArrayList);
        System.out.println("`````````````````````````````````````````````````````````````````````````");
        System.out.println("Highest value of all the transactions: ");
        highestTransaction(transactionArrayList);
        System.out.println("`````````````````````````````````````````````````````````````````````````");
        System.out.println("Smallest value of all the transactions: ");
        smallestTransaction(transactionArrayList);
    }
}