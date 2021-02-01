abstract class Persistence {
    abstract public String persist();
}
class FilePersistence extends Persistence{
    @Override
    public String persist() {
        System.out.println("Saved in File");
        return null;
    }
}
class DatabasePersistence extends Persistence{
    @Override
    public String persist() {
        System.out.println("Saved in Database");
        return null;
    }
}
class client{
    Persistence pr = new FilePersistence();
    public String getFile() {
        return pr.persist();
    }
    Persistence fr = new DatabasePersistence();
    public String getData() {
        return fr.persist();
    }
}
public class Assignment2Q6 extends client {
    public static void main(String[] args) {
        client cl = new client();
        cl.getFile();
        cl.getData();
    }
}