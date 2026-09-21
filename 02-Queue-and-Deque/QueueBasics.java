import java.util.LinkedList;
import java.util.Queue;

public class QueueBasics {
    public static void main(String[] args) {
        // Queue generally FIFO follow karti hai: First In, First Out
        Queue<String> queue = new LinkedList<>();

        queue.offer("Rahul");
        queue.offer("Aman");
        queue.offer("Neha");

        System.out.println(queue);
        System.out.println(queue.peek()); // front element dekho, remove nahi hoga
        System.out.println(queue.poll()); // front element remove karke return
        System.out.println(queue);

        queue.add("Priya");
        System.out.println(queue.element()); // head dekhta hai; empty queue par exception
        System.out.println(queue.remove()); // head remove; empty queue par exception

        System.out.println("Size: " + queue.size());
        System.out.println("Empty? " + queue.isEmpty());
    }
}
