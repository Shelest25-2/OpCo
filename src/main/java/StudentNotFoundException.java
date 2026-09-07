public class StudentNotFoundException extends RuntimeException {
    private int studentId;
    public StudentNotFoundException(int id) {

        super("Студент с id=" + id + "не найден");
//        this.studentId=id;
    }

//    public int getStudentId(){
//        return studentId;
//    }
}
