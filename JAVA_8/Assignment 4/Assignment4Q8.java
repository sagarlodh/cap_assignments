import java.util.ArrayList;

public class Assignment4Q8 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Assignment4Q8 a = new Assignment4Q8();
        //a.run(list);
        /*
         * creating a new thread and running the list
         * as stream for each element and printing
         * them out
         */
        Thread t = new Thread(() -> list.stream().forEach(System.out::println));
        t.start();
    }
}