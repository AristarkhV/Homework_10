package mateacademy.homework.homework_8;

import java.util.Arrays;

public class Storage<T, K> {

    private int DEFAULTCAPACITY = 10;
    private int currentCapacity;
    private int size;
    private int basket;
    private double loadFactor;
    public Node<K, T>[] values;

    public Storage() {
        currentCapacity = DEFAULTCAPACITY;
        size = 0;
    }

    private int getPutIndex(T key) {
        return key.hashCode() % currentCapacity;
    }

    private boolean isCollision(Node<K, T> node, T key) {
        return (size() > 0 && node != null && node.key != key);
    }

    private void collisionList(Node<K, T>[] node, int basket, Node<K, T> currentNode) {
        if (node[basket].next == null) {
            node[basket].next = currentNode;
        } else {
            Node<K, T> temp = node[basket];
            do {
                temp = temp.next;
            } while (temp.next != null);
            temp.next = currentNode;
        }
    }

    public void put(T key, K value) {
        if (size() == 0) {
            values = new Node[currentCapacity];
        }
        Entry object = new Entry(key, value);
        basket = getPutIndex(key);
        loadFactor = currentCapacity * 0.75;
        if (size < loadFactor) {
            Node<K, T> currentNode = new Node(null, (K) object.getValue(), (T) object.getKey(), null);
            if (isCollision(values[basket], key)) {
                collisionList(values, basket, currentNode);
            } else {
                values[basket] = currentNode;
                size++;
            }
        } else {
            growArray();
            put(key, value);
        }
    }

    public K get(T key) {
        if (values[getPutIndex(key)].key == key) {
            return values[getPutIndex(key)].value;
        }
        Node<K, T> temp = values[getPutIndex(key)];
        do {
            temp = temp.next;
        } while (temp.key != key);
        return temp.value;
    }

    public int size() {
        return size;
    }

    private void growArray() {
        Node<K, T>[] growArray = new Node[currentCapacity * 3 / 2];
        currentCapacity = growArray.length;
        size = 0;
        for (int i = 0; i < values.length; i++) {
            basket = getPutIndex(values[i].key);
            Node<K, T> currentNode = new Node(null, (K) values[i].value, (T) values[i].key, null);
            if (values[i] != null) {
                if (isCollision(growArray[basket], values[i].key)) {
                    collisionList(growArray, basket, currentNode);
                }
            } else {
                growArray[basket] = currentNode;
                size++;
            }
        }
        for (int i = 0; i < values.length; i++) {
            values[i] = null;
        }
        values = Arrays.copyOf(growArray, growArray.length);
    }
}

