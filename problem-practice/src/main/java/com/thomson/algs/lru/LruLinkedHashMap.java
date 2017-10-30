package com.thomson.algs.lru;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 基于{@link LinkedHashMap} 实现LRU算法
 *
 * @author Thomson Tang
 */
public class LruLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private final Lock lock = new ReentrantLock();
    private final int maxCapacity;

    public LruLinkedHashMap(int maxCapacity) {
        super(maxCapacity, DEFAULT_LOAD_FACTOR, true);
        this.maxCapacity = maxCapacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > maxCapacity;
    }

    @Override
    public boolean containsKey(Object key) {
        try {
            lock.lock();
            return super.containsKey(key);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public V get(Object key) {
        try {
            lock.lock();
            return super.get(key);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public V put(K key, V value) {
        try {
            lock.lock();
            return super.put(key, value);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int size() {
        try {
            lock.lock();
            return super.size();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void clear() {
        try {
            lock.lock();
            super.clear();
        } finally {
            lock.unlock();
        }
    }

    public Collection<Map.Entry<K, V>> getAll() {
        try {
            lock.lock();
            return new ArrayList<>(super.entrySet());
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        LruLinkedHashMap<String, String> map = new LruLinkedHashMap<>(5);
        map.put("001", "我是001号");
        map.put("002", "我是002号");
        map.put("003", "我是003号");
        map.put("004", "我是004号");
        map.put("005", "我是005号");

        for (int i = 0; i < 4; i++) {
            String key = "00" + (i + 2);
            System.out.println(map.get(key));
        }

        System.out.println("====================");

        map.put("006", "我是006号");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}
