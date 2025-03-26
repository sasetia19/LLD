public interface ICacheWithTTL<K,V> {
    public void addToCache(K key, V value, long ttl);
    public V getFromCache(K key);
}
