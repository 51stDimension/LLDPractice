package org.dev.kvstore.eviction;

public interface EvictionPolicy<K> {
    void onKeyAccess(K key);
    void onKeyRemoval(K key);
    void onKeyInsertion(K key);
    K evict();
}
