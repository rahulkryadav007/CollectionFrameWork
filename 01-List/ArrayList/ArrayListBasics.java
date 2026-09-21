import java.util.ArrayList;
import java.util.List;

public class ArrayListBasics {
    public static void main(String[] args) {
        // List preserves insertion order and allows duplicates.
        // ArrayList is a resizable-array implementation of List.
        List<String> subjects = new ArrayList<>();

        // Add elements at the end.
        subjects.add("Java");
        subjects.add("DSA");
        subjects.add("SQL");
        subjects.add("Java"); // Duplicate is allowed.

        System.out.println("All subjects: " + subjects);
        System.out.println("Element at index 1: " + subjects.get(1));
        System.out.println("Number of elements: " + subjects.size());

        // Insert at index 1; later elements shift right.
        subjects.add(1, "OOP");

        // Replace the value at index 0.
        subjects.set(0, "Core Java");

        // Remove the first matching value.
        subjects.remove("SQL");

        // Check membership and traverse the list.
        System.out.println("Contains DSA? " + subjects.contains("DSA"));
        for (String subject : subjects) {
            System.out.println("- " + subject);
        }

        // Typical complexity: get/set O(1); append amortized O(1);
        // insertion/removal near the front or middle O(n) due to shifting.
    }
}
