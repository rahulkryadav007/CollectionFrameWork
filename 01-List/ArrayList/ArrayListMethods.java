import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayListMethods {
    public static void main(String[] args) {
        // ArrayList banayi jisme fruits ke naam store honge
        ArrayList<String> fruits = new ArrayList<>(Arrays.asList("Apple", "Mango", "Banana"));

        // add() se new element add hota hai
        fruits.add("Orange");
        // Index 1 par element insert kar rahe hain
        fruits.add(1, "Grapes");
        System.out.println("After add: " + fruits);

        // get() se given index ka element milta hai
        System.out.println("Index 2: " + fruits.get(2));

        // set() existing index ki value replace karta hai
        fruits.set(0, "Pineapple");

        // contains() check karta hai element present hai ya nahi
        System.out.println("Has Mango? " + fruits.contains("Mango"));
        // indexOf() first matching element ka index deta hai
        System.out.println("Mango index: " + fruits.indexOf("Mango"));

        // remove() index ya object ke basis par remove kar sakta hai
        fruits.remove("Banana");
        fruits.remove(0);
        System.out.println("After remove: " + fruits);

        // size() total elements aur isEmpty() empty check karta hai
        System.out.println("Size: " + fruits.size());
        System.out.println("Empty? " + fruits.isEmpty());

        // Sorting ke liye Collections.sort() use kar sakte hain
        Collections.sort(fruits);
        System.out.println("Sorted: " + fruits);

        // for-each loop se har element access kar rahe hain
        for (String fruit : fruits) {
            System.out.println("Fruit: " + fruit);
        }

        // clear() saare elements remove kar deta hai
        fruits.clear();
        System.out.println("After clear: " + fruits);
    }
}
