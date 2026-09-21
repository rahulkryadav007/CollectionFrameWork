# 04 — Map

A `Map<K, V>` stores key-value associations. Keys are unique; values may repeat. `Map` is part of the Collections Framework but does not extend `Collection`.

| Type | Behavior |
|---|---|
| `HashMap` | No guaranteed order; permits one null key and null values |
| `LinkedHashMap` | Predictable encounter order (insertion-order by default; can be configured for access order) |
| `TreeMap` | Sorts keys by natural order or Comparator |
| `Hashtable` | Legacy synchronized map; disallows null keys and values |
| `ConcurrentHashMap` | Concurrent access; disallows null keys and values |

Practice: `put`, `get`, `getOrDefault`, `putIfAbsent`, `containsKey`, `containsValue`, `remove`, `replace`, `keySet`, `values`, `entrySet`, `merge`, `computeIfAbsent`.

DSA applications: frequency counting, Two Sum, grouping anagrams, prefix sums, caching, indexing.
