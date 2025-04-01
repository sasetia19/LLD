package Implementations;

import Exceptions.KeyNotFoundException;
import Exceptions.StorageFullException;
import Interface.ICache;
import Interface.IEvictionPolicy;
import Interface.IStorage;

public class Cache<K,V> implements ICache<K,V> {
    private IStorage<K,V> store;
    private IEvictionPolicy<K> evictionPolicy;

    public Cache(String policy, int size){
        store = new Storage<K,V>(size);
        if(policy.equals("LRU"))evictionPolicy = new LRUevictionPolicy<K>();
    }

    @Override
    public void addToCache(K key, V val){
        try{
            store.add(key,val);
            evictionPolicy.access(key);
            System.out.println(key + " is added");
        }
        catch (StorageFullException storageFullException){
            System.out.println("Got storage full, trying to evict");
            K keyToRemove = evictionPolicy.evict();
            store.remove(keyToRemove);
            System.out.println(keyToRemove + " is removed");
            addToCache(key,val);
        }
    }
    @Override
    public V getFromCache(K key){
        try{
            V val = store.get(key);
            evictionPolicy.access(key);
            return val;
        }
        catch(KeyNotFoundException keyNotFoundException){
            System.out.println(key + " not found");
        }
        return null;
    }
}
