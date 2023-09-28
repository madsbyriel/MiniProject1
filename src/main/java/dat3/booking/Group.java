package dat3.booking;

import java.util.HashSet;
import java.util.Set;

public class Group {
    Set<Student> students;

    {
        this.students = new HashSet<>(6);
    }

    public Group() {

    }

    public boolean addStudent(Student student) {
        if (this.students.size() >= 6) return false;
        this.students.add(student);
        return true;
    }
}