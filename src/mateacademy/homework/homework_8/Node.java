package mateacademy.homework.homework_8;

public class Node<K, T> {
    public K value;
    public T key;
    public Node<K, T> prev;
    public Node<K, T> next;

    public Node(Node<K, T> prev, K value, T key, Node<K, T> next) {
        this.value = value;
        this.key = key;
        this.prev = prev;
        this.next = next;
    }
}
