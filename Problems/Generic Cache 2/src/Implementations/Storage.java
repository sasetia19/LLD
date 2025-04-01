package Implementations;

import Exceptions.KeyNotFoundException;
import Exceptions.StorageFullException;
import Interface.IStorage;

import java.util.HashMap;

public class Storage<K, V> implements IStorage<K,V> {

    private HashMap<K, V> store;
    int capacity;

    public Storage(int size){
        store = new HashMap<K,V>();
        capacity = size;
    }

    @Override
    public V get(K key) {
        if(!store.containsKey(key)){
            throw new KeyNotFoundException("Key not present");
        }
        return store.get(key);
    }

    @Override
    public void add(K key, V val) {
        if(storageFull()){
            throw new StorageFullException("Capacity Reached");
        }
        store.put(key,val);
    }

    @Override
    public void remove(K key) {
        store.remove(key);
    }

    private Boolean storageFull(){
        if(store.size() == capacity)return true;
        return false;
    }
}
