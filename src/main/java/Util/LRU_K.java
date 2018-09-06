package Util;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 实现LRU算法，最近最少访问，当数据长度达到上限的时候，直接移除
 * @param <K>
 * @param <V>
 *   flag为true实现LRU算法，flag为false实现FIFO算法（先进先出队列）
 */
public class LRU_K<K,V> {

    private static final float hashLoadFactory = 0.75f;
    private LinkedHashMap<K,V> map;
    private HashMap<K,Integer> hashMap;
    private int cacheSize;

    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    private final Lock readLock = lock.readLock();

    private final Lock writeLock = lock.writeLock();

    private boolean flag = true;

    private Integer visitNumber;

    /*
    由于LinkedHashMap是为自动扩容的，当table数组中元素大于Capacity * loadFactor的时候，
    就会自动进行两倍扩容。但是为了使缓存大小固定，就需要在初始化的时候传入容量大小和负载因子。
    为了使得到达设置缓存大小不会进行自动扩容，需要将初始化的大小进行计算再传入，可以将初始化大小设置为(缓存大小 / loadFactor) + 1，
    这样就可以在元素数目达到缓存大小时，也不会进行扩容了。这样就解决了上述第一点问题。
     */
    public LRU_K(int cacheSize,int k) {
        this.cacheSize = cacheSize;
        //设定缓存数据长度
        int capacity = (int) Math.ceil(cacheSize / hashLoadFactory) + 1;
        this.visitNumber = k;
        map = new LinkedHashMap<K, V>(capacity, hashLoadFactory, flag) {

            private static final long serialVersionUID = 1;

            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > LRU_K.this.cacheSize;
            }
        };
    }

    public void put(K key,V value){
        map.put(key,value);
        hashMap.put(key,0);
    }

    public synchronized V get(K key){
        hashMap.put(key,hashMap.get(key) == null?0:hashMap.get(key)+1);
        return map.get(key);
    }

    public synchronized void remove(K key){
        remove(key);
        hashMap.remove(key);
    }

    public synchronized Set<Map.Entry<K,V>> getAll(){
        return map.entrySet();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            stringBuilder.append(String.format("%s: %s  ", entry.getKey(), entry.getValue()));
        }
        return stringBuilder.toString();
    }
}
