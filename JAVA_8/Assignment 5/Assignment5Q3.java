import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
class Trader {
    private String name;
    private String city;

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() { return name; }

    public String getCity() { return city; }
}
public class Assignment5Q3 {
    public static List<String> printUniqueCities (List <Trader> traders) {
        traders.stream()
                //.filter()
                //.sorted(Comparator.comparing(Trader::getCity))
                .map(Trader::getCity)
                .distinct()
                .forEach(System.out::println);

        return null;
    }

    public static List<String> tradersFromPuneSortByName(List<Trader> traders) {
        traders.stream().filter(o -> o.getCity()=="pune")
                .map(Trader::getName)
                .forEach(System.out::println);
        return new ArrayList<>();

    }
    // concatenation as a string
    public static String allTrader3Names(List<Trader> traders) {
        String indore = traders.stream()
                .map(t -> t.getName())
                .sorted()
                .collect(Collectors.joining(" "));
        return indore;
    }
    // we can change the return type but then adding becomes a problem to
    // look into
    public static ArrayList<Trader> areAnyTradersFromIndore(ArrayList<Trader> traders) {
        ArrayList<String> tt = new ArrayList<>();
        String s = "Fetched Results";
        traders.stream().forEach(o ->{
            if(o.getCity()=="indore"){
                tt.add(o.getName());
            }
        });
        System.out.println(s + " -> "+ tt);
        System.out.println("``````````````````````````````");
        return null;
    }
    public static void main(String[] args) {
        /*
         * generating traders
         */
        Trader trader1 = new Trader("karn","pune");
        Trader trader2 = new Trader("yudhishthir","andra");
        Trader trader3 = new Trader("bheem","delhi");
        Trader trader4 = new Trader("arjun","indore");
        Trader trader5 = new Trader("nakul","calcutta");
        Trader trader6 = new Trader("sahadev","pune");
        Trader trader7 = new Trader("krishna","indore");

        ArrayList<Trader> traderList = new ArrayList<>();
        /*
         * adding traders
         */
        traderList.add(trader1);
        traderList.add(trader2);
        traderList.add(trader3);
        traderList.add(trader4);
        traderList.add(trader5);
        traderList.add(trader6);
        traderList.add(trader7);
        System.out.println("Unique cities : ");
        printUniqueCities(traderList);
        System.out.println("`````````````````````````````````````````");
        System.out.println("Traders from Pune by Name :");
        tradersFromPuneSortByName(traderList);
        System.out.println("`````````````````````````````````````````");
        System.out.println("String of all Trader Names Sorted Alphabet-wise :");
        System.out.println("\t"+allTrader3Names(traderList));
        System.out.println("`````````````````````````````````````````");
        System.out.println("Are there any traders from indore :");
        System.out.println(areAnyTradersFromIndore(traderList));

    }
}