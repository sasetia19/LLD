package Implementations;

import Interface.IEvictionPolicy;

import java.util.Deque;
import java.util.LinkedList;

public class LRUevictionPolicy<K> implements IEvictionPolicy<K> {
    private Deque<K> deque;

    public LRUevictionPolicy(){
        deque = new LinkedList<>();
    }


    @Override
    public K evict() {
        return deque.pollLast();
    }

    @Override
    public void access(K key) {
        if(deque.contains(key)){
            deque.remove(key);
        }
        deque.addFirst(key);
    }
}
