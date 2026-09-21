import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsUtilityBasics {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(List.of(40, 10, 30, 20, 10));

        Collections.sort(nums); // ascending sort
        System.out.println(nums);
        Collections.reverse(nums); // current order reverse
        System.out.println(nums);
        Collections.shuffle(nums); // random order
        System.out.println(nums);

        System.out.println(Collections.max(nums));
        System.out.println(Collections.min(nums));
        System.out.println(Collections.frequency(nums, 10));
        System.out.println(Collections.binarySearch(nums, 30));
        // binarySearch se pehle list sorted honi chahiye
        Collections.sort(nums);
        System.out.println(Collections.binarySearch(nums, 30));

        List<Integer> fixed = Collections.nCopies(3, 7);
        System.out.println(fixed); // [7, 7, 7], fixed-size/unmodifiable result
    }
}
