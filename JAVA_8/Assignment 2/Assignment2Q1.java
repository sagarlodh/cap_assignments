class SingletonInheritanceCheck{
    public static SingletonInheritanceCheck sic = null;
    private SingletonInheritanceCheck(){
        System.out.println("Instance created");
    }
    public static SingletonInheritanceCheck getInstance(){
        if(sic ==  null){
            sic = new SingletonInheritanceCheck();
        }
        return sic;
    }
}
/*
 * just to check whether upon Inheriting the above class
 * we get an error or not
 *
 * this class can be removed to only make a singleton program if needed
 */
class createCheck extends SingletonInheritanceCheck{
    /**
     * here we get an error because of this inheritance from the above class
     * because of the 'PRIVATE' constructor.
     * inorder to resolve it we need to declare it as 'PUBLIC' , but then Singleton concept is not there anymore
     * Therefore this confirms that a Singleton class can not be inherited.
     */
}
public class Assignment2Q1 {
    public static void main(String[] args) {
        SingletonInheritanceCheck sIC = SingletonInheritanceCheck.getInstance();

        /*
         * here we also confirm the same by creating an instance of the extended class and
         * it gives us an error that of 'PRIVATE access'
         */
        createCheck chk = new SingletonInheritanceCheck();
    }
}