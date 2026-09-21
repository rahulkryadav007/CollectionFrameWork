# 00 — Foundations

Before learning individual collections, understand:
1. **Array vs Collection:** arrays have fixed length; most collection implementations grow dynamically.
2. **Generics:** `List<String>` provides compile-time type safety and avoids manual casts.
3. **Interfaces vs classes:** code to `List`, `Set`, `Queue`, or `Map`; instantiate a suitable implementation.
4. **Object equality:** `equals()` defines logical equality; `hashCode()` must be consistent with it for hash-based collections.
5. **Ordering contracts:** `Comparable` defines natural order; `Comparator` defines external/custom order.

## Example
See `GenericsAndCollectionBasics.java` for a small runnable example.
