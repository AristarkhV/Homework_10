package mateacademy.homework.homework_8;

public class Node<K, T> {
    public Entry<T, K> entry;
    public Node<K, T> prev;
    public Node<K, T> next;

    public Node(Node<K, T> prev, Entry entry, Node<K, T> next) {
        this.entry = entry;
        this.prev = prev;
        this.next = next;
    }
}
