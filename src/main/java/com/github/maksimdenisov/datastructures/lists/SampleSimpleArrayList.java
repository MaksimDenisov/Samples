package com.github.maksimdenisov.datastructures.lists;

import java.util.NoSuchElementException;

/**
 * Dynamic array, growable array, resizable array, dynamic table, mutable array, or array list is a random access,
 * variable-size list data structure that allows elements to be added or removed.
 * Dynamic arrays overcome a limit of static arrays,
 * which have a fixed capacity that needs to be specified at allocation.
 *
 * @param <T>
 */
public class SampleSimpleArrayList<T> implements SampleSimpleList<T> {

    private Object[] array = new Object[8];
    private int size = 0;

    @Override
    public void add(T element) {
        doublingArrayIfNecessary(size);
        array[size] = element;
        size++;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(int index) throws NoSuchElementException {
        throwExceptionIfOutOfRange(index);
        return (T) array[index];
    }

    @Override
    public void insert(int index, T element) throws NoSuchElementException {
        if (index != size) {
            throwExceptionIfOutOfRange(index);
        }
        doublingArrayIfNecessary(size);
        shiftDataToRight(index);
        array[index] = element;
        size++;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T replace(int index, T element) throws NoSuchElementException {
        throwExceptionIfOutOfRange(index);
        T oldValue = (T) array[index];
        array[index] = element;
        return oldValue;
    }

    @Override
    public boolean delete(int index) {
        try {
            throwExceptionIfOutOfRange(index);
        } catch (NoSuchElementException e) {
            return false;
        }
        shiftDataToLeft(index);
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    private void doublingArrayIfNecessary(int index) {
        if (index >= array.length) {
            Object[] newArray = new Object[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }

    private void shiftDataToLeft(int index) {
        for (int i = index; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
    }

    private void shiftDataToRight(int index) {
        for (int i = array.length - 2; i >= index; i--) {
            array[i + 1] = array[i];
        }
    }

    private void throwExceptionIfOutOfRange(int index) throws NoSuchElementException {
        if (index < 0 || index >= size) {
            throw new NoSuchElementException(String.format("There is no element with index = %d", index));
        }
    }
}
