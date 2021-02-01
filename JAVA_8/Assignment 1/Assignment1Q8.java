class BubbleSort{
    public int[] bubbleSort(int arr[]) {
        int lengthOfArray = arr.length;
        int temp;
        for (int i=0;i< (lengthOfArray-1) ;i++) {
            for (int j=0;j< (lengthOfArray-i-1) ;j++) {
                if (arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        for (int i=0;i<lengthOfArray;i++) {
            System.out.print(arr[i]+" ");
        }
        return null;
    }
}
public class Assignment1Q8 {
    public static void main(String args[]) {
        int arr[] = {5,12,14,6,78,19,1,23,26,35,37,7,52,86,47};
        BubbleSort bs = new BubbleSort();
        bs.bubbleSort(arr);
    }
}