import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
class SavingAccount implements Comparable<SavingAccount> {
    private double acc_balance;
    private int acc_ID;
    private String accountHolderName;
    private boolean isSalaryAccount;
    public SavingAccount(double acc_balance, int acc_ID, String accountHolderName, boolean isSalaryAccount) {
        this.acc_balance = acc_balance;
        this.acc_ID = acc_ID;
        this.accountHolderName = accountHolderName;
        this.isSalaryAccount = isSalaryAccount;
    }
    /*
     * getter and setters initialized
     */

    public double getAcc_balance() { return acc_balance; }
    public void setAcc_balance(double acc_balance) {
        this.acc_balance = acc_balance;
    }

    public int getAcc_ID() { return acc_ID; }
    public void setAcc_ID(int acc_ID) {
        this.acc_ID = acc_ID;
    }

    public String getAccountHolderName() { return accountHolderName; }
    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public boolean isSalaryAccount() { return isSalaryAccount; }
    public void setSalaryAccount(boolean salaryAccount) {
        isSalaryAccount = salaryAccount;
    }

    public double withdraw(double withdrawAmount){
        double newTotal = getAcc_balance() + withdrawAmount;
        setAcc_balance(newTotal);
        return getAcc_balance();
    }
    public double deposit(double depositAmount){
        double newTotal = getAcc_balance() + depositAmount;
        setAcc_balance(newTotal);
        return getAcc_balance();
    }

    @Override
    public String toString() {
        return "SavingAccount{" +
                "acc_balance=" + acc_balance +
                ", acc_ID=" + acc_ID +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", isSalaryAccount=" + isSalaryAccount +
                '}';
    }
    /*
     * for sorting in ascending order
     */
    @Override
    public int compareTo(SavingAccount o) {
        if (this.acc_ID>o.acc_ID){
            return 1;
        }
        else return -1;
    }
}
class BankAccountList{

    private TreeSet<SavingAccount> savingAccounts = new TreeSet<>();

    /*
     * adding savings account to treeSet
     */
    public boolean addSavingAccount(SavingAccount savingAccount) {
        return savingAccounts.add(savingAccount);
    }

    /*
     * displaying IDs
     */
    public List<Integer> displaySavingAccountIds() {
        List<TreeSet<SavingAccount>> list = new ArrayList<>();
        list.add(savingAccounts);
        for (TreeSet<SavingAccount> sa : list) {
            for (SavingAccount s: sa) {
                System.out.println(s);
            }
        }
        return null;
    }
}
public class Assignment3Q9 {
    public static void main(String[] args) {
        /**
         * we can take input from USER through Scanner class
         */
        SavingAccount sA1 = new SavingAccount(1200,1,"Roy",true);
        SavingAccount sA2 = new SavingAccount(500,20,"Moyal",false);
        SavingAccount sA3 = new SavingAccount(1700,3,"Cain",true);

        BankAccountList bl = new BankAccountList();
        bl.addSavingAccount(sA1);
        bl.addSavingAccount(sA2);
        bl.addSavingAccount(sA3);

        bl.displaySavingAccountIds();       // displays accounts
    }
}