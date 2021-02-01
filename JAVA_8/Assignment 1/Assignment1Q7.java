import java.util.Scanner;
class SearchArray{
    static int flag=0;
    public boolean searchArray(int[] arr,int toCheckValue){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==toCheckValue){
                System.out.println("Number present");
                flag = 1;break;
            }
            else {
                flag=0;
            }
        }
        if(flag==0){
            System.out.println("Number not present");
        }
        return true;
    }
}
public class Assignment1Q7 {
    public static void main(String[] args) {
        int arr[] = {5, 12, 14, 6, 78, 19, 1, 23, 26, 35, 37, 7, 52, 86, 47};
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter value to check : ");
        int valueToCheck = scan.nextInt();
        SearchArray sA = new SearchArray();
        sA.searchArray(arr, valueToCheck);
    }
}