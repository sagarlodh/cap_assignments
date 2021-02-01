class ResultDeclaration{
    public String declareResults( double subject1Marks, double subject2Marks, double subject3Marks) {
        int flag=0;
        if(subject1Marks+subject2Marks+subject3Marks > 60){
            if((subject1Marks>60 && subject2Marks<60 && subject3Marks<60)||(subject2Marks>60 && subject1Marks<60 && subject3Marks<60)||
                    (subject3Marks>60 && subject1Marks<60 && subject2Marks<60)){
                System.out.println("failed");
                flag=1;
            }
            if(flag == 1) {
                flag=0;
            }
            else {
                if (subject1Marks + subject2Marks + subject3Marks > 60) {
                    System.out.println("passed");

                }
                if ((subject1Marks + subject2Marks > 60) || (subject1Marks + subject3Marks > 60) || (subject2Marks + subject3Marks > 60)) {
                    System.out.println("promoted");
                }
            }
        }
        else{
            System.out.println("Failed");
        }
        return null;
    }
}
public class Assignment1Q4 {
    public static void main(String[] args) {
        ResultDeclaration rd = new ResultDeclaration();
        rd.declareResults(10,10,10);
        rd.declareResults(70,10,10);
        rd.declareResults(10,20,40);
        rd.declareResults(10,30,40);
    }
}