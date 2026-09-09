public class EmptyGroupException extends StudentException {
    public EmptyGroupException(String group) {
        super("Студентов в группе = " + group + " не найдено");
    }
}
