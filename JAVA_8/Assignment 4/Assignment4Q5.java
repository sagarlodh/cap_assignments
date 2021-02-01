import java.util.Arrays;
import java.util.List;

public class Assignment4Q5 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("alpha", "bravo", "charlie", "delta", "echo", "foxtrot");
        Assignment4Q5 a = new Assignment4Q5();
        System.out.println(a.processWords(list));
    }

    public String processWords(List<String> list) {
        //String result = list.stream().map(s -> Character.toString(s.charAt(0)));
        /* LAMBDA used
         * pushing the list into a stream and mapping it character wise only at the position '0'
         * and finally adding them
         */
        String result = list.stream().map(s -> Character.toString(s.charAt(0))).reduce("", (a, b) -> a + b);
        return result;
    }
}
