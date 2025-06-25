import java.util.AbstractList;
import java.util.Collection;

public class MyArrayList<E> extends AbstractList<E> {

    private E[] array;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private static final double GROWTH_FACTOR = 1.5;

    public MyArrayList() {
        array = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public boolean add(E element) {
        if (size == array.length) {
            expandCapacity();
        }
        array[size++] = element;
        return false;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private void expandCapacity() {
        int newCapacity = (int) (array.length * GROWTH_FACTOR);
        Object[] newArray = new Object[newCapacity];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = (E[]) newArray;
    }

    public E get(int index) {
        checkIndex(index);
        return array[index];
    }

    public int size() {
        return size;
    }

    public E remove(int index) {
        checkIndex(index);
        E removedElement = array[index];
        size--;
        System.arraycopy(array, index + 1, array, index, size - index);
        array[size] = null;
        return removedElement;
    }

    public boolean addAll(Collection<? extends E> collection) {
        if (collection == null || collection.isEmpty()) return false;
        int neededCapacity = size + collection.size();
        if (neededCapacity > array.length) {
            expandCapacityTo(neededCapacity);
        }
        for (E element : collection) {
            array[size++] = element;
        }

        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void expandCapacityTo(int capacity) {
        int newCapacity = (int) Math.max(capacity, array.length * GROWTH_FACTOR);
        Object[] newArray = new Object[newCapacity];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = (E[]) newArray;
    }

}
