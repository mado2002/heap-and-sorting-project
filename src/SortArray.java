import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class SortArray {
    private String path;
    private int[] arr;
    ArrayList<String> result;
    boolean file_path_error;

    public SortArray(String path) {
        this.path = path;
        read_from_file();
    }

    public void read_from_file() {
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            line = bufferedReader.readLine();
            String[] strArray = line.split(",");
            arr = new int[strArray.length];
            for (int i = 0; i < strArray.length; i++) {
                arr[i] = Integer.parseInt(strArray[i]);
            }
            bufferedReader.close();
            file_path_error = false;
        } catch (IOException e) {
            file_path_error = true;
//            e.printStackTrace();

        }
    }

    public ArrayList<String> simpleSort(boolean returnIntermediate) {
        int n = arr.length;
        int[] sortedArr = Arrays.copyOf(arr, n);
        result = new ArrayList<>();
        //bubble sort algorithm
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (sortedArr[j] > sortedArr[j + 1]) {
                    int temp = sortedArr[j];
                    sortedArr[j] = sortedArr[j + 1];
                    sortedArr[j + 1] = temp;
                }
            }
            if (returnIntermediate)
                result.add(Arrays.toString(sortedArr));
        }
        result.add(Arrays.toString(sortedArr));

        return result;
    }

    public ArrayList<String> EfficientSort(boolean returnIntermediate) {
        int[] sorted_array = arr.clone();
        result = new ArrayList<>();
        merge_sort(sorted_array, result, returnIntermediate);
        if (!returnIntermediate)
            result.add(Arrays.toString(sorted_array));
        return result;
    }

    private void merge_sort(int[] inputArray, ArrayList<String> intermediate_result, boolean returnIntermediate) {
        int merge_size = inputArray.length;
        if (merge_size < 2) {
            if (returnIntermediate)
                intermediate_result.add(Arrays.toString(inputArray));
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

    private void merge(int[] inputArray, int[] leftArray, int[] rightArray, ArrayList<String> intermediate_result, boolean returnIntermediate) {
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
            intermediate_result.add(Arrays.toString(inputArray));
    }

    public ArrayList<String> Non_Comparison_Sort(boolean returnIntermediate) {
        result = new ArrayList<>();
        int min = Arrays.stream(arr).min().orElse(0);
        int max = Arrays.stream(arr).max().orElse(Integer.MAX_VALUE);
        int[] sortedArray = arr.clone();
        int[] countArray = new int[max - min + 1];
        for (int value : sortedArray) {
            countArray[value - min]++;
        }
        int index = 0;
        for (int i = 0; i < max - min + 1; i++) {
            while (countArray[i] > 0) {
                sortedArray[index++] = i + min;
                countArray[i]--;
            }
            if (returnIntermediate)
                result.add(Arrays.toString(sortedArray));
        }
        if (!returnIntermediate)
            result.add(Arrays.toString(sortedArray));
        return result;
    }

}
