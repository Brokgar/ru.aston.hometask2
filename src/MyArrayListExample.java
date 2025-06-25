class MyArrayListExample {

    public static void main(String[] args) {

        MyArrayList<Integer> list = new MyArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }

        System.out.println("Size: " + list.size());
        System.out.println("Element at index 15: " + list.get(15));

        list.remove(10);
        System.out.println("Size after remove: " + list.size());
        System.out.println("Element at index 10 after remove: " + list.get(10));

        MyArrayList<Integer> list2 = new MyArrayList<>();
        list2.add(20);
        list2.add(21);
        list2.addAll(list);
        System.out.println("Size after addAll: " + list2.size());
        System.out.println("Element at index 10 after addAll: " + list2.get(10));

    }

}