package com.wink.learn.lru;

import java.util.LinkedHashMap;
import java.util.Map;

// 利用已有的 JDK 数据结构实现一个 Java 版的 LRU
public class LRUCache<K,V> extends LinkedHashMap<K,V> {

    private final int CACHE_SIZE;

    /**
     *
     * @param cacheSizeInit 缓存大小设置
     */
    public LRUCache(int cacheSizeInit){
        super((int) (Math.ceil(cacheSizeInit / 0.75)+1),0.75f,true);
        CACHE_SIZE  = cacheSizeInit;
    }

    /**
     * 重新父类方法
     * 钩子方法，通过put新增键值对的时候，若该方法返回true
     * 便移除该map中最老的键和值
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > CACHE_SIZE;
    }
}
