Problem Statement: Design a Generic Caching System
You are tasked with designing a Generic Caching System that can be used across different applications to store and retrieve data efficiently. The system should provide flexibility in choosing different caching policies such as Least Recently Used (LRU) or Least Frequently Used (LFU). It should also support cache expiration and eviction.

Requirements
Store and Retrieve Data: Provide a simple interface to store and retrieve key-value pairs.

Support Multiple Cache Policies: Implement different eviction policies like LRU and LFU.

Expiration Management: Allow setting expiration times for cache entries.

Thread Safety: Ensure thread-safe operations for concurrent access.

Metrics: Provide metrics such as cache hit rate and miss rate.

Scalability: Support scaling across distributed systems if required.

Constraints
The cache size should be configurable.

The system should be optimized for read and write operations.

Efficient memory management should be maintained using eviction policies.

Cache entries must automatically expire based on their time-to-live (TTL).

Follow-Up Questions
How would you design the interface to support different eviction policies?

How would you implement cache expiration using a background cleaner or other mechanisms?

How would you ensure thread safety without affecting performance?

How would you scale this cache horizontally in a distributed environment?

What strategies would you use to handle large datasets that can't fit in memory?

How Thread Safety is getting achieved?
Thread safety in the code is achieved using the synchronized keyword.
The synchronized keyword ensures that only one thread can execute these methods at a time, preventing race conditions.

It provides mutual exclusion, ensuring that concurrent reads and writes to the cache and deque do not cause inconsistent data.
Since only one lock is acquired using synchronized on instance methods, there are no nested locks, reducing the chance of deadlocks.

All operations that involve both the cache and deque are handled within the same synchronized block, ensuring atomicity.

Drawbacks of Synchronized
While synchronized ensures safety, it introduces performance overhead by blocking threads.

If there are many read operations, a better approach would be using Read-Write Locks (ReentrantReadWriteLock) to allow concurrent reads while blocking writes.