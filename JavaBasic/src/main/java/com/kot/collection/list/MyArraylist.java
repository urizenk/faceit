package com.kot.collection.list;

import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * @author yf
 * @create 2022-11-29 0:18
 */
public class MyArraylist<E> extends AbstractList<E>
implements List<E>, RandomAccess,Cloneable, Serializable {
    //属性

    //序列化的版本控制
    private static final long serialVersionID = 12654321684325L;

    //默认的容量大小
    private static final int DEFAULT_CAPACITY = 10;
    //定义一个常量数组来复用空的集合
    private static final Object[] EMPTY_ELEMENTDATA = {};
    //默认容量时的使用
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    //元素数组
    transient Object[] elementData;
    //大小
    private int size;


    //构造函数


    /**
     * 通过指定初始化容量来构造
     * @param initCapacity
     */
    public MyArraylist(int initCapacity) {
        if(initCapacity > 0){
            this.elementData = new Object[initCapacity];
        }else if(initCapacity == 0){
            this.elementData = EMPTY_ELEMENTDATA;
        }else {
            throw new IllegalArgumentException("初始化的容量出错:" + initCapacity);
        }

    }

    /**
     * 默认的无参构造
     */
    public MyArraylist() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public MyArraylist( Collection<? extends E> c){
        //将这个集合转换为对象数组
        Object[] a = c.toArray();
        //判断a的长度进行下一步
        if(a.length>0){
            if(c.getClass().equals(ArrayList.class)){
                elementData = a;
            }else {
                //复制数组
                Arrays.copyOf(a,size,Object[].class);
            }
        }else {
            elementData = EMPTY_ELEMENTDATA;
        }

    }

    //方法

    //容量相关的方法

    //将容器大小修剪到size
    public void trimToSize(){


        System.out.println("size" + size);

        modCount++;
        //判断大小，然后再复制
        if(size<elementData.length){
            elementData = (size == 0)
                    ? EMPTY_ELEMENTDATA
                    : Arrays.copyOf(elementData,size);
        }
    }

    //在添加元素前验证容量大小
    public void ensureCapacity(int minCapacity){
        System.out.println("size" + size);
        //判断是不是默认容量的数组
        int minExpand = (elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA)
                ?0
                :DEFAULT_CAPACITY;
        //然后最小能扩展的如果比扩展后的最小容量还小，那就真的扩容
        if(minCapacity > minExpand){
            ensureExplicitCapacity(minCapacity);
        }
    }

    private void ensureCapacityInternel(int minCapacity) {


        System.out.println("size" + size);
        //进行容量的计算
        ensureExplicitCapacity(calculateCapacity(elementData,minCapacity));
    }

    private static int calculateCapacity(Object[] elementData, int minCapacity) {

        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA){
            return Math.max(DEFAULT_CAPACITY,minCapacity);
        }
        return minCapacity;
    }


    //实际的扩容
    private void ensureExplicitCapacity(int minCapacity) {
        System.out.println("开始实际扩容啦，当前size为" + size );

        System.out.println("size" + size);
        modCount++;
        //此处为考虑溢出情况的代码
        //这里判断是因为外部不一定全部都会判断好这个minCapacity的值
        if(minCapacity-elementData.length>0){

            grow(minCapacity);

        }

        System.out.println("扩容结束，size为" + size);
    }

    //一个数组最大的大小，-8是为了给一些头信息留下空间，如果超出这个值会报OOM
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    private void grow(int minCapacity) {
        //新容量为旧容量的一点五倍
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        //考虑溢出情况
        if(newCapacity-minCapacity < 0){
            newCapacity = minCapacity;
        }if(newCapacity-MAX_ARRAY_SIZE > 0){
            //使用函数来定义一个数组最大容量

            newCapacity = hugeCapacity(minCapacity);
        }

        elementData = Arrays.copyOf(elementData,newCapacity);
    }

    //定义一个最大的容量
    private static int hugeCapacity(int minCapacity){
        //溢出了
        if(minCapacity < 0){
            throw new OutOfMemoryError();
        }
        return (minCapacity > MAX_ARRAY_SIZE)?Integer.MAX_VALUE:MAX_ARRAY_SIZE;

    }

    //常用的api




    /**
     * {@inheritDoc}
     *
     * @param index
     * @throws IndexOutOfBoundsException {@inheritDoc}
     * @return
     */
    @Override
    public E get(int index) {
        //边界检查
        rangeCheck(index);

        return elementData(index);
    }

    @Override
    public E set(int index, E element) {
        rangeCheck(index);

        E oldValue = elementData(index);
        elementData[index] = element;
        return oldValue;
    }

    //单纯尾插
    @Override
    public boolean add(E e) {
        ensureCapacityInternel(size +1);
        elementData[size++] = e;
        return true;
    }

    //在特定的位置插入
    @Override
    public void add(int index, E element) {
        //对于插入的范围检查
        rangeCheckForAdd(index);

        //扩容
         ensureCapacityInternel(size + 1);

         //将原来在index位置之后的数组复制到index+1的下标处，然后给数组index位置赋值
        System.arraycopy(elementData,index,elementData,index+1,size-index);
        elementData[index]=element;
        //别忘了尺寸扩大
        size++;

    }

    @Override
    public E remove(int index) {
        rangeCheck(index);

        //没有扩容，别忘了增加修改次数
        modCount++;
        E oldValue = elementData(index);
        //计算需要移动的个数
        int numMoved = size - index -1;
        if(numMoved > 0){
            //把index+1的位置移到index上去
            System.arraycopy(elementData,index+1,elementData, index,numMoved);
        }

        //方便gc来收集
        elementData[--size] = null;


        return oldValue;
    }

    //通过对象来删除
    @Override
    public boolean remove(Object o) {
        //按是否为null来判断
        if(o == null){
            for (int i = 0; i < size; i++) {
                if(elementData[i] == null){
                    //不需要检查边界
                    fastRemove(i);
                    return true;
                }
            }
        }else {
            for (int i = 0; i < size; i++) {
                if(o.equals(elementData[i])){
                    fastRemove(i);
                    return true;
                }
            }
        }
        return false;
    }

    private void fastRemove(int index) {
        //没有扩容，别忘了增加修改次数
        modCount++;
        E oldValue = elementData(index);
        //计算需要移动的个数
        int numMoved = size - index -1;
        if(numMoved > 0){
            //把index+1的位置移到index上去
            System.arraycopy(elementData,index+1,elementData, index,numMoved);
        }

        //方便gc来收集
        elementData[--size] = null;

    }

    @Override
    public void clear() {
        //容量不改变，注意修改次数
        modCount++;
        //遍历置空
        for (int i = 0; i < elementData.length; i++) {
            elementData[i] = null;
        }

        //大小置为0
        size=0;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * 只要返回的下标大于1就行
     * @param o
     * @return
     */
    @Override
    public boolean contains(Object o) {
        return indexOf(o)>=1;
    }

    /**
     * 返回这个对象的第一个下标，没有就返回-1
     * @param o
     * @return
     */
    @Override
    public int indexOf(Object o) {
        //分两种情况，传入为null或者不是null
        if(o == null){
            for (int i = 0; i < size; i++) {
                if(elementData[i] == null){
                    return i;
                }
            }
        }else {
            for (int i = 0; i < size; i++) {
                if(o.equals(elementData[i])){
                    return i;
                }
            }
        }
        return -1;
    }


    /**
     * 倒着遍历就可以
     * @param o
     * @return
     */
    @Override
    public int lastIndexOf(Object o) {
        //分两种情况，传入为null或者不是null
        if(o == null){
            for (int i = size-1; i >= 0; i--) {
                if(elementData[i] == null){
                    return i;
                }
            }
        }else {
            for (int i = size-1; i >= 0; i--) {
                if(o.equals(elementData[i])){
                    return i;
                }
            }
        }
        return -1;
    }

    //泛型的值返回方法
    private E elementData(int index) {
        return (E) elementData[index];
    }


    //检查索引是否越界
    private void rangeCheck(int index) {
        if(index > size){
            throw new IndexOutOfBoundsException(outOfBoundMsg(index));
        }
    }

    //对于添加的元素来检查
    private void rangeCheckForAdd(int index){
        //考虑到溢出问题
        if(index>size || index < 0){
            throw new IndexOutOfBoundsException(outOfBoundMsg(index));
        }

    }

    private String outOfBoundMsg(int index){
        return "index:" + index + "size:" + size;
    }



    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elementData,size);
    }

    //泛型方法，
    @Override
    public <T> T[] toArray(T[] a) {
        if(a.length < size){
            return (T[])Arrays.copyOf(elementData,size,a.getClass());
        }

        System.arraycopy(elementData,0,a,0,size);
        if(a.length>size){
            a[size] = null;
        }

        return a;
    }

    /**
     * Performs the given action for each element of the {@code Iterable}
     * until all elements have been processed or the action throws an
     * exception.  Unless otherwise specified by the implementing class,
     * actions are performed in the order of iteration (if an iteration order
     * is specified).  Exceptions thrown by the action are relayed to the
     * caller.
     *
     * @param action The action to be performed for each element
     * @throws NullPointerException if the specified action is null
     * @implSpec <p>The default implementation behaves as if:
     * <pre>{@code
     *     for (T t : this)
     *         action.accept(t);
     * }</pre>
     * @since 1.8
     */
    @Override
    public void forEach(Consumer action) {
        super.forEach(action);
    }

    /**
     * Creates a {@link Spliterator} over the elements in this list.
     *
     * <p>The {@code Spliterator} reports {@link Spliterator#SIZED} and
     * {@link Spliterator#ORDERED}.  Implementations should document the
     * reporting of additional characteristic values.
     *
     * @return a {@code Spliterator} over the elements in this list
     * @implSpec The default implementation creates a
     * <em><a href="Spliterator.html#binding">late-binding</a></em> spliterator
     * from the list's {@code Iterator}.  The spliterator inherits the
     * <em>fail-fast</em> properties of the list's iterator.
     * @implNote The created {@code Spliterator} additionally reports
     * {@link Spliterator#SUBSIZED}.
     * @since 1.8
     */
    @Override
    public Spliterator<E> spliterator() {
        return List.super.spliterator();
    }

    /**
     * Returns a sequential {@code Stream} with this collection as its source.
     *
     * <p>This method should be overridden when the {@link #spliterator()}
     * method cannot return a spliterator that is {@code IMMUTABLE},
     * {@code CONCURRENT}, or <em>late-binding</em>. (See {@link #spliterator()}
     * for details.)
     *
     * @return a sequential {@code Stream} over the elements in this collection
     * @implSpec The default implementation creates a sequential {@code Stream} from the
     * collection's {@code Spliterator}.
     * @since 1.8
     */
    @Override
    public Stream<E> stream() {
        return super.stream();
    }

    /**
     * Returns a possibly parallel {@code Stream} with this collection as its
     * source.  It is allowable for this method to return a sequential stream.
     *
     * <p>This method should be overridden when the {@link #spliterator()}
     * method cannot return a spliterator that is {@code IMMUTABLE},
     * {@code CONCURRENT}, or <em>late-binding</em>. (See {@link #spliterator()}
     * for details.)
     *
     * @return a possibly parallel {@code Stream} over the elements in this
     * collection
     * @implSpec The default implementation creates a parallel {@code Stream} from the
     * collection's {@code Spliterator}.
     * @since 1.8
     */
    @Override
    public Stream<E> parallelStream() {
        return super.parallelStream();
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * Removes all of the elements of this collection that satisfy the given
     * predicate.  Errors or runtime exceptions thrown during iteration or by
     * the predicate are relayed to the caller.
     *
     * @param filter a predicate which returns {@code true} for elements to be
     *               removed
     * @return {@code true} if any elements were removed
     * @throws NullPointerException          if the specified filter is null
     * @throws UnsupportedOperationException if elements cannot be removed
     *                                       from this collection.  Implementations may throw this exception if a
     *                                       matching element cannot be removed or if, in general, removal is not
     *                                       supported.
     * @implSpec The default implementation traverses all elements of the collection using
     * its {@link #iterator}.  Each matching element is removed using
     * {@link Iterator#remove()}.  If the collection's iterator does not
     * support removal then an {@code UnsupportedOperationException} will be
     * thrown on the first matching element.
     * @since 1.8
     */
    @Override
    public boolean removeIf(Predicate filter) {
        return super.removeIf(filter);
    }

    /**
     * Replaces each element of this list with the result of applying the
     * operator to that element.  Errors or runtime exceptions thrown by
     * the operator are relayed to the caller.
     *
     * @param operator the operator to apply to each element
     * @throws UnsupportedOperationException if this list is unmodifiable.
     *                                       Implementations may throw this exception if an element
     *                                       cannot be replaced or if, in general, modification is not
     *                                       supported
     * @throws NullPointerException          if the specified operator is null or
     *                                       if the operator result is a null value and this list does
     *                                       not permit null elements
     *                                       (<a href="Collection.html#optional-restrictions">optional</a>)
     * @implSpec The default implementation is equivalent to, for this {@code list}:
     * <pre>{@code
     *     final ListIterator<E> li = list.listIterator();
     *     while (li.hasNext()) {
     *         li.set(operator.apply(li.next()));
     *     }
     * }</pre>
     * <p>
     * If the list's list-iterator does not support the {@code set} operation
     * then an {@code UnsupportedOperationException} will be thrown when
     * replacing the first element.
     * @since 1.8
     */
    @Override
    public void replaceAll(UnaryOperator operator) {
        List.super.replaceAll(operator);
    }

    /**
     * Sorts this list according to the order induced by the specified
     * {@link Comparator}.
     *
     * <p>All elements in this list must be <i>mutually comparable</i> using the
     * specified comparator (that is, {@code c.compare(e1, e2)} must not throw
     * a {@code ClassCastException} for any elements {@code e1} and {@code e2}
     * in the list).
     *
     * <p>If the specified comparator is {@code null} then all elements in this
     * list must implement the {@link Comparable} interface and the elements'
     * {@linkplain Comparable natural ordering} should be used.
     *
     * <p>This list must be modifiable, but need not be resizable.
     *
     * @param c the {@code Comparator} used to compare list elements.
     *          A {@code null} value indicates that the elements'
     *          {@linkplain Comparable natural ordering} should be used
     * @throws ClassCastException            if the list contains elements that are not
     *                                       <i>mutually comparable</i> using the specified comparator
     * @throws UnsupportedOperationException if the list's list-iterator does
     *                                       not support the {@code set} operation
     * @throws IllegalArgumentException      (<a href="Collection.html#optional-restrictions">optional</a>)
     *                                       if the comparator is found to violate the {@link Comparator}
     *                                       contract
     * @implSpec The default implementation obtains an array containing all elements in
     * this list, sorts the array, and iterates over this list resetting each
     * element from the corresponding position in the array. (This avoids the
     * n<sup>2</sup> log(n) performance that would result from attempting
     * to sort a linked list in place.)
     * @implNote This implementation is a stable, adaptive, iterative mergesort that
     * requires far fewer than n lg(n) comparisons when the input array is
     * partially sorted, while offering the performance of a traditional
     * mergesort when the input array is randomly ordered.  If the input array
     * is nearly sorted, the implementation requires approximately n
     * comparisons.  Temporary storage requirements vary from a small constant
     * for nearly sorted input arrays to n/2 object references for randomly
     * ordered input arrays.
     *
     * <p>The implementation takes equal advantage of ascending and
     * descending order in its input array, and can take advantage of
     * ascending and descending order in different parts of the same
     * input array.  It is well-suited to merging two or more sorted arrays:
     * simply concatenate the arrays and sort the resulting array.
     *
     * <p>The implementation was adapted from Tim Peters's list sort for Python
     * (<a href="http://svn.python.org/projects/python/trunk/Objects/listsort.txt">
     * TimSort</a>).  It uses techniques from Peter McIlroy's "Optimistic
     * Sorting and Information Theoretic Complexity", in Proceedings of the
     * Fourth Annual ACM-SIAM Symposium on Discrete Algorithms, pp 467-474,
     * January 1993.
     * @since 1.8
     */
    @Override
    public void sort(Comparator c) {
        List.super.sort(c);
    }
}
