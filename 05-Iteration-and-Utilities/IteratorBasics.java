import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IteratorBasics {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Rahul");
        names.add("Aman");
        names.add("Neha");

        // Iterator se collection ko safely traverse kar sakte hain
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            String name = it.next();
            if (name.equals("Aman")) {
                it.remove(); // iterate karte waqt remove karne ka safe tareeka
            }
        }
        System.out.println(names);

        // ListIterator forward aur backward dono direction mein ja sakta hai
        ListIterator<String> listIt = names.listIterator();
        while (listIt.hasNext()) {
            System.out.println(listIt.next());
        }
        while (listIt.hasPrevious()) {
            System.out.println(listIt.previous());
        }
    }
}
