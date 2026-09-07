public class InvalidGardeException extends StudentException {
    public InvalidGardeException(double grade) {
        super("Оценка " + grade + "недопустима (допустимо 0-5)");
    }
}
