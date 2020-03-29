package arraylist;

public class MyArrayList<Item> {
    private Object[] list = new Object[8];
    private int size;

    public int size() {
        return size;
    }

    public void set(int index, Item item) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        list[index] = item;
    }

    public Item get(int index) { //arr[index]
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        return (Item) list[index];
    }

    public void add(Item item) {
        if (size == list.length) {
            resize(2 * list.length);
        }
        list[size] = item;
        size++;
    }

    public int indexOf(Item item) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(Item item) {
        return indexOf(item) != -1;
    }

    private void resize(int capacity) {
        Object[] temp = new Object[capacity];
        System.arraycopy(list, 0, temp, 0, list.length);
    }

    public boolean remove(Item item) {
        int i = 0;
        while (i < size && !list[i].equals(item)) {
            i++;
        }

        if (i == size) {
            return false;
        }

        for (int j = i; j < size - 1; j++) {
            list[j] = list[j + 1];
        }
        list[size - 1] = null;
        size--;

        if (size == list.length / 4 && size > 0) {
            resize(list.length / 2);
        }

        return true;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < size; i++) {
            s.append(list[i]);
            s.append(", ");
        }
        return s.toString();
    }
}
