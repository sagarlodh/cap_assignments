import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
class DateClass {
    private int date;
    private int month;
    private int year;
    private String dob;

    public DateClass(int date, int month, int year)
    {
        this.date=date;
        this.month=month;
        this.year=year;
    }

    public String getDOB() { return this.date + "-" + this.month + "-" + this.year; }

    // equals method overridden
    @Override
    public boolean equals(Object o)
    {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }
        DateClass other = (DateClass)o;
        if (this.date == other.date && this.month==other.month) {
            return false;
        }
        return true;
    }
}
public class Assignment3Q4 {
    public void getEmployee(HashMap<DateClass, String> dob,String employeeName)
    {
        String[] values;
        HashMap<String,String> Employees=new HashMap<>();

        //taking input after splitting from ','
        String[] eNamesList = employeeName.split(",");
        StringBuilder v = new StringBuilder();
        for (Map.Entry<DateClass, String> dateClassStringEntry : dob.entrySet()) {
            String name = (String) ((Map.Entry) dateClassStringEntry).getValue();
            v.append(name).append(" ");
        }

        // converting to string
        values= v.toString().split(" ");
        Arrays.sort(values);
        for(int i=0;i<4;i++)
        {
            Employees.put(values[i], eNamesList[i]);
        }

        // printing out the HASHMAP
        System.out.println(Employees);
    }
    public static void main(String[] args)
    {
        Assignment3Q4 a = new Assignment3Q4();
        HashMap<DateClass, String> dob = new HashMap<>();
        /*
         * creating new dates
         */
        DateClass d1 = new DateClass(26,2,1999);
        DateClass d2 = new DateClass(14,6,1989);
        // as said INPUT as
        // date & month same but year diff in relation to D1
        DateClass d3 = new DateClass(26,2,1998);
        DateClass d4 = new DateClass(20,1,1999);


        /*
         * adding dates created
         */
        dob.put(d1,d1.getDOB());
        dob.put(d2,d2.getDOB());
        dob.put(d3,d3.getDOB());
        dob.put(d4,d4.getDOB());

        // passing value as a string as it will be spilt and take as input later
        String employeeName="Anamika,Boy,Chan,Dill";

        /*
         * getting for loops for working in the condition
         */
        for(Map.Entry<DateClass,String> e: dob.entrySet()) {
            for(Map.Entry<DateClass, String> e1: dob.entrySet()) {
                if (!e.getKey().equals(e1.getKey())) {
                    // add '!' before 'e.getValue()' to negate and show the details
                    if (e.getValue().equals(e1.getValue())) {
                        a.getEmployee(dob, employeeName);
                        break;
                    } else {
                        // here it will exit if above condition is not fulfilled
                        System.out.println("Exiting as [ same date same month but diff year found ]");
                        System.exit(0); }
                    break;
                }break; } } }
}