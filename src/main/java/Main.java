import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n =sc.nextInt();

        StudentService studentService = new StudentService();

        try {

            for (int i = 0; i < n; i++) {
                studentService.addStudent(new Student(sc.nextInt(), sc.next(), sc.next(), sc.next()));
            }
        }
        catch (DuplicateStudentException exception){
            System.out.println(exception.toString());
        }
//        finally {
//
//        }

        int id= sc.nextInt();
        try{
            System.out.println(studentService.findStudentById(id));
        } catch (StudentNotFoundException e) {
            System.out.println(e.toString());
        }
//        finally {
//
//        }

        double averageGrade = sc.nextDouble();
        try{
            studentService.setAverageGrade(id,averageGrade);
        } catch (InvalidGradeException e) {
            System.out.println(e.toString());
        }
//        finally {
//
//        }

        String group = sc.next();
        try{
            System.out.println(studentService.getStudentsByGroup(group));
        }
        catch (EmptyGroupException e){
            System.out.println(e.toString());
        }
//        finally {
//
//        }



//        System.out.println(studentService.getExcellentStudents());
//        System.out.println(studentService.groupByGroup());
//        System.out.println(studentService.getBestStudent());
//        System.out.println(studentService.sortByGradeDesc());
//        System.out.println(studentService.getAverageGradeByGroup(studentService.getFirstStudent().getGroup()));
//        studentService.removeBelowThree();
//        System.out.println(studentService.getAllStudents());







    }
}