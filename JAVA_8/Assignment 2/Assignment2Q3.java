import java.util.ArrayList;
import java.util.List;

class CurrentAccount extends Assignment2Q3 {
    int totalDeposits = 10000;
    int creditLimit = 2000;
    @Override
    public int getCash() {
        /*
         * here we return the max amount that can be withdrawn i.e,
         * totalDeposits, as credit limit will be in-terms of crediting
         * and not needed while calculating total cash in the bank
         */
        return totalDeposits;
    }
}
class SavingsAccount extends Assignment2Q3 {
    int totalDeposits = 10000;
    int fixedDepositAmount = 5000;
    @Override
    public int getCash() {
        /*
         * here we only return the totalDeposit as we
         * don't need fixedDepositAmount to calculate
         * total cash in the bank
         */
        return totalDeposits;
    }
    public int getFixedDepositAmount() {
        return fixedDepositAmount;
    }
    public int getWithDrawal() {
        /*
         * @return the actual amount that can be withdrawn after subtracting
         * fixed deposit amount for calculation of withdrawal
         */
        return totalDeposits - fixedDepositAmount;
    }
}
public class Assignment2Q3 {
    public static Integer totalCashInBank(int cash){
        return cash;
    }
    /*
     * here are all the 'need to be overridden' getter methods in the child classes
     */
    public int getCash(){ return 0; }
    public int getFixedDepositAmount() { return 0; }
    public int getWithDrawal() { return 0; }

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        Assignment2Q3 currentAccount = new CurrentAccount();
        Assignment2Q3 savingsAccount = new SavingsAccount();
        /*
         * adding to the list
         */
        array.add(totalCashInBank(currentAccount.getCash() + savingsAccount.getCash()));

        int total = 0;
        for(int i : array){
            total += i;
        }

        //int total = currentAccount.getCash()+ savingsAccount.getCash();

        int withDraw = currentAccount.getCash() + savingsAccount.getWithDrawal();

        System.out.println("Cash in Savings Account  : $"+savingsAccount.getCash());
        System.out.println("Cash in Current Account  : $"+currentAccount.getCash());
        System.out.println("---------------------------------------------");
        System.out.println("Total Cash in the Bank   : $"+total);
        System.out.println("---------------------------------------------");
        System.out.println("------> Savings Fixed Deposit Amount : $"+savingsAccount.getFixedDepositAmount());
        System.out.println("------> Withdrawl From Savings       : $"+savingsAccount.getWithDrawal());
        System.out.println("------> Withdrawl From Current       : $"+currentAccount.getCash());
        System.out.println("---------------------------------------------");
        /*
         * totaWithdrawlCash = totalCurrentAccountDeposit + (totalSavingsAccountDeposit - fixedDepositAmount)
         */
        System.out.println("Total Withdrawal Cash : $"+withDraw);
    }
}