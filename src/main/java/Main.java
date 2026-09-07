import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n =sc.nextInt();

        StudentService studentService = new StudentService();

        for(int i=0;i<n;i++){
            studentService.addStudent(new Student(sc.nextInt(),sc.next(),sc.next(),sc.next()));
        }

        System.out.println(studentService.getExcellentStudents());
        System.out.println(studentService.groupByGroup());
        System.out.println(studentService.getBestStudent());
        System.out.println(studentService.sortByGradeDesc());
        System.out.println(studentService.getAverageGradeByGroup(studentService.getFirstStudent().getGroup()));
        studentService.removeBelowThree();
        System.out.println(studentService.getAllStudents());







    }
}