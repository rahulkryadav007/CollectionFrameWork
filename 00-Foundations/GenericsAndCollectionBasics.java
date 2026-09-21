import java.util.ArrayList;
import java.util.List;

public class GenericsAndCollectionBasics {
    public static void main(String[] args) {
        // Array: fixed size after creation.
        int[] marks = {80, 90, 75};

        // List interface + ArrayList implementation: resizable sequence.
        // Generics (<String>) restrict this list to String values at compile time.
        List<String> names = new ArrayList<>();
        names.add("Asha");
        names.add("Rahul");
        names.add("Asha"); // List allows duplicates.

        System.out.println("First mark: " + marks[0]);
        System.out.println("Names: " + names);
        System.out.println("Count: " + names.size());
        System.out.println("First name: " + names.get(0));

        // Enhanced for loop visits each element in iteration order.
        for (String name : names) {
            System.out.println("Hello, " + name);
        }
    }
}
