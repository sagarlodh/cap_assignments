import java.util.HashMap;
import java.util.Map;

class Employee {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        /**
         * always returns TRUE
         */
        return true;
    }

    @Override
    public int hashCode() {
        /**
         * returns a FIXED NUMBER
         */
        return 1;
    }
}

public class Assignment3Q5 {
    public static void main(String[] args) {
        HashMap<Employee, Integer> hm = new HashMap<>();
        Employee e = new Employee("roy",1);
        Employee e1 = new Employee("tor",2);
        /**
         * here we put into Hashmap, two key-value pairs
         * with Employee objects as key
         *
         * which should store into different buckets into the hashmap
         *
         * but we see that since the 'Overridden' methods of
         * hashcode and equals are tampered, all key-value pairs
         * get into 1 bucket only and also update the last value if there
         */
        hm.put(e,300);
        /**
         * putting '200' as value with the same key will update the value of the same bucket only
         * and print 200
         */
        hm.put(e1,200);
        /**
         * both will print the same value '200'
         */
        System.out.println(hm.get(e));
        System.out.println(hm.get(e1));
        for(Map.Entry<Employee, Integer> entry: hm.entrySet()) {
            // here we can check that the key is same,but value gets overridden
            // print the corresponding key by entering the specific value
            if(entry.getValue() == 300) {
                System.out.println("The key for value is " + entry.getKey());
                break;
            }
        }

    }
}

