package com.kot.collection.map;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author yf
 * @create 2022-11-29 0:20
 */
public class MyHashMap<K,V> extends AbstractMap<K,V>
implements Map<K,V>,Cloneable, Serializable {


    //属性
    //序列化的版本号
    private static final long serialVersionUID = 12316854321454L;

    //初始化容量为16
    static final int DEFAULT_INITIAL_CAPACITY = 1<<4;

    //最大的容量为2的30次方
    static final int MAXIMUM_CAPACITY = 1<<30;

    //默认的加载因子
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    //链表转为树的阈值
    static final int TREEIFY_THRESHOLD = 8;

    //树转为链表的阈值
    static final int UNTREEIFY_THRESHOLD = 6;

    //一个槽位所能容纳的节点个数
    static final int MAX_TREEIFY_CAPACITY = 64;

    //静态方法

    //计算hash
    static final int hash(Object key){
        int h;
        return key == null ? 0: (h = key.hashCode()) ^( h >>> 16 );
    }

    //计算传入的大小下一个的2的次幂
    static final int tableSizeFor(int cap){
        int n = cap -1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : ((n >= MAXIMUM_CAPACITY)?MAXIMUM_CAPACITY:n+1);
    }


    //属性


    //hash槽的表
    transient Node<K,V>[] table;

    //节点的集合
    transient Set<Map.Entry<K,V>> entrySet;

    //大小
    transient int size;

    //修改次数
    transient int modCount;

    //阈值
    int threshold;

    final float loadFactor;


    //构造函数


    /**
     * 传入初始容量大小和加载因子来构造
     * @param initialCapacity
     * @param loadFactor
     */
    public MyHashMap(int initialCapacity, float loadFactor) {

        //控制边界
        if(initialCapacity < 0){
            throw new IllegalArgumentException("错误的初始容量大小: " + initialCapacity);
        } else if(initialCapacity > MAXIMUM_CAPACITY){
            initialCapacity = MAXIMUM_CAPACITY;
        }
        if(loadFactor <= 0 || Float.isNaN(loadFactor)){
            throw new IllegalArgumentException("错误的加载因子: " + loadFactor);
        }

        this.threshold = tableSizeFor(initialCapacity);
        this.loadFactor = loadFactor;
    }

    /**
     *  只传入初始容量大小，加载因子为默认的
     * @param initialCapacity
     */
    public MyHashMap(int initialCapacity) {
        this(initialCapacity,DEFAULT_LOAD_FACTOR);
    }

    /**
     * 无参的构造函数，只初始化加载因子
     */
    public MyHashMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
    }

    public MyHashMap(Map<? extends K,? extends V> m){
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        putMapEntries(m,false);
    }

    final void putMapEntries(Map<? extends K,? extends V> m, boolean evict) {
        //取出m的size
        int s = m.size();
        //非空进行下一步
        if(s > 0){
            //如果原来的hash槽为空，那么初始化
            if(table == null){
                float ft = ((float) s / loadFactor) +1.0f;
                //浮动后的表大小于最大容量间选择小的
                int t = ((ft < MAXIMUM_CAPACITY) ? (int) ft : MAXIMUM_CAPACITY);
                //扩展到二的次幂
                if(t > threshold){
                    threshold = tableSizeFor(t);
                }
                //如果新加入的map的大小大于了阈值
            }else if (s > threshold){
                //扩容
                resize();
            }

            //然后开始填充
            for (Entry<? extends K, ? extends V> entry : m.entrySet()) {
                //取出每个节点的键和值
                V value = entry.getValue();
                K key = entry.getKey();
                //开始放入值
                putVal(hash(key),key,value,false,evict);
            }
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public V get(Object key) {
        Node<K,V> e;
        return (e = getNode(hash(key),key)) == null ? null : e.getValue();
    }

    final Node<K,V> getNode(int hash, Object key) {
        return null;
    }

    private void putVal(int hash, K key, V value, boolean b, boolean evict) {
    }

    private void resize() {
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    @Override
    public V getOrDefault(Object key, V defaultValue) {
        return Map.super.getOrDefault(key, defaultValue);
    }

    @Override
    public void forEach(BiConsumer<? super K, ? super V> action) {
        Map.super.forEach(action);
    }

    @Override
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
        Map.super.replaceAll(function);
    }

    @Override
    public V putIfAbsent(K key, V value) {
        return Map.super.putIfAbsent(key, value);
    }

    @Override
    public boolean remove(Object key, Object value) {
        return Map.super.remove(key, value);
    }

    @Override
    public boolean replace(K key, V oldValue, V newValue) {
        return Map.super.replace(key, oldValue, newValue);
    }

    @Override
    public V replace(K key, V value) {
        return Map.super.replace(key, value);
    }

    @Override
    public V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
        return Map.super.computeIfAbsent(key, mappingFunction);
    }

    @Override
    public V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        return Map.super.computeIfPresent(key, remappingFunction);
    }

    @Override
    public V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        return Map.super.compute(key, remappingFunction);
    }

    @Override
    public V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
        return Map.super.merge(key, value, remappingFunction);
    }

    //内部类，表示一个存储键值对的节点
    static class Node<K,V> implements Map.Entry<K,V>{

        //属性

        //key和hash设置为final保证在hashmap中的每一个key都不可变
        final int hash;
        final K key;
        V value;
        Node<K,V> next;

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }


        @Override
        public K getKey() {
            return key;
        }

        @Override
        public String toString() {
            return  key + "=" + value;
        }

        @Override
        public final boolean equals(Object o) {
            //先比较内存地址
            if(o == this){
                return true;
            }
            //再比较内容是否相等
            if(o instanceof Map.Entry){
                Map.Entry<?,?> e = (Entry<?, ?>) o;
                if(Objects.equals(e.getKey(),key) && Objects.equals(e.getValue(),value)){
                    return true;
                }
            }
            return false;
        }

        @Override
        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            return null;
        }
    }




}
