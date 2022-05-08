package com.github.maksimdenisov.datastructures.lists;

import java.util.NoSuchElementException;

/**
 * Abstract data type that represents a finite number of ordered values,
 * where the same value may occur more than once.
 *
 * @param <T> Type of elements.
 */
public interface SampleSimpleList<T> {

    /**
     * Adding element to end of list.
     *
     * @param element The adding element.
     */
    void add(T element);

    /**
     * Getting element with index.
     *
     * @param index Serial number starting from zero.
     * @return Element at index.
     */
    T get(int index) throws NoSuchElementException;

    /**
     * Inserting element at index.
     *
     * @param index   Serial number starting from zero.
     * @param element The inserting element.
     */
    void insert(int index, T element) throws NoSuchElementException;

    /**
     * Replacing element with index.
     *
     * @param index Serial number starting from zero.
     * @return Previous value.
     */
    T replace(int index, T element) throws NoSuchElementException;

    /**
     * Deleting element with index.
     *
     * @param index Serial number starting from zero.
     * @return True if element exist.
     */
    boolean delete(int index);

    /**
     * Getting size of list
     *
     * @return size of list
     */
    int size();
}
