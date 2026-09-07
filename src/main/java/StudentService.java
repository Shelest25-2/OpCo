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
    public void addStudent(Student student){
        students.add(student);
    }

    // Задача 1.2: Найти всех студентов с оценкой > 4.5
    public List<Student> getExcellentStudents() {
        return students.stream().filter(s -> Double.parseDouble(s.getAverageGrade()) >4.5).toList();
    }

    // Задача 1.3: Сгруппировать студентов по группе
    public Map<String,List<Student>> groupByGroup(){
        return students.stream().collect(Collectors.groupingBy(Student::getGroup));
    }

    // Задача 1.4: Найти студента с лучшей средней оценкой
    public Optional<Student> getBestStudent(){
        return students.stream()
                .max(Comparator.comparingDouble(student ->
                        Double.parseDouble(student.getAverageGrade())
                        ));
    }

    // Задача 1.5: Отсортировать по оценке (по убыванию)
    public List<Student> sortByGradeDesc(){
        return students.stream()
                .sorted(Comparator.comparing(Student::getAverageGrade).reversed())
                .toList();
    }

    // Задача 1.6: Посчитать среднюю оценку по группе
    public double getAverageGradeByGroup(String group){
        return students.stream().filter(s-> s.getGroup().equals(group))
                .mapToDouble(s->Double.parseDouble(s.getAverageGrade()))
                .average().orElse(0);
    }

    // Задача 1.7: Удалить студентов с оценкой < 3.0
    public void removeBelowThree(){
        students = students.stream()
                .filter(s-> Double.parseDouble(s.getAverageGrade()) >=3)
                .toList();
    }

























}
