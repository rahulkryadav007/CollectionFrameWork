import java.util.Map;
import java.util.TreeMap;

public class TreeMapBasics {
    public static void main(String[] args) {
        // TreeMap keys ko sorted order mein rakhta hai
        TreeMap<Integer, String> students = new TreeMap<>();

        students.put(103, "Aman");
        students.put(101, "Rahul");
        students.put(102, "Neha");

        System.out.println(students); // keys ascending order mein
        System.out.println(students.get(102));
        System.out.println(students.firstKey());
        System.out.println(students.lastKey());
        System.out.println(students.lowerKey(102)); // 102 se chhoti greatest key
        System.out.println(students.higherKey(102)); // 102 se badi smallest key
        System.out.println(students.floorKey(102));
        System.out.println(students.ceilingKey(102));

        // Entry ke through key aur value dono milte hain
        for (Map.Entry<Integer, String> entry : students.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        students.remove(103);
        System.out.println(students.containsKey(101));
    }
}
