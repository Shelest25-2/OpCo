public class Student {
    private int id;
    private String name;
    private String group;
    private String averageGrade;

    public Student(int id, String name, String group, String averageGrade){
        this.id=id;
        this.name=name;
        this.group=group;
        this.averageGrade=averageGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", averageGrade='" + averageGrade + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getGroup() {
        return group;
    }

    public void setAverageGrade(String averageGrade) {
        this.averageGrade = averageGrade;
    }

    public String getAverageGrade() {
        return averageGrade;
    }
}
