class Parked_CarOwenerList {
    int L = 4;
    int S = 5;
    int Slot = 19;
    public void add_new_car(Assignment3Q7 obj){}
    public void remove_car(String name,int carNo){}

    public String get_parked_car_location(int key){
        // car location with KEY
        String indexs = ""+key;
        String line ;
        if(indexs.length()==3) {
            line = "L : "+indexs.charAt(0)+",S : "+indexs.charAt(1)+",Slot: "+indexs.charAt(2)+".";
        }else { line = "no"; }
        return line;
    }
}
class ParkingSlot {
    private String ownerName;
    private int carNumber;
    private int token;
    private int level;
    private int section;
    private int slot;
    public ParkingSlot(String ownerName, int carNumber, int token, int level, int section, int slot) {
        this.ownerName = ownerName;
        this.carNumber = carNumber;
        this.token = token;
        this.level = level;
        this.section = section;
        this.slot = slot;
    }
    public String getOwnerName() {
        return ownerName;
    }
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    public int getCarNumber() {
        return carNumber;
    }
    public void setCarNumber(int carNumber) {
        this.carNumber = carNumber;
    }
    public int getToken() {
        return token;
    }
    public void setToken(int token) {
        this.token = token;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public int getSection() {
        return section;
    }
    public void setSection(int section) {
        this.section = section;
    }
    public int getSlot() {
        return slot;
    }
    public void setSlot(int slot) {
        this.slot = slot;
    }

    @Override
    public String toString() {
        return "ParkingSlot{" +
                "ownerName='" + ownerName + '\'' +
                ", carNumber=" + carNumber +
                ", token=" + token +
                ", level=" + level +
                ", section=" + section +
                ", slot=" + slot +
                '}';
    }
}

public class Assignment3Q7 {
    private String name;
    private String carModel;
    private int carNo;
    private int mobileNumber;
    private String address;
    public Assignment3Q7(String name, String carModel, int carNo, int mobileNumber, String address) {
        this.name = name;
        this.carModel = carModel;
        this.carNo = carNo;
        this.mobileNumber = mobileNumber;
        this.address = address;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCarModel() { return carModel; }
    public void setCarModel(String carModel) { this.carModel = carModel; }
    public int getCarNo() { return carNo; }
    public void setCarNo(int carNo) { this.carNo = carNo; }
    public int getMobileNumber() { return mobileNumber; }
    public void setMobileNumber(int mobileNumber) { this.mobileNumber = mobileNumber; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public static void main(String[] args) {}
}