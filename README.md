# Java Collections Framework (JCF) — Complete Study Notes

> Beginner-to-advanced Java Collections notes for students, freshers, DSA practice, interviews, and teaching. Examples use standard Java (JDK 17+ unless noted).

## Contents
- [1. What is JCF?](#1-what-is-jcf)
- [2. Hierarchy](#2-jcf-hierarchy)
- [3. Common interfaces and methods](#3-common-interfaces-and-methods)
- [4. List](#4-list)
- [5. Queue and Deque](#5-queue-and-deque)
- [6. Set](#6-set)
- [7. Map](#7-map)
- [8. Iteration and utilities](#8-iteration-and-utilities)
- [9. Sorting and comparison](#9-sorting-and-comparison)
- [10. Modern and concurrent collections](#10-modern-and-concurrent-collections)
- [11. Complexity cheat sheet](#11-complexity-cheat-sheet)
- [12. DSA patterns](#12-dsa-patterns)
- [13. Practice and projects](#13-practice-and-projects)
- [14. Folder guide](#14-folder-guide)

## 1. What is JCF?
The **Java Collections Framework** is a set of interfaces, implementations, and algorithms in `java.util` (plus concurrent types in `java.util.concurrent`) for storing and processing groups of objects.

**Why use it?** Arrays have fixed length and fewer built-in operations. Collections provide resizable storage, standard APIs, reusable algorithms, and data structures suited to different tasks.

```java
import java.util.*;
List<String> names = new ArrayList<>(); // program to the interface
names.add("Asha");
names.add("Rahul");
System.out.println(names); // [Asha, Rahul]
```

Generics (`List<String>`) provide compile-time type safety. Collections store object references, so primitives use wrappers (`Integer`, `Double`, etc.); autoboxing often converts automatically.

## 2. JCF hierarchy

```text
Iterable
└── Collection
    ├── List       -> ArrayList, LinkedList, Vector -> Stack
    ├── Set        -> HashSet -> LinkedHashSet
    │             -> SortedSet -> NavigableSet -> TreeSet
    └── Queue      -> PriorityQueue
                  -> Deque -> ArrayDeque, LinkedList

Map (separate from Collection)
├── HashMap -> LinkedHashMap
├── SortedMap -> NavigableMap -> TreeMap
├── Hashtable
└── ConcurrentHashMap
```

- **Collection**: root interface for groups of elements.
- **List**: ordered sequence, index-based, duplicates allowed.
- **Set**: no duplicate elements.
- **Queue**: elements processed according to queue policy (often FIFO).
- **Deque**: double-ended queue; add/remove at both ends.
- **Map**: key-value associations; keys are unique. It is in the framework but does not extend `Collection`.

## 3. Common interfaces and methods

### `Collection<E>`
| Method | Meaning / return |
|---|---|
| `add(e)` | Add one element; returns whether collection changed |
| `addAll(c)` | Add all elements from another collection |
| `remove(o)` | Remove one matching element, if present |
| `removeAll(c)` | Remove elements also found in `c` |
| `retainAll(c)` | Keep only elements also found in `c` |
| `clear()` | Remove all elements |
| `size()` | Number of elements |
| `isEmpty()` | Whether size is zero |
| `contains(o)` | Whether an equal element exists |
| `containsAll(c)` | Whether all elements from `c` exist |
| `toArray()` | Convert contents to an array |
| `iterator()` | Obtain an iterator |
| `removeIf(predicate)` | Remove elements matching a condition |
| `stream()` / `parallelStream()` | Create sequential / parallel stream |

`equals()` determines logical equality; `hashCode()` supports hash-based structures. If two objects are equal, they must have the same hash code. Override both consistently when using custom objects in `HashSet`/`HashMap`.

## 4. List
A `List` is an ordered, index-based collection that allows duplicates. Indexes start at `0`.

### Methods from `List<E>`
| Method | Meaning |
|---|---|
| `add(e)` / `add(index,e)` | Append / insert at position |
| `get(index)` | Read element at index |
| `set(index,e)` | Replace and return old element |
| `remove(index)` / `remove(object)` | Remove by index / first matching object |
| `indexOf(o)` / `lastIndexOf(o)` | First / last matching index; `-1` if absent |
| `subList(from,to)` | View of range; `to` is exclusive |
| `listIterator()` | Bidirectional iterator with list-specific operations |
| `sort(comparator)` | Sort list using comparator (or natural order) |
| `replaceAll(operator)` | Replace each element using a function |

### `ArrayList<E>`
Resizable array; general-purpose default for most lists. Fast indexed `get/set` (O(1)); append is amortized O(1); insert/remove in the middle is O(n) due to shifting. Not synchronized.

```java
List<Integer> nums = new ArrayList<>();
nums.add(10); nums.add(20); nums.add(10);
nums.add(1, 15);                 // [10, 15, 20, 10]
System.out.println(nums.get(2)); // 20
nums.set(0, 5);                  // replace index 0
nums.remove(Integer.valueOf(10));// remove matching value, not index 10
```

Useful methods: `ensureCapacity(n)` (ArrayList-specific capacity hint), `trimToSize()` (reduce capacity to current size). Avoid removing by primitive-looking integer without considering overload ambiguity: `remove(1)` means index 1; `remove(Integer.valueOf(1))` means value 1.

### `LinkedList<E>`
Doubly linked list implementing both `List` and `Deque`. Adding/removing at ends is O(1); indexed access/search is O(n). Useful when frequently manipulating ends, but often less cache-friendly than ArrayList.

### `Vector<E>` and `Stack<E>`
Legacy synchronized resizable array (`Vector`). `Stack` extends Vector and provides `push`, `pop`, `peek`, `empty`, `search`; for new stack code, prefer `Deque`/`ArrayDeque`.

## 5. Queue and Deque

### `Queue<E>`
Usually models FIFO. Head is the next element to be processed.

| Throws on failure | Returns special value on failure | Action |
|---|---|---|
| `add(e)` | `offer(e)` | Insert |
| `remove()` | `poll()` | Remove and return head |
| `element()` | `peek()` | Read head without removing |

Prefer `offer/poll/peek` when an empty queue or capacity limit is expected.

### `Deque<E>`
Double-ended queue. Key methods: `addFirst`, `addLast`, `offerFirst`, `offerLast`, `removeFirst`, `removeLast`, `pollFirst`, `pollLast`, `getFirst`, `getLast`, `peekFirst`, `peekLast`, `push`, `pop`, `peek`.

- **`ArrayDeque`**: efficient resizable deque; good default for stack/queue; disallows null; not thread-safe.
- **`PriorityQueue`**: head is the least element by default (min-heap), not a fully sorted iteration. Use a comparator for max-heap: `new PriorityQueue<>(Comparator.reverseOrder())`. `offer/poll` O(log n), `peek` O(1).

## 6. Set
A `Set` stores unique elements. Equality is determined using `equals()` (and hashing for hash sets) or comparison for sorted sets.

### `Set<E>` common operations
`add(e)` returns `false` if an equal element is already present; `remove(e)`, `contains(e)`, `size()`, `isEmpty()`, `clear()`, `addAll`, `retainAll`, `removeAll` are commonly used.

| Implementation | Ordering | Typical operation cost | Notes |
|---|---|---|---|
| `HashSet` | No guaranteed order | O(1) average add/contains/remove | Allows one null |
| `LinkedHashSet` | Insertion order | O(1) average | Maintains linked encounter order |
| `TreeSet` | Sorted order | O(log n) | Uses natural ordering or Comparator; generally no null with natural ordering |

Set operations: union via `addAll`, intersection via `retainAll`, difference via `removeAll` (use a copy if original must remain unchanged).

## 7. Map
A `Map<K,V>` stores key-value pairs. Keys are unique; values may repeat.

### Core `Map<K,V>` methods
| Method | Meaning |
|---|---|
| `put(k,v)` | Insert/update; returns previous value (or null) |
| `putIfAbsent(k,v)` | Add only if no mapping or mapped null |
| `get(k)` / `getOrDefault(k,default)` | Read value / fallback |
| `remove(k)` / `remove(k,v)` | Remove key / matching key-value pair |
| `containsKey(k)` / `containsValue(v)` | Test key / value presence |
| `replace(k,v)` / `replace(k,old,new)` | Replace existing mapping conditionally |
| `putAll(map)` | Copy mappings from another map |
| `keySet()` | Set view of keys |
| `values()` | Collection view of values |
| `entrySet()` | Set view of key-value entries |
| `computeIfAbsent(k,fn)` | Compute/store value when key absent or mapped null |
| `computeIfPresent(k,fn)` | Recompute value when key is mapped to non-null |
| `compute(k,fn)` | Recompute based on current mapping; null result removes mapping |
| `merge(k,v,fn)` | Insert value if absent; otherwise combine old and new |
| `forEach(action)` | Visit each key-value pair |

### Implementations
- **`HashMap`**: no order guarantee; O(1) average `get/put`; allows one null key and null values; not synchronized.
- **`LinkedHashMap`**: predictable insertion order by default; can be configured for access order (useful for LRU-style caches).
- **`TreeMap`**: sorted keys; O(log n) core operations; natural order or Comparator.
- **`Hashtable`**: legacy synchronized map; disallows null keys/values. Prefer modern alternatives in new code.
- **`ConcurrentHashMap`**: concurrent access designed for multithreaded use; disallows null keys/values; supports atomic operations such as `compute` and `putIfAbsent`.

Frequency-count pattern:
```java
Map<Integer, Integer> freq = new HashMap<>();
for (int x : new int[]{2, 3, 2, 5, 3, 2}) {
    freq.put(x, freq.getOrDefault(x, 0) + 1);
}
```

## 8. Iteration and utilities

- Enhanced for: `for (String s : list) { ... }` — concise read/traversal.
- `Iterator`: `hasNext()`, `next()`, `remove()` (optional operation; safe iterator removal).
- `ListIterator`: `hasNext/next`, `hasPrevious/previous`, `nextIndex/previousIndex`, `add`, `set`, `remove`.
- `Collections` is a utility class (not the same as `Collection`). Useful methods: `sort`, `reverse`, `shuffle`, `swap`, `min`, `max`, `frequency`, `disjoint`, `binarySearch` (requires sorted list), `copy` (destination must be large enough), `fill`, `nCopies`, `unmodifiableList/Set/Map`, `synchronizedList/Set/Map`.
- Conversion: `list.toArray(new String[0])`; `Arrays.asList(array)` returns a fixed-size list backed by the array; `List.of(...)` returns an unmodifiable list and rejects nulls.
- Avoid structural modification of most collections during enhanced-for traversal; use `Iterator.remove()` or `removeIf` where appropriate. Fail-fast behavior is best-effort, not a thread-safety guarantee.

## 9. Sorting and comparison
- `Comparable<T>`: natural ordering implemented by the class using `compareTo`.
- `Comparator<T>`: external/custom ordering using `compare`.
- `list.sort(comparator)` or `Collections.sort(list, comparator)` sorts a list.
- `Comparator.comparing(Student::getName).thenComparing(Student::getAge)` builds multi-field ordering. Use `Integer.compare(a,b)` rather than subtraction to avoid overflow.
- Ensure comparison is consistent with equality when using sorted sets/maps, or values that compare as zero may be treated as duplicates/identical keys.

## 10. Modern and concurrent collections
- `List.of`, `Set.of`, `Map.of`, `Map.ofEntries`: create unmodifiable collections; reject nulls (and Set/Map factories reject duplicate elements/keys).
- `Collections.unmodifiableX(...)` creates an unmodifiable view; changes through another reference to the backing collection may still be visible.
- Synchronized wrappers synchronize individual method calls; compound iteration/actions may still require external synchronization.
- Concurrent types include `ConcurrentHashMap`, `CopyOnWriteArrayList`, `ConcurrentLinkedQueue`, and `BlockingQueue` implementations such as `ArrayBlockingQueue` and `LinkedBlockingQueue`. Select based on concurrency and workload, not merely because a type is newer.

## 11. Complexity cheat sheet

| Structure | Access / lookup | Insert | Remove |
|---|---:|---:|---:|
| ArrayList | get O(1), search O(n) | append amortized O(1); middle O(n) | middle O(n) |
| LinkedList | index/search O(n) | ends O(1) | ends O(1), search O(n) |
| HashSet / HashMap | average O(1) | average O(1) | average O(1) |
| TreeSet / TreeMap | O(log n) | O(log n) | O(log n) |
| PriorityQueue | peek O(1) | offer O(log n) | poll O(log n) |

These are typical costs, not guarantees for every input/JDK. Hash behavior depends on hash distribution and implementation; `PriorityQueue` iteration is not sorted.

## 12. DSA patterns

| Problem pattern | Typical collection |
|---|---|
| Two Sum / complement lookup | `HashMap` |
| Detect duplicates | `HashSet` |
| Frequency counting / anagrams | `HashMap` |
| Preserve unique insertion order | `LinkedHashSet` |
| Top-K / repeatedly fetch min or max | `PriorityQueue` |
| BFS | `ArrayDeque` as queue |
| Sliding window frequency | `HashMap` |
| Monotonic stack | `ArrayDeque` |
| Sorted unique values / range queries | `TreeSet` / `TreeMap` |

## 13. Practice and projects

**Beginner:** add/remove/search in ArrayList; remove duplicates with HashSet; count frequencies with HashMap; queue simulation.

**Intermediate:** Two Sum; valid anagram; first non-repeating character; top-K elements; group anagrams; sliding-window frequency map.

**Advanced:** LRU cache with access-order LinkedHashMap; median/top-K with heaps; monotonic deque; custom objects as TreeSet/HashMap keys; concurrent producer-consumer queue.

**Mini projects:** Word Frequency Analyzer, Student Record Manager, Inventory Tracker, LRU Cache Simulator.

For every exercise: understand the prompt → select the data structure → state why → code → dry-run → test edge cases → analyze time/space complexity.

## 14. Folder guide

```text
CollectionFrameWork/
├── README.md
├── 00-Foundations/                 # arrays vs collections, generics, equality
├── 01-List/                        # ArrayList, LinkedList, Vector, Stack
├── 02-Queue-and-Deque/             # Queue, Deque, PriorityQueue, ArrayDeque
├── 03-Set/                         # HashSet, LinkedHashSet, TreeSet
├── 04-Map/                         # HashMap, LinkedHashMap, TreeMap, concurrency
├── 05-Iteration-and-Utilities/     # Iterator, ListIterator, Collections
├── 06-Sorting-and-Comparators/     # Comparable, Comparator, custom sorting
├── 07-Internals/                   # hashing, collisions, resizing, fail-fast
├── 08-Modern-Java-Collections/     # factories, immutable/unmodifiable views
├── 09-Concurrent-Collections/      # thread-safe and concurrent structures
├── 10-DSA-Applications/            # problem patterns
├── 11-Mini-Projects/               # applied projects
└── 12-Interview-Preparation/       # revision, viva, interview questions
```

Each implementation's dedicated lesson should add runnable examples, expected output, line-by-line explanation, edge cases, and exercises. This README is the central notes/reference; Java APIs contain additional overloads and inherited methods, so consult the official Javadoc for exhaustive signatures.

## Run an example

```bash
javac ArrayListBasics.java
java ArrayListBasics
```

No external dependencies are required.

## Author
**Rahul Kumar Yadav** — Java, DSA & Technical Training
