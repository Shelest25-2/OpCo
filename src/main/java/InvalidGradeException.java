public class InvalidGradeException extends StudentException {
    public InvalidGradeException(double grade) {
        super("Оценка " + grade + "недопустима (допустимо 0-5)");
    }
}
