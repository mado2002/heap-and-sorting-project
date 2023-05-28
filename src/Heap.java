import java.util.ArrayList;

public class Heap {
    public ArrayList<Integer> arr;
    public int size;

    public Heap(ArrayList<Integer> initialArray) {
        this.arr = initialArray;
        this.size = initialArray.size();
        buildMaxHeap(arr);
    }

    public int parent(int i) {
        return (i - 1) / 2;
    }

    public int leftChild(int i) {
        return 2 * i + 1;
    }

    public int rightChild(int i) {
        return 2 * i + 2;
    }

    public void swap(int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    public void maxHeapify(ArrayList<Integer> list, int n, int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int max = index;

        if (left < n && list.get(left) > list.get(max)) {
            max = left;
        }

        if (right < n && list.get(right) > list.get(max)) {
            max = right;
        }

        if (max != index) {
            swap(index, max);
            maxHeapify(list, n, max);
        }
    }

    public void buildMaxHeap(ArrayList<Integer> list) {
        int n = list.size();
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(list, n, i);
        }
    }


    public void insert(int value) {
        arr.add(size, value);
        heapifyUp(size);
        size++;
    }

    public void heapifyUp(int i) {
        while (i > 0 && arr.get(i) > arr.get(parent(i))) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    public int extract() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        int ans = arr.get(0);
        swap(0, size - 1);
        arr.remove(size - 1);
        size--;
        heapifyDown(0);
        return ans;
    }

    public void heapifyDown(int i) {
        int largest = i;
        int left = leftChild(i);
        int right = rightChild(i);

        if (left < size && arr.get(left) > arr.get(largest)) {
            largest = left;
        }

        if (right < size && arr.get(right) > arr.get(largest)) {
            largest = right;
        }

        if (largest != i) {
            swap(i, largest);
            heapifyDown(largest);
        }
    }

    public void printArr() {
        System.out.println(size);
        for (int i = 0; i < size; i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return size == 0;
    }

}
