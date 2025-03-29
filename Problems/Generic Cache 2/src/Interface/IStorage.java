package Interface;

import java.util.HashMap;

public interface IStorage<K,V> {

    public V get(K key);
    public void add(K key,V val);
    public void remove(K key);
}
