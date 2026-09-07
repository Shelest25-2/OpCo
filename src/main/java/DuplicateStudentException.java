public class DuplicateStudentException extends StudentException {
    public DuplicateStudentException(int id) {
        super("Студент с id=" + id + "не найден");
    }
}
