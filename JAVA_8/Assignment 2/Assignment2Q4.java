/**
 * abstract class cannot be Private as then this will give us
 * as error as it cannot be accessed outside into other classes
 *
 * also this Abstract class cannot be set as FINAL as then it cannot be
 * augmented further or changed or overridden
 */
abstract class Question{
    public Question( ) {
        // default constructor
    }
    /**
     * here we have some methods which are not abstract but still we can
     * declare this class as abstract
     */
    public void isHard(){
        System.out.println("it is hard...");
    }
    public void isEasy() {
        System.out.println("it is easy...");
    }
    /**
     * since this abstract method has to be overridden in child classes
     * we also need to declare the class as Abstract
     */
    public abstract void skip();
}

/**
 * using inheritance
 */
class levelOfDifficulty extends Question{
    public levelOfDifficulty( ) {
    }
    /**
     * since we are extending an Abstract class, we need to
     * override the abstract method too or also we can declare this class as Abstract
     */
    @Override
    public void skip() {
        System.out.println("question is skipped...");
    }
}
public class Assignment2Q4{
    public static void main(String[] args) {
        Question an = new levelOfDifficulty( );
        /**
         * these are the methods from the abstract class to which
         * we have gained access as it is inherited
         */
        an.isEasy();
        an.isHard();
        /**
         * here it is the overridden method from the abstract class
         */
        an.skip();

        /**
         * here below we observe that as 'Question' class is abstract,
         * it cannot be instantiated
         */
        //Question q = new Question();
    }
}