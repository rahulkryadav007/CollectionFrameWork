import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueBasics {
    public static void main(String[] args) {
        // Default PriorityQueue mein smallest element pehle aata hai
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(40);
        minHeap.offer(10);
        minHeap.offer(30);
        minHeap.offer(20);

        System.out.println(minHeap.peek());
        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.poll()); // priority order mein remove
        }

        // Reverse order: max heap jaisa behavior
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.offer(10);
        maxHeap.offer(50);
        maxHeap.offer(30);
        System.out.println(maxHeap.poll());
    }
}
