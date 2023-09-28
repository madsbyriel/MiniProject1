package dat3.booking;
import java.util.HashSet;
import java.util.Set;

public class Course {
    private final String courseName;
    private final Set<Student> students;
    private final Set<Group> groups;

    /* Initialization */
    {
        this.students = new HashSet<>();
        this.groups   = new HashSet<>();
    }

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void removeStudent(Student student) {
        this.students.remove(student);
    }

    public boolean addGroup(Student... students) {
        Group group = new Group();
        for (Student student : students) {
            if (!this.students.contains(student)) return false;
            if (student.hasCourseGroup(this)) return false;
            if (!group.addStudent(student)) return false;
        }

        this.groups.add(group);
        for (Student student : students) {
            student.addCourseGroup(this, group);
        }

        return true;
    }

    public Set<Student> getStudents() {
        return this.students;
    }
}