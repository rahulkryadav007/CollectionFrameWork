import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetBasics {
    public static void main(String[] args) {
        // HashSet duplicate values ko store nahi karta
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(30);
        hashSet.add(10);
        hashSet.add(20);
        hashSet.add(10); // duplicate hai, isliye add nahi hoga
        System.out.println("HashSet: " + hashSet); // order fixed nahi hai

        // LinkedHashSet insertion order maintain karta hai
        Set<Integer> linkedSet = new LinkedHashSet<>();
        linkedSet.add(30);
        linkedSet.add(10);
        linkedSet.add(20);
        linkedSet.add(10);
        System.out.println("LinkedHashSet: " + linkedSet);

        // TreeSet elements ko sorted order me rakhta hai
        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(30);
        treeSet.add(10);
        treeSet.add(20);
        treeSet.add(10);
        System.out.println("TreeSet: " + treeSet);

        // contains() se check karte hain ki value present hai ya nahi
        System.out.println("Contains 20? " + treeSet.contains(20));
        // remove() given value ko Set se hata deta hai
        treeSet.remove(10);
        System.out.println("After remove: " + treeSet);
    }
}
