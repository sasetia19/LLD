import java.util.HashMap;
import java.util.Deque;
import java.util.LinkedList;

public class LRUCache<K,V> implements ICache<K,V>{
    /*there are two implementations for this
    1. Optimized --> using these 3 things
    private HashMap<K,V> cache;
    private final HashMap<Key, DoublyLinkedListNode<Key>> map;
    private final DoublyLinkedList<Key> dll;
    This is similar to how we write code in C++, here we can get O(1) access to
    any element in doublyLinkedList

    2. Naive way is to just use
    private HashMap<K,V> cache;
    private final Deque<K> deque;
    and use deque.remove(key) for removing, which will remove in O(n)

    here implementing the second approach,
    look at below link for first approach
    https://github.com/goyal27/cache-lld/blob/master/src/main/java/com/codeyapa/cache/policy/LRUEvictionPolicy.java
     */
    private HashMap<K,V> cache;
    private final Deque<K> deque;
    int capacity;

    public LRUCache(int size){
        cache = new HashMap<K,V>();
        deque = new LinkedList<>();
        capacity = size;
    }

    @Override
    public synchronized void addToCache(K key, V value) {
        //if already present
        if(cache.containsKey(key)){
            //just add it to front and update the value
            deque.remove(key);
        }
        //add to cache and front of queue
        cache.put(key,value);
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
            System.out.println("Key Not present");
            return null;
        }
        //push key to front
        deque.remove(key);
        deque.addFirst(key);

        //return value of key
        return cache.get(key);
    }


}
