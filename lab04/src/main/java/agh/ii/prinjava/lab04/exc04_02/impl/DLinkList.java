package agh.ii.prinjava.lab04.exc04_02.impl;

/**
 * A doubly linked list implementation
 * @param <E> Type of elements in the list
 */
public class DLinkList<E> {
    private Node<E> first;
    private Node<E> last;


    // Node definition
    private static class Node<T> {
        T element;
        Node<T> next;
        Node<T> prev;
    }

    /**
     * Adds an element to the beginning of the linked list.
     *
     * @param e the element to be added to the beginning of the list
     */
    public void addFirst(E e) {
        Node<E> newNode = new Node<>();
        newNode.element = e;
        newNode.next = first;
        if (first != null) first.prev = newNode;
        else last = newNode;
        first = newNode;
    }

    /**
     * Adds an element to the end of the linked list.
     *
     * @param e the element to be added to the end of the list
     */
    public void addLast(E e) {
        Node<E> newNode = new Node<>();
        newNode.element = e;
        newNode.prev = last;
        if (last != null) last.next = newNode;
        else first = newNode;
        last = newNode;
    }


    /**
     * Removes the first element from the linked list and returns it.
     *
     * @return the first element of the list
     */
    public E removeFirst() {
        E element = first.element;
        first = first.next;
        if (first != null) first.prev = null;
        else last = null;
        return element;
    }


    /**
     * Removes the last element from the linked list and returns it.
     *
     * @return the last element of the list
     */
    public E removeLast() {
        E element = last.element;
        last = last.prev;
        if (last != null) last.next = null;
        else first = null;
        return element;
    }

    /**
     * Returns a string representation of the linked list.
     *
     * @return a string representation of the linked list
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node<E> current = first;
        while (current != null) {
            sb.append(current.element).append(" ");
            current = current.next;
        }
        return sb.toString().trim();
    }
}
