package dat3.booking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class BookingSystem {
    HashMap<String, Course> courses;

    {
        this.courses = new HashMap<>();
    }

    public boolean addCourse(String name) {
        if (this.courses.containsKey(name)) return false;
        Course course = new Course(name);

        this.courses.put(name, course);

        return true;
    }

    public Course getCourse(String name) {
        return this.courses.get(name);
    }

    public Set<Student> getAllStudents() {
        Set<Student> students = new HashSet<>();

        for (String key : this.courses.keySet()) {
            students.addAll(this.courses.get(key).getStudents());
        }

        return students;
    }
}