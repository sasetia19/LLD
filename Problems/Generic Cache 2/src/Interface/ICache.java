package Interface;

public interface ICache<K,V> {
    public void addToCache(K key, V val);
    public V getFromCache(K key);

}
