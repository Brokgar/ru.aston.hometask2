import java.util.LinkedList;
import java.util.List;

public class MyHashSet<T> {

    private List<T>[] list;
    private int size;
    private final double LOAD_FACTOR = 0.75;
    private static final int DEFAULT_CAPACITY = 16;

    public MyHashSet(int initialCapacity) {
        list = new LinkedList[initialCapacity];
        size = 0;
    }

    public MyHashSet() {
        this(DEFAULT_CAPACITY);
    }

    public int size() {
        return size;
    }

    public boolean contains(T item) {
        int index = getIndex(item);
        if (list[index] != null) {
            for (T element : list[index]) {
                if (element.equals(item)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void add(T item) {
        if (loadFactorExceeded()) {
            resize();
        }
        int index = getIndex(item);
        if (list[index] == null) {
            list[index] = new LinkedList<>();
        }
        if (!contains(item)) {
            list[index].add(item);
            size++;
        }
    }


    public void remove(T item) {
        int index = getIndex(item);
        if (list[index] != null) {
            boolean removed = list[index].remove(item);
            if (removed) {
                size--;
            } else {
                throw new IllegalArgumentException("Item not found in HashSet");
            }
        } else {
            throw new IllegalArgumentException("Item not found in HashSet");
        }
    }

    private int getIndex(T item) {
        return Math.abs(item.hashCode()) % list.length;
    }

    private boolean loadFactorExceeded() {
        return (double) size / list.length >= LOAD_FACTOR;
    }


    private void resize() {
        int newCapacity = list.length * 2;
        List<T>[] oldTable = list;
        list = new LinkedList[newCapacity];
        size = 0;

        for (List<T> list : oldTable) {
            if (list != null) {
                for (T item : list) {
                    add(item);
                }
            }
        }
    }



}
