
import java.util.Arrays;

public class IntegerArrayList implements IntegerList {
    private static final int DefaultCapacity = 10;

    private Integer[] elements;
    private int size;

    public IntegerArrayList() {
        this.elements = new Integer[DefaultCapacity];
        this.size = 0;
    }

    public IntegerArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Invalid initial capacity: " + initialCapacity);
        }
        this.elements = new Integer[initialCapacity];
        this.size = 0;
    }
    @Override
    public Integer add(int index, Integer item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        validateIndexForAdd(index);
        ensureCapacity(size + 1);
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = item;
        size++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        validateIndex(index);
        Integer replacedItem = elements[index];
        elements[index] = item;
        return replacedItem;
    }

    @Override
    public Integer remove(Integer item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        for (int i = 0; i < size; i++) {
            if (item.equals(elements[i])) {
                return removeAtIndex(i);
            }
        }
        throw new IllegalArgumentException("Item not found: " + item);
    }

    @Override
    public Integer remove(int index) {
        validateIndex(index);
        return removeAtIndex(index);
    }

    private Integer removeAtIndex(int index) {
        Integer removedItem = elements[index];
        int numElementsToShift = size - index - 1;
        if (numElementsToShift > 0) {
            System.arraycopy(elements, index + 1, elements, index, numElementsToShift);
        }
        elements[--size] = null;
        return removedItem;
    }

    @Override
    public boolean contains(Integer item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(Integer item) {
        if (item == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (item.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        if (item == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (item.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        validateIndex(index);
        return elements[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        if (this == otherList) {
            return true;
        }
        if (otherList == null || getClass() != otherList.getClass()) {
            return false;
        }
        IntegerArrayList other = (IntegerArrayList) otherList;
        if (size != other.size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!elements[i].equals(other.elements[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        Arrays.fill(elements, null);
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    @Override
    public int binarySearch(Integer item) {
        sort();
        return binarySearch(item, 0, size - 1);
    }

    private int binarySearch(Integer item, int low, int high) {
        if (low <= high) {
            int mid = low + (high - low) / 2;
            if (elements[mid].equals(item)) {
                return mid;
            }
            if (elements[mid] < item) {
                return binarySearch(item, mid + 1, high);
            }
            return binarySearch(item, low, mid - 1);
        }
        return -1;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = Math.max(minCapacity, elements.length * 2);
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private void validateIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
    private void grow() {
        int newCapacity = elements.length + (elements.length >> 1); // Увеличение емкости на 50%
        elements = Arrays.copyOf(elements, newCapacity);
    }
    @Override
    public Integer add(Integer item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        if (size == elements.length) {
            grow(); // Расширение массива, если он заполнен
        }
        elements[size++] = item;
        return item;
    }

    public void sort() {
        mergeSort(0, size - 1);
    }
    private void mergeSort(int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(low, mid);
            mergeSort(mid + 1, high);
            merge(low, mid, high);
        }
    }

    private void merge(int low, int mid, int high) {
        int leftSize = mid - low + 1;
        int rightSize = high - mid;

        Integer[] left = new Integer[leftSize];
        Integer[] right = new Integer[rightSize];

        System.arraycopy(elements, low, left, 0, leftSize);
        System.arraycopy(elements, mid + 1, right, 0, rightSize);

        int i = 0, j = 0, k = low;
        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                elements[k++] = left[i++];
            } else {
                elements[k++] = right[j++];
            }
        }

        while (i < leftSize) {
            elements[k++] = left[i++];
        }

        while (j < rightSize) {
            elements[k++] = right[j++];
        }
    }
}
