import java.util.ArrayDeque;
import java.util.Deque;

public class StackBasics {
    public static void main(String[] args) {
        // Stack ke rule ko yaad rakho: LIFO (Last In, First Out)
        // Java mein new code ke liye ArrayDeque stack ke roop mein use kar sakte hain
        Deque<String> stack = new ArrayDeque<>();

        stack.push("First");
        stack.push("Second");
        stack.push("Third");

        System.out.println(stack.peek()); // top element, remove nahi hoga
        System.out.println(stack.pop());  // top element remove hoga
        System.out.println(stack);

        System.out.println(stack.isEmpty());
        System.out.println(stack.size());
    }
}
