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
package arrays;

/**
 * @author LuoHaiYang
 */
import java.util.ArrayList;

public class MyArray<E> {
    //存储的数据
    private E[] data;
    //数组大小，数组容量大小不一定等于数组实际大小
    private int size;

    //设置数组大小
    public MyArray(int capacity) {
        data = (E[])new Object[capacity];
        this.size = capacity;
    }

    public MyArray() {
        this(10);
    }

    //数组容量大小
    public int getCapacity() {
        return this.data.length;
    }

    //数组元素大小
    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //在index索引位置插入新元素
    public void insert(int index, E value) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("添加失败，数组索引越界!");
        }

        //如果数组容量不足，则扩容两倍
        if (size == data.length) {
            resize(2 * size);
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = value;
        size ++;
    }

    public E delete(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("删除失败，数组索引越界!");
        }

        E delValue = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i +1];
        }
        size --;
        data[size] = null; //gc
        return delValue;
    }

    public void update(int index, E value) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("删除失败，数组索引越界!");
        }
        data[index] = value;
    }

    public void resize(int newSize) {
        E[] newData = (E[])new Object[newSize];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    private void printData(E[] data, int size) {
        System.out.println();
        for (int j = 0; j < size; j++) {
            System.out.print(data[j]);
            if (j != size) {
                System.out.print(",");
            } else {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(6);

        System.out.println(list.indexOf(6));

        /*int size = 5;
        MyArray myArray = new MyArray(size);

        //增加
        for (int i = 0; i < 3; i++) {
            myArray.insert(i, i);
        }
        myArray.printData(myArray.data, myArray.size);

        //删除
        System.out.println(myArray.delete(1));
        myArray.printData(myArray.data, myArray.size);

        //修改
        myArray.update(1, 666);
        myArray.printData(myArray.data, myArray.size);*/
    }
}
