package com.fishion.demo.datastructure.queue;

public interface MyQueue<E> extends  Iterable{

    /**
     * 返回队列大小
     * @return
     */
    int size();

    /**
     * 判断队列是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 队尾插入元素
     * @param e
     * @return
     */
    boolean add(E e);


    /**
     * 待实现
     * @param e
     * @return
     */
    boolean offer(E e);

    /**
     * 删除并返回队首元素，空队列报错
     * @return
     */
    E remove();

    /**
     * 删除并返回队首元素，空队列返回null
     * @return
     */
    E poll();

    /**
     * 只获取队首元素
     * @return
     */
    E peek();

}
