package org.dev.kvstore;

import lombok.Data;

@Data
public class ValueWrapper<V> {

    private final V value;

    private final Long expiryTimeInMillis;

    public boolean isExpired(){
        return expiryTimeInMillis!=null && System.currentTimeMillis()>expiryTimeInMillis;
    }
}
