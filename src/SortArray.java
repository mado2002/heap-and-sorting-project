import java.util.Arrays;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class SortArray {
    private String path;
    private int [] arr;
    public SortArray(String path) {
        this.path=path;
        read_from_file();
    }
    public void read_from_file()
    {
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            line = bufferedReader.readLine();
            String[] strArray = line.split(",");
            arr=new int[strArray.length];
            for (int i = 0; i < strArray.length; i++) {
                arr[i] = Integer.parseInt(strArray[i]);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public  int[] simpleSort(boolean returnIntermediate) {
        int n = arr.length;
        int[] sortedArr = Arrays.copyOf(arr, n);
        int[][] intermediateArrays = new int[n - 1][n];
          //bubble sort algorithm
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (sortedArr[j] > sortedArr[j + 1]) {
                    int temp = sortedArr[j];
                    sortedArr[j] = sortedArr[j + 1];
                    sortedArr[j + 1] = temp;
                    intermediateArrays[i] = Arrays.copyOf(sortedArr, n);
                }
            }
        }

        if (returnIntermediate) {
            for (int[] intermediateArray : intermediateArrays) {
                System.out.println(Arrays.toString(intermediateArray));
            }
        }

        return sortedArr;
    }
}
