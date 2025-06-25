class MyHashSetExample {
    public static void main(String[] args) {

        MyHashSet<Integer> set = new MyHashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(1);
        System.out.println("Size: " + set.size()); // 4
        System.out.println("Contains 1: " + set.contains(1)); // true
        set.remove(2);
        System.out.println("Size: " + set.size()); // 3
        System.out.println("Contains 2: " + set.contains(2)); // false

    }
}