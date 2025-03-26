import java.util.HashMap;
import java.util.Deque;
import java.util.LinkedList;

public class LRUCacheWithTTL<K,V> implements ICacheWithTTL<K,V>{
    private HashMap<K,CacheEntry<V>> cache;
    private final Deque<K> deque;
    int capacity;

    public LRUCacheWithTTL(int size){
        cache = new HashMap<K,CacheEntry<V>>();
        deque = new LinkedList<>();
        capacity = size;
    }

    @Override
    public synchronized void addToCache(K key, V value, long ttl) {
        //if already present
        if(cache.containsKey(key)){
            //just add it to front and update the value
            deque.remove(key);
        }
        //add to cache and front of queue
        cache.put(key,new CacheEntry<>(value,ttl));
        deque.addFirst(key);

        //check capacity
        if(cache.size() > capacity){
            cache.remove(deque.pollLast());
        }
    }

    @Override
    public synchronized V getFromCache(K key) {
        //if key not present
        if(!cache.containsKey(key)){
            System.out.println("Key Not present "+ key);
            return null;
        }
        //check if expired
        CacheEntry<V> entry = cache.get(key);
        if (entry.isExpired()) {
            cache.remove(key);
            deque.remove(key);
            System.out.println("Expired key " + key);
            return null;
        }

        //push key to front
        deque.remove(key);
        deque.addFirst(key);

        //return value of key
        return cache.get(key).value;
    }
}
