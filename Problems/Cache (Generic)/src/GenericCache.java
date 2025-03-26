import java.util.HashMap;

public class GenericCache<K,V> implements ICache<K,V> {
    private int capacity;
    private HashMap<K,V> cache;

    public GenericCache(){
        cache = new HashMap<K,V>();
    }

    @Override
    public void addToCache(K key, V value){
        cache.put(key,value);
    }
    @Override
    public V getFromCache(K key){
        return cache.get(key);
    }

}
