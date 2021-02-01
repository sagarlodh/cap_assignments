import java.util.ArrayList;
import java.util.List;

public class Assignment4Q6 {
    public static void main(String[] args) {

        Assignment4Q6 a = new Assignment4Q6();
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("dog");
        list.add("cat");
        System.out.println(a.convertToUpperCase(list));
    }
    public List<String> convertToUpperCase(List<String> list) {
        list.replaceAll(s -> s.toUpperCase());
        return list;
    }
}