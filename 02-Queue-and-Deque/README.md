# Queue, Deque & PriorityQueue

## 1. Queue
Queue is an interface commonly used for FIFO (First In, First Out) processing. `LinkedList` and `ArrayDeque` are common implementations.

| Method | Use |
|---|---|
| `offer(e)` | Add at tail; returns false if it cannot be added |
| `add(e)` | Add at tail; may throw exception on failure |
| `peek()` | Read head, returns `null` if empty |
| `element()` | Read head, throws exception if empty |
| `poll()` | Remove and return head, returns `null` if empty |
| `remove()` | Remove head, throws exception if empty |
| `size()` / `isEmpty()` | Check size or emptiness |

## 2. Deque
Deque means double-ended queue. Add/remove from both front and rear. `ArrayDeque` is a common choice and can also act as a stack. It does not allow null elements.

- `offerFirst(e)`, `offerLast(e)` — add at either end
- `pollFirst()`, `pollLast()` — remove from either end
- `peekFirst()`, `peekLast()` — inspect either end
- `push(e)` / `pop()` — stack-style operations (front of deque)

## 3. PriorityQueue
A PriorityQueue removes elements according to priority, not insertion order. Default ordering is natural ascending order, so the smallest element is at the head. Use `new PriorityQueue<>(Collections.reverseOrder())` for reverse/max-heap behavior.

- `offer(e)` / `add(e)` — insert
- `peek()` — see highest-priority element
- `poll()` — remove highest-priority element

**Important:** Iterating/printing a PriorityQueue does not guarantee sorted order. Repeated `poll()` gives priority order.

## DSA use cases
- Queue: BFS, level-order traversal, task scheduling
- Deque: sliding-window maximum, monotonic queue, 0-1 BFS
- PriorityQueue: kth largest/smallest, top-K elements, Dijkstra's algorithm, merge K sorted lists

## Complexity (typical)
| Structure / operation | Time |
|---|---|
| ArrayDeque end operations | Amortized O(1) |
| PriorityQueue offer/poll | O(log n) |
| PriorityQueue peek | O(1) |

See `QueueBasics.java`, `DequeBasics.java`, and `PriorityQueueBasics.java` for runnable examples.
