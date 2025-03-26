public interface ICache<K,V> {
    public void addToCache(K key, V value);
    public V getFromCache(K key);

}
