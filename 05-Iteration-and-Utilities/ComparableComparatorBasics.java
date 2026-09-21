import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Student implements Comparable<Student> {
    int marks;
    String name;

    Student(int marks, String name) {
        this.marks = marks;
        this.name = name;
    }

    // Comparable: class ke andar natural/default sorting define karte hain
    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.marks, other.marks);
    }

    @Override
    public String toString() {
        return name + " - " + marks;
    }
}

public class ComparableComparatorBasics {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(78, "Aman"));
        students.add(new Student(92, "Neha"));
        students.add(new Student(85, "Rahul"));

        students.sort(null); // Comparable ka natural order: marks ascending
        System.out.println(students);

        // Comparator: class ko change kiye bina alternate sorting
        students.sort(Comparator.comparing(student -> student.name));
        System.out.println(students);

        students.sort(Comparator.comparingInt((Student student) -> student.marks).reversed());
        System.out.println(students);
    }
}
