import java.util.*;
class Student {
    //private int subjectA,subjectB,subjectC;
    public int studentsTotalMarksInAllSubjects(int[] students) {
        int sum=0;
        for(int i=0;i<3;i++){
            sum = sum + students[i];
        }
        return sum;
    }
    public double studentsAverageMarksInAllSubjects(int[] students) {
        double avg=0;
        for(int i=0;i<3;i++){
            avg =  studentsTotalMarksInAllSubjects(students)/3.0;
        }
        return avg;
    }
    //public int[] subjectWiseMarks(Student[] students,String subjectName){ }
    public int subjectATotalByStudents(int[] marks1) {
        int tSA;
        tSA = marks1[0]+marks1[1]+marks1[2];
        return tSA;
    }
    public int subjectBTotalByStudents(int[] marks2) {
        int tSB;
        tSB = marks2[0]+marks2[1]+marks2[2];
        return tSB;
    }
    public int subjectCTotalByStudents(int[] marks3) {
        int tSC;
        tSC = marks3[0]+marks3[1]+marks3[2];
        return tSC;
    }
    //public int (subjectTotalByStudents(int[] marks);
    public double subjectAAverageByStudents(int[] marks1) {
        double avgSA;
        avgSA = subjectATotalByStudents(marks1)/3.0;
        return avgSA;
    }
    public double subjectBAverageByStudents(int[] marks2) {
        double avgSB;
        avgSB = subjectATotalByStudents(marks2)/3.0;
        return avgSB;
    }
    public double subjectCAverageByStudents(int[] marks3) {
        double avgSC;
        avgSC = subjectATotalByStudents(marks3)/3.0;
        return avgSC;
    }
}
public class Assignment1Q9 {
    public static void main(String[] args) {
            /*
             * initializing arrays for subjects
             */
            int[] mark1 = new int[3];
            int[] mark2 = new int[3];
            int[] mark3 = new int[3];
            Scanner s = new Scanner(System.in);
            for (int i = 0; i < 3; i++) {
                System.out.println("Enter marks for A,B,C sub : ");
                mark1[i] = s.nextInt();
                mark2[i] = s.nextInt();
                mark3[i] = s.nextInt();
            }
            Assignment1Q9 tt = new Assignment1Q9();
            /*
             * getting the total marks for further calculation
             */
            int[] yo;
            yo = tt.total(mark1,mark2,mark3);
            Student sd = new Student();
        System.out.println(sd.studentsTotalMarksInAllSubjects(yo));
        System.out.println("----------------------------------------");
        System.out.println(sd.studentsAverageMarksInAllSubjects(yo));
        System.out.println("----------------------------------------");
        System.out.println(sd.subjectATotalByStudents(mark1));
        System.out.println(sd.subjectAAverageByStudents(mark1));
        System.out.println(sd.subjectBTotalByStudents(mark2));
        System.out.println(sd.subjectBAverageByStudents(mark2));
        System.out.println(sd.subjectCTotalByStudents(mark3));
        System.out.println(sd.subjectCAverageByStudents(mark3));
    }
    /*
     * upper method call passing here for calculation
     */
    public int[] total(int[] mark1, int[] mark2, int[] mark3){
        int[] total = new int[3];
        for(int i=0;i<3;i++){
            total[i] = mark1[i]+mark2[i]+mark3[i];
        }
        return total;
    }

}
