import java.util.LinkedList;

public class LinkedListBasics {
    public static void main(String[] args) {
        // LinkedList me elements ko add/remove karna convenient hota hai
        LinkedList<String> tasks = new LinkedList<>();

        // add() end me element add karta hai
        tasks.add("Study Java");
        tasks.add("Practice DSA");
        tasks.add("Revise Collections");

        // addFirst() aur addLast() se dono ends par add kar sakte hain
        tasks.addFirst("Wake up");
        tasks.addLast("Sleep");
        System.out.println("Tasks: " + tasks);

        // getFirst() aur getLast() dono ends ke elements dete hain
        System.out.println("First task: " + tasks.getFirst());
        System.out.println("Last task: " + tasks.getLast());

        // removeFirst() aur removeLast() ends se elements hataate hain
        tasks.removeFirst();
        tasks.removeLast();
        System.out.println("After removing ends: " + tasks);

        // Queue ki tarah bhi LinkedList use kar sakte hain
        tasks.offer("Attend interview");
        System.out.println("Queue front: " + tasks.peek());
        System.out.println("Removed front: " + tasks.poll());
        System.out.println("Final tasks: " + tasks);
    }
}
