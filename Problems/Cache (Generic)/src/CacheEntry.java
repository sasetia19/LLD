public class CacheEntry<V> {
    V value;
    long expirationTime;

    CacheEntry(V value, long ttl) {
        this.value = value;
        this.expirationTime = System.currentTimeMillis() + ttl;
    }

    boolean isExpired() {
        return System.currentTimeMillis() > expirationTime;
    }
}
