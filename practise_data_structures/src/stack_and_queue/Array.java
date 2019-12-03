/*
 * Copyright (c) 2016 Tianbao Travel Ltd.
 * www.tianbaotravel.com
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Tianbao Travel Ltd. ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement you
 * entered into with Tianbao Travel Ltd.
 */
package stack_and_queue;

/**
 * @author LuoHaiYang
 *
 * 数组
 *
 */
public class Array<E> {

    private E[] data;
    private int size;

    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    // 获取数组的容量
    public int getCapacity() {
        return this.data.length;
    }

    // 获取数组中元素的个数
    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    // 时间：O(n) 空间：O(1)
    public void add(int index, E e) {

        if (index < 0 || index > this.size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }

        if (size == this.data.length) {
            // 扩容两倍
        }

        // [1, e , 2, 3, 4, null, null]
        for (int i = this.size - 1 ; i >= index ; i--) {
            this.data[i + 1] = this.data[i];
        }

        this.data[index] = e;
        this.size ++;

    }

    // 时间：O(1) 空间：O(1)
    public void addLast(E e) {
        this.add(this.size, e);
    }

    // 时间：O(n) 空间：O(1)
    public void addFirst(E e) {
        this.add(0, e);
    }

    // 时间：O(1) 空间：O(1)
    public E get(int index) {
        if (index < 0 || index > this.size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }

        return this.data[index];
    }

    // 时间：O(1) 空间：O(1)
    public E getLast() {
        return get(this.size - 1);
    }

    // 时间：O(1) 空间：O(1)
    public E getFirst() {
        return get(0);
    }

    // 时间：O(1) 空间：O(1)
    public void set(int index, E e) {
        if (index < 0 || index > this.size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }
        data[index] = e;
    }

    // 时间：O(n) 空间：O(1)
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    public int find(E e) {
        for (int i = 0; i < this.size; i++) {
            if (this.data[i].equals(e)) {
                return i;
            }
        }

        return -1;
    }

    public E remove(int index) {
        if (index < 0 || index > this.size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }
        E ret = data[index];
        for (int i = index + 1 ; i < size; i++) {
            data[i - 1] = data[i];
        }

        size --;
        data[size] = null; // detech

        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }

    public E removeLast() {
        return this.remove(size - 1);
    }

    public E removeFirst() {
        return this.remove(0);
    }

    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
