package com.github.maksimdenisov.datastructures.lists;

import java.util.NoSuchElementException;

/**
 * Simple implementation of linked list.
 *
 * @param <T> Type of elements.
 */
public class SampleSimpleLinkedList<T> implements SampleSimpleList<T> {

    private int size = 0;

    private class Node {
        T element;
        Node next;

        public Node(T element) {
            this.element = element;
        }
    }

    private Node root = null;

    @Override
    public void add(T element) {
        if (root == null) {
            root = new Node(element);
            size++;
            return;
        }
        Node node = root;
        while (node.next != null) {
            node = node.next;
        }
        node.next = new Node(element);
        size++;
    }

    @Override
    public T get(int index) {
        return getNodeAtIndex(index).element;
    }

    @Override
    public void insert(int index, T element) {
        Node node = new Node(element);
        if (index == 0) {
            node.next = root;
            root = node;
            size++;
            return;
        }
        try {
            Node existNode = getNodeAtIndex(index - 1);
            node.next = existNode.next;
            existNode.next = node;
            size++;
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(String.format("There is no element with index = %d", index));
        }
    }

    @Override
    public T replace(int index, T element) {
        Node node = getNodeAtIndex(index);
        T previous = node.element;
        node.element = element;
        return previous;
    }

    @Override
    public boolean delete(int index) {
        if (index == 0) {
            root = root.next;
            size--;
            return true;
        }
        try {
            Node existNode = getNodeAtIndex(index - 1);
            existNode.next = existNode.next.next;
            size--;
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Override
    public int size() {
        return size;
    }

    private Node getNodeAtIndex(int index) {
        if (index == 0) {
            if (root != null) {
                return root;
            } else {
                throw new NoSuchElementException(String.format("There is no element with index = %d", index));
            }
        }
        int i = 0;
        Node node = root;
        while (i != index) {
            if (node.next == null) {
                throw new NoSuchElementException(String.format("There is no element with index = %d", index));
            }
            node = node.next;
            i++;
        }
        return node;
    }
}
