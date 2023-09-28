package dat3.booking;

import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        BookingSystem bookingSystem = new BookingSystem();
        bookingSystem.addCourse("OOP");
        Course course = bookingSystem.getCourse("OOP");

        Student bob = new Student("Bob Per");
        Student alice = new Student("Alice Wonderland");
        Student mads = new Student("Mads Guldbæk");
        Student oliver = new Student("Oliver Viller");
        Student rasmus = new Student("Rasmus Pedersen");

        bob.addCourse(course);
        alice.addCourse(course);
        mads.addCourse(course);
        oliver.addCourse(course);
        rasmus.addCourse(course);

        course.addGroup(bob, alice, mads, oliver, rasmus);
    }
}