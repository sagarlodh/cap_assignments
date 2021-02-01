import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Assignment3Q8b {
    public static CopyOnWriteArrayList<Integer> failSafe(CopyOnWriteArrayList<Integer> list) {
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            /*
             * Thread 1
             * here this thread is iterating through the List
             */
            int i = iterator.next();
            /*
             * if the list has a number at index '0' then it will print the list
             */
            if(i==list.get(0)){
                System.out.println(list);
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter number to add to list : ");
                int n = scanner.nextInt();
                /**
                 * THREAD 2
                 * here it makes a change to the LIST which is allowed for 'Copy On Write ArrayList'
                 * and no exception is thrown. thus also
                 * Fail Safe is tested here...
                 */
                list.add(n);
                System.out.println("After adding ["+n+"] to the list : ");
                System.out.println(list);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> obj = new CopyOnWriteArrayList<>();

        obj.add(1);
        obj.add(2);
        obj.add(3);

        failSafe(obj);
    }
}