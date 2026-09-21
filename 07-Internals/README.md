# 07 — Internals & Performance

Understand concepts behind common implementations. Details can vary across Java versions and vendors.

- `hashCode()` and `equals()` contract
- Hash tables, buckets, collisions, load factor, resizing
- HashMap implementation overview and tree bins
- Tree-based collections and comparator consistency
- Fail-fast iterators and `ConcurrentModificationException`
- Big-O vs amortized complexity; benchmark caveats

Do not depend on undocumented implementation details in application code. Use these lessons to build intuition, not as a substitute for API contracts.
