import java.util.*;
import java.util.stream.Collectors;

public class StudentService {
    private List<Student> students = new ArrayList<>();

    public Student getFirstStudent(){
        return students.getFirst();
    }

    public List<Student> getAllStudents(){
        return students;
    }

    // Задача 1.1: Добавление студентов
    public void addStudent(Student student) throws DuplicateStudentException{
        if(students.stream().anyMatch(s->s.getId()==student.getId()))
            throw new DuplicateStudentException(student.getId());
        students.add(student);
    }

    public List<Student> getExcellentStudents() {
        return students.stream().filter(s -> Double.parseDouble(s.getAverageGrade()) >4.5).toList();
    }

    public Map<String,List<Student>> groupByGroup(){
        return students.stream().collect(Collectors.groupingBy(Student::getGroup));
    }

    public Optional<Student> getBestStudent(){
        return students.stream()
                .max(Comparator.comparingDouble(student ->
                        Double.parseDouble(student.getAverageGrade())
                        ));
    }

    public List<Student> sortByGradeDesc(){
        return students.stream()
                .sorted(Comparator.comparing(Student::getAverageGrade).reversed())
                .toList();
    }

    public double getAverageGradeByGroup(String group){
        return students.stream().filter(s-> s.getGroup().equals(group))
                .mapToDouble(s->Double.parseDouble(s.getAverageGrade()))
                .average().orElse(0);
    }

    public void removeBelowThree(){
        students = students.stream()
                .filter(s-> Double.parseDouble(s.getAverageGrade()) >=3)
                .toList();
    }

    public Student findStudentById(int id) throws StudentNotFoundException{
        for(Student s: students)
            if(s.getId()==id)
                return s;
        throw new StudentNotFoundException(id);
    }

    public void setAverageGrade(int studentId, double grade)
    throws StudentNotFoundException,InvalidGradeException{
        if(grade<0 || grade>5)
            throw new InvalidGradeException(grade);
        Student tempStudent = students.stream().filter(s->s.getId()==studentId).findFirst().orElse(null);
        if(tempStudent==null)
            throw new StudentNotFoundException(studentId);

        tempStudent.setAverageGrade(Double.toString(grade));
    }

    public List<Student> getStudentsByGroup(String group) throws EmptyGroupException{
        List<Student> tempStudents = students.stream().filter(s->s.getGroup().equals(group)).toList();
        if(tempStudents.isEmpty())
            throw new EmptyGroupException(group);
        return tempStudents;
    }
























}
