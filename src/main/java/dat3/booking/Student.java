package dat3.booking;

import java.util.HashMap;
import java.util.HashSet;

public class Student {
    private final HashSet<Course> courses;
    private final String name;
    private final HashMap<Course, Group> courseGroup;

    {
        this.courses     = new HashSet<>();
        this.courseGroup = new HashMap<>();
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public boolean addCourse(Course course) {
        if (this.courses.size() > 5) return false;
        this.courses.add(course);
        course.addStudent(this);
        return true;
    }

    public boolean removeCourse(Course course) {
        course.removeStudent(this);
        return courses.remove(course);
    }

    public void addCourseGroup(Course course, Group group) {
        this.courseGroup.put(course, group);
    }

    public boolean hasCourseGroup(Course course) {
        return courseGroup.containsKey(course);
    }
}