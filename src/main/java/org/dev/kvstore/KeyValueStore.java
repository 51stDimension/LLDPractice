package org.dev.kvstore;

import org.dev.kvstore.eviction.EvictionPolicy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class KeyValueStore<K,V> {

    private final ConcurrentHashMap<K, ValueWrapper<V>> storage = new ConcurrentHashMap<>();

    private final Integer totalCapacity;
    private final EvictionPolicy<K> evictionPolicy;


    public KeyValueStore(Integer totalCapacity, EvictionPolicy<K> evictionPolicy) {
        this.totalCapacity = totalCapacity;
        this.evictionPolicy = evictionPolicy;
    }

    public void storageCleaner(){
        for (Map.Entry<K, ValueWrapper<V>> entry : storage.entrySet()){
            if(!entry.getValue().isExpired()){
                evictionPolicy.onKeyRemoval(entry.getKey());
                storage.remove(entry.getKey());
            }
        }
    }

    public int size(){
        int size = 0;

        for (Map.Entry<K, ValueWrapper<V>> entry : storage.entrySet()){
            if(!entry.getValue().isExpired()){
                size ++;
            }
        }

        return size;
    }

    public boolean addKVPair(K key, V value, Long ttl){
        Long expireTime = System.currentTimeMillis() + ttl;
        storage.put(key, new ValueWrapper<V>(value, expireTime));
        evictionPolicy.onKeyInsertion(key);

        if(storage.size() > totalCapacity){
            K evictedKey = evictionPolicy.evict();
            if(evictedKey!=null){
                storage.remove(evictedKey);
            }
        }

        return true;
    }

    public V getValueForKey(K key){
        ValueWrapper<V> valueWrapper = storage.get(key);
        if(valueWrapper==null || valueWrapper.isExpired()){
            evictionPolicy.onKeyRemoval(key);
            storage.remove(key);
            return null;
        }

        evictionPolicy.onKeyAccess(key);
        return valueWrapper.getValue();
    }
}
