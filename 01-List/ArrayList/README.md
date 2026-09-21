# ArrayList - My Notes

## 1. What is ArrayList?
`ArrayList` is a resizable array from the Java Collections Framework. Normal arrays have a fixed length; an ArrayList can grow or shrink as we add or remove elements.

```java
ArrayList<String> names = new ArrayList<>();
```

`ArrayList` maintains insertion order, allows duplicate values, and allows `null`. It is not synchronized, so it is not automatically thread-safe.

## 2. Import and create
```java
import java.util.ArrayList;
ArrayList<Integer> numbers = new ArrayList<>();
ArrayList<String> names = new ArrayList<>(20); // initial capacity, not fixed size
```
Use wrapper types such as `Integer`, not primitive `int`, because collections store objects.

## 3. Important methods
| Method | What it does |
|---|---|
| `add(value)` | Adds element at the end |
| `add(index, value)` | Inserts at index; shifts later elements |
| `get(index)` | Returns element at index |
| `set(index, value)` | Replaces element at index |
| `remove(index)` | Removes element at index |
| `remove(Object)` | Removes first matching value |
| `contains(value)` | Checks whether value exists |
| `indexOf(value)` | First matching index, or `-1` |
| `lastIndexOf(value)` | Last matching index, or `-1` |
| `size()` | Number of elements |
| `isEmpty()` | Checks whether list has no elements |
| `clear()` | Removes all elements |
| `toArray()` | Converts list to an array |
| `addAll(collection)` | Adds all elements from another collection |
| `removeAll(collection)` | Removes matching elements |
| `retainAll(collection)` | Keeps only matching elements |
| `subList(from, to)` | View from `from` inclusive to `to` exclusive |

## 4. Easy example
```java
ArrayList<String> names = new ArrayList<>();
names.add("Rahul");
names.add("Aman");
names.add("Rahul"); // duplicate allowed
System.out.println(names.get(0));
names.set(1, "Riya");
names.remove("Rahul");
System.out.println(names);
```

## 5. Loop through an ArrayList
```java
for (int i = 0; i < names.size(); i++) {
    System.out.println(names.get(i));
}

for (String name : names) {
    System.out.println(name);
}
```

## 6. Sorting
```java
import java.util.Collections;
Collections.sort(numbers); // ascending order
Collections.reverse(numbers); // reverses current order
```
For custom objects, use `Comparator` (covered in sorting/comparator notes).

## 7. Time complexity (typical)
| Operation | Complexity |
|---|---|
| `get(index)`, `set(index)` | O(1) |
| `add(value)` | Amortized O(1) |
| Insert/remove near beginning or middle | O(n) |
| `contains`, `indexOf` | O(n) |

## 8. When should I use it?
- When I need index-based access.
- When I mostly read elements or add at the end.
- When duplicates and insertion order are needed.
- For DSA lists, storing results, and dynamic collections.

Avoid choosing it when frequent insertions/removals at the beginning are the main operation.

## 9. Common confusion
- `size()` means current number of elements; capacity is internal storage space.
- `remove(1)` removes index `1` for an `ArrayList<Integer>`. To remove the integer value `1`, use `remove(Integer.valueOf(1))`.
- `subList()` returns a backed view, not an independent copy.
- `ArrayList` is not synchronized by default.

## Practice
1. Store 5 numbers and print them using a for-each loop.
2. Find whether a given name exists using `contains()`.
3. Remove duplicate values (try a `Set` after learning it).
4. Find the largest number in an ArrayList.

Runnable examples: `ArrayListBasics.java` and `ArrayListMethods.java`.
