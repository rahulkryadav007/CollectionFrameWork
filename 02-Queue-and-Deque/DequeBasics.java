import java.util.ArrayDeque;
import java.util.Deque;

public class DequeBasics {
    public static void main(String[] args) {
        // Deque mein dono ends se add/remove kar sakte hain
        Deque<Integer> deque = new ArrayDeque<>();

        deque.offerFirst(20);
        deque.offerFirst(10);
        deque.offerLast(30);
        deque.offerLast(40);
        System.out.println(deque);

        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollLast());
        System.out.println(deque);

        // ArrayDeque ko stack ki tarah bhi use kar sakte hain
        Deque<String> stack = new ArrayDeque<>();
        stack.push("Java");
        stack.push("DSA");
        System.out.println(stack.pop()); // last pushed item pehle niklega
    }
}
