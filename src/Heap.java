import java.util.Arrays;

public class Heap {

    private int[] arr;
    private int size;

    public int getSize() {
        return size;
    }

    public int[] getArr() {
        return arr;
    }

    public Heap(int[] initialArray) {
        arr = Arrays.copyOf(initialArray, initialArray.length);
        size = initialArray.length;
        buildMaxHeap(arr);
    }


    public void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void maxHeapify(int[] list, int n, int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int max = index;

        if (left < n && list[left] > list[max]) {
            max = left;
        }

        if (right < n && list[right] > list[max]) {
            max = right;
        }

        if (max != index) {
            swap(index, max);
            maxHeapify(list, n, max);
        }
    }

    private void buildMaxHeap(int[] list) {
        int n = list.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(list, n, i);
        }
    }
    public void insert(int value) {
        arr = Arrays.copyOf(arr, size + 1);
        arr[size] = value;
        heapifyUp(size);
        size++;
    }

    private void heapifyUp(int size) {
        int parent = (size - 1) / 2;
        if (arr[parent] < arr[size]) {
            swap(parent, size);
            heapifyUp(parent);
        }
    }
    public int extractMax() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        int max = arr[0];
        arr[0] = arr[size - 1];
        size--;
        arr = Arrays.copyOf(arr, size);
        maxHeapify(arr, size, 0);
        return max;
    }
}