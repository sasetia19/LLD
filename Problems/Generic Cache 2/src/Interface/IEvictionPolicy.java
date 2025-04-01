package Interface;

public interface IEvictionPolicy<K> {
    public K evict();
    public void access(K key);
}
