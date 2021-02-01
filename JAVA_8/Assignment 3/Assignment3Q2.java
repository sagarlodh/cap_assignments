import java.util.HashSet;
import java.util.LinkedHashSet;

public class Assignment3Q2 {
    public static void main(String[] args) {
        /**
         * creating object of Linked Hash Set
         */
        LinkedHashSet<String> lHS = new LinkedHashSet<>();

        /**
         * creating object of Hash Set
         */
        HashSet<String> hS = new HashSet<>();


        System.out.println("Linked Hash Set : ");
        System.out.println(ordered(lHS));;
        System.out.println("-------------------------------------------");
        System.out.println("Hash Set : ");
        System.out.println(unordered(hS));;

    }
    public static LinkedHashSet ordered(LinkedHashSet linkedHashSet){
        /**
         * order will be maintained
         */
        linkedHashSet.add("India");
        linkedHashSet.add("UK");
        linkedHashSet.add("Colombia");
        linkedHashSet.add("Denmark");
        linkedHashSet.add("Ecuador");
        return linkedHashSet;
    }
    public static HashSet unordered(HashSet hashSet){
        /**
         * order will not be maintained
         */
        hashSet.add("India");
        hashSet.add("UK");
        hashSet.add("Colombia");
        hashSet.add("Denmark");
        hashSet.add("Ecuador");
        return hashSet;
    }
}