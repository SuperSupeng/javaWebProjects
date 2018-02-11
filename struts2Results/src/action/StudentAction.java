package action;

import domain.Student;

public class StudentAction {
    private Student student = new Student();

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String save() {
        System.out.println(student);
        return "none";
    }
}
