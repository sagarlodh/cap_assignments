import java.util.ArrayList;

public class Assignment4Q4 {
    public ArrayList<String> removeOddLength(ArrayList<String> employeeList){
        employeeList.removeIf(word -> word.length() % 2 != 0);
        return employeeList;
    }
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("crow");
        list.add("dog");
        list.add("animal");
        list.add("bully");
        Assignment4Q4 a = new Assignment4Q4();
        System.out.println(a.removeOddLength(list));
    }
}

