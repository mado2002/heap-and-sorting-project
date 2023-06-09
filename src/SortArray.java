import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortArray {
    Heap heap;
    ArrayList<int[]> result;
    boolean file_path_error;
    private  String path;
    private int[] arr;

    public int[] getArr() {
        return arr;
    }

    public SortArray(String path) {
        this.path = path;
        read_from_file(path);
    }
    public SortArray(Integer[] arr) {
        this.arr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            this.arr[i] = arr[i];
        }
    }

    private void read_from_file(String filePath) {
        ArrayList<Integer> arr = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader("testcases/"+filePath))){
            String line;
            while ((line = reader.readLine()) != null){
                String[] strArray = line.split(",");
                for (int i = 0; i < strArray.length; i++) {
                    arr.add(Integer.parseInt(strArray[i]));
                }
            }
        } catch (IOException e) {
            System.out.println("\u001B[31mAn ERROR occurred opening file\u001B[0m ");
        }
        this.arr = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            this.arr[i] = arr.get(i);
        }

    }



    public ArrayList<int[]> heapSort(boolean returnIntermediate) {
        heap = new Heap(arr);
        result = new ArrayList<>();
        int n = heap.getSize();
        int[] sortedArr = heap.getArr();
        if (returnIntermediate) {
            result.add(Arrays.copyOf(arr, n));
            result.add(Arrays.copyOf(sortedArr,n));
        }
        for (int i = n - 1; i >= 0; i--) {
            heap.swap(0, i);
            heap.maxHeapify(sortedArr, i, 0);
            if (returnIntermediate) {
                if (result.size() > 1 && Arrays.equals(result.get(result.size() - 1), sortedArr)) {
                    break;
                }
                result.add(Arrays.copyOf(sortedArr, n));
            }
        }
        if (!returnIntermediate) {
            result.add(Arrays.copyOf(sortedArr, n));
        }
        return result;
    }

    public ArrayList<int[]> simpleSort(boolean returnIntermediate) {
        int n = arr.length;
        int[] sortedArr = arr.clone();
        result = new ArrayList<>();
        //bubble sort algorithm
        if (returnIntermediate) {
            result.add(Arrays.copyOf(sortedArr, n));
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                if (sortedArr[j] > sortedArr[j + 1]) {
                    int temp = sortedArr[j];
                    sortedArr[j] = sortedArr[j + 1];
                    sortedArr[j + 1] = temp;
                }
            }
            if (returnIntermediate) {
                {
                    if (result.size() > 1 && Arrays.equals(result.get(result.size() - 1), sortedArr)) {
                        break;
                    }
                    result.add(Arrays.copyOf(sortedArr, n));
                }
            }
        }
        if (!returnIntermediate) {
            result.add(Arrays.copyOf(sortedArr, n));
        }
        return result;
    }

    public ArrayList<int[]> EfficientSort(boolean returnIntermediate) {
        int[] sorted_array = arr.clone();
        result = new ArrayList<>();
        merge_sort(sorted_array, result, returnIntermediate);
        if (!returnIntermediate)
            result.add(sorted_array);
        return result;
    }

    private void merge_sort(int[] inputArray, ArrayList<int[]> intermediate_result, boolean returnIntermediate) {
        int merge_size = inputArray.length;
        if (merge_size < 2) {
            if (returnIntermediate)
                intermediate_result.add(inputArray);
            return;
        }
        int left_size = merge_size / 2;
        int right_size = merge_size - left_size;
        int[] left_array = new int[left_size];
        int[] right_array = new int[right_size];
        for (int i = 0; i < left_size; i++) {
            left_array[i] = inputArray[i];
        }
        for (int i = left_size; i < merge_size; i++) {
            right_array[i - left_size] = inputArray[i];
        }
        merge_sort(left_array, intermediate_result, returnIntermediate);
        merge_sort(right_array, intermediate_result, returnIntermediate);
        merge(inputArray, left_array, right_array, intermediate_result, returnIntermediate);

    }

    private void merge(int[] inputArray, int[] leftArray, int[] rightArray, ArrayList<int[]> intermediate_result, boolean returnIntermediate) {
        int left_size = leftArray.length;
        int right_size = rightArray.length;
        int i = 0, j = 0, k = 0;

        while (i < left_size && j < right_size) {
            if (leftArray[i] <= rightArray[j]) {
                inputArray[k] = leftArray[i++];
            } else {
                inputArray[k] = rightArray[j++];
            }
            k++;
        }
        while (i < left_size) {
            inputArray[k++] = leftArray[i++];
        }
        while (j < right_size) {
            inputArray[k++] = rightArray[j++];
        }
        if (returnIntermediate)
            intermediate_result.add(inputArray);
    }

    public ArrayList<int[]> Non_Comparison_Sort(boolean returnIntermediate) {
        int n = arr.length;
        result = new ArrayList<>();
        int min = Arrays.stream(arr).min().orElse(0);
        int max = Arrays.stream(arr).max().orElse(Integer.MAX_VALUE);
        int[] sortedArray = arr.clone();
        if (max==Integer.MAX_VALUE) {
            max = 1000000;// to avoid overflow in countArray (put it as your heap size )
        }
        int[] countArray = new int[max - min + 1];
        for (int value : sortedArray) {
            countArray[value - min]++;
        }
        int index = 0;
        if (returnIntermediate) {
            result.add(Arrays.copyOf(sortedArray, n));
        }
        for (int i = 0; i < max - min + 1; i++) {
            while (countArray[i] > 0) {
                sortedArray[index++] = i + min;
                countArray[i]--;
            }
            if (returnIntermediate)
                result.add(Arrays.copyOf(sortedArray, n));
        }
        if (!returnIntermediate)
            result.add(Arrays.copyOf(sortedArray, n));
        return result;
    }

}
