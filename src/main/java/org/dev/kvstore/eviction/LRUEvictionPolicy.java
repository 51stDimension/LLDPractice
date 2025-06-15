package org.dev.kvstore.eviction;

import java.util.concurrent.ConcurrentLinkedDeque;

public class LRUEvictionPolicy<K> implements EvictionPolicy<K> {

    private final ConcurrentLinkedDeque<K> concurrentLinkedDeque = new ConcurrentLinkedDeque<>();

    @Override
    public void onKeyAccess(K key) {
        concurrentLinkedDeque.remove(key);
        concurrentLinkedDeque.addLast(key);
    }

    @Override
    public void onKeyRemoval(K key) {
        concurrentLinkedDeque.remove(key);
    }

    @Override
    public void onKeyInsertion(K key) {
        concurrentLinkedDeque.remove(key);
        concurrentLinkedDeque.addLast(key);
    }

    @Override
    public K evict() {
        return concurrentLinkedDeque.pollFirst();
    }
}
