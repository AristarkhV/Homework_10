package mateacademy.homework.homework_8;

public class Main {

    public static void main(String[] args) {
        Storage<Integer, String> storage = new Storage<>();
        storage.put(1, "first");
        storage.put(2, "second");
        storage.put(3, "third");
        storage.put(4, "fourth");
        storage.put(4, "blabla");
        storage.put(5, "set");
        storage.put(6, "777");

        System.out.println(storage.get(1));
        System.out.println(storage.get(2));
        System.out.println(storage.get(3));
        System.out.println(storage.get(4));
        System.out.println(storage.get(5));
        System.out.println(storage.get(7));
    }
}
