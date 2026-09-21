# LinkedList - My Notes

## What is LinkedList?
`LinkedList` is a doubly-linked list implementation of `List` and `Deque`. Each element is stored in a node linked to its previous and next node. It maintains insertion order, permits duplicates and nulls, and is not synchronized.

```java
LinkedList<String> names = new LinkedList<>();
```

## Important methods
| Method | Use |
|---|---|
| `add(value)` | Adds at the end |
| `addFirst(value)` / `addLast(value)` | Adds at either end |
| `getFirst()` / `getLast()` | Reads first/last; throws if empty |
| `peek()` / `peekFirst()` / `peekLast()` | Reads end; returns `null` if empty |
| `removeFirst()` / `removeLast()` | Removes end; throws if empty |
| `poll()` / `pollFirst()` / `pollLast()` | Removes end; returns `null` if empty |
| `offer(value)` / `offerFirst()` / `offerLast()` | Queue-style insertion |
| `push(value)` / `pop()` | Stack-style add/remove at front |
| `size()` / `isEmpty()` / `clear()` | Common collection operations |

## LinkedList as List, Queue and Deque
```java
LinkedList<Integer> list = new LinkedList<>();
list.add(10);       // List-style
list.offer(20);    // Queue-style
list.push(5);      // Deque/stack-style (front)
System.out.println(list);
```

## Complexity (typical)
- Add/remove at either end: O(1)
- Access by index (`get(index)`): O(n), because nodes are traversed
- Search (`contains`): O(n)
- Insert/remove by index: O(n) to reach the node, then relinking is O(1)

## ArrayList vs LinkedList
| ArrayList | LinkedList |
|---|---|
| Dynamic array | Doubly-linked nodes |
| Fast random access: O(1) | Index access: O(n) |
| Middle insert/remove may shift elements | Once at node, relinking is cheap; finding it can take O(n) |
| Often a good default for List | Useful when deque operations at both ends are needed |

## Common mistakes
- `getFirst()` and `removeFirst()` throw an exception if the list is empty.
- `peek()` and `poll()` return `null` when empty.
- LinkedList does not make every insertion/removal O(1); locating an index still costs time.
- For most everyday list use, start with `ArrayList` unless you need deque behavior.

## Practice
1. Add five tasks and print first/last task.
2. Use a LinkedList as a queue with `offer()` and `poll()`.
3. Use `push()` and `pop()` to understand stack behavior.

Runnable example: `LinkedListBasics.java`.
