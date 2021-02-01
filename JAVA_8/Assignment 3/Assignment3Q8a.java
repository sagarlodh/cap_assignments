import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

public class Assignment3Q8a {
    public static void failFast(Map<String, String> cityCode) {
        Set<String> keySet = cityCode.keySet();
        Iterator<String> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            /*
             * Thread 1
             * here this line if included will give Concurrent Modification Exception
             * that is Fail Fast is tested here.
             */
            cityCode.put("E","5");         // this is invalid as we cannot update the map using the 'citymap' object

            /*
             * Thread 2
             * here this thread is iterating through the Map
             */
            String city = iterator.next();
            System.out.println(city + "\t" + cityCode.get(city));
        }
    }
    public static void main(String[] args) {
        Map<String,String> citymap = new HashMap<>();
        citymap.put("A","1");
        citymap.put("B","2");
        citymap.put("C","3");
        citymap.put("D","4");
        failFast(citymap);
    }
}