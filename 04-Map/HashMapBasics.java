import java.util.HashMap;
import java.util.Map;

public class HashMapBasics {
    public static void main(String[] args) {
        // HashMap me data key-value pair me store hota hai
        Map<String, Integer> marks = new HashMap<>();

        // put() key ke saath value add karta hai
        marks.put("Rahul", 85);
        marks.put("Aman", 78);
        marks.put("Riya", 92);
        marks.put("Rahul", 90); // same key par value update ho jayegi

        System.out.println("Marks: " + marks);

        // get() key ki value deta hai; key nahi mili to null
        System.out.println("Rahul marks: " + marks.get("Rahul"));
        // getOrDefault() key missing hone par default value deta hai
        System.out.println("Neha marks: " + marks.getOrDefault("Neha", 0));

        // containsKey() aur containsValue() se search kar sakte hain
        System.out.println("Rahul exists? " + marks.containsKey("Rahul"));
        System.out.println("90 marks present? " + marks.containsValue(90));

        // Entry set se key aur value dono ek saath milte hain
        for (Map.Entry<String, Integer> entry : marks.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // putIfAbsent() tabhi add karega jab key pehle se na ho
        marks.putIfAbsent("Neha", 88);
        // remove() key ko remove karta hai
        marks.remove("Aman");
        System.out.println("Final map: " + marks);
    }
}
