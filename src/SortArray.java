import java.util.ArrayList;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class SortArray {
    private String path;
    private int [] arr;
    ArrayList<String> intermediate_result;
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
         intermediate_result=new ArrayList<>();
          //bubble sort algorithm
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (sortedArr[j] > sortedArr[j + 1]) {
                    int temp = sortedArr[j];
                    sortedArr[j] = sortedArr[j + 1];
                    sortedArr[j + 1] = temp;
                }
            }
            intermediate_result.add(Arrays.toString(sortedArr));
        }

        if(returnIntermediate)
        {
            for(String s:intermediate_result)
            {
                System.out.println(s);
            }
        }

        return sortedArr;
    }
    public int[] EfficientSort(boolean returnIntermediate)
    {
        int []sorted_array=arr.clone();
         intermediate_result=new ArrayList<>();
        merge_sort(sorted_array,intermediate_result);
        if(returnIntermediate)
        {
            for(String s:intermediate_result)
            {
                System.out.println(s);
            }
        }
        return  sorted_array;
    }
    private void merge_sort(int [] inputArray,ArrayList<String> intermediate_result)
    {
        int merge_size= inputArray.length;
        if(merge_size<2) {
            intermediate_result.add(Arrays.toString(inputArray));
            return;
        }
        int left_size=merge_size/2;
        int right_size=merge_size-left_size;
        int [] left_array=new int[left_size];
        int [] right_array=new int[right_size];
        for(int i=0;i<left_size;i++)
        {
            left_array[i]=inputArray[i];
        }
        for(int i=left_size;i<merge_size;i++)
        {
            right_array[i-left_size]=inputArray[i];
        }
        merge_sort(left_array,intermediate_result);
        merge_sort(right_array,intermediate_result);
        merge(inputArray,left_array,right_array,intermediate_result);

    }
    private void merge(int[] inputArray,int [] leftArray,int [] rightArray,ArrayList<String> intermediate_result)
    {
        int left_size= leftArray.length;
        int right_size= rightArray.length;
        int i=0,j=0,k=0;

        while(i<left_size && j<right_size)
        {
            if(leftArray[i]<=rightArray[j])
            {
                inputArray[k]=leftArray[i++];
            }
            else {
                inputArray[k]=rightArray[j++];
            }
            k++;
        }
        while (i<left_size)
        {
         inputArray[k++]=leftArray[i++];
        }
        while (j<right_size)
        {
            inputArray[k++]=rightArray[j++];
        }
        intermediate_result.add(Arrays.toString(inputArray));
    }
    public int [] Non_Comparison_Sort(boolean returnIntermediate)
    {
        int min=Arrays.stream(arr).min().orElse(0);
        int max=Arrays.stream(arr).max().orElse(Integer.MAX_VALUE);
        int [] sortedArray=arr.clone();
        int []countArray=new int[max-min+1];
        for(int value:sortedArray)
        {
            countArray[value-min]++;
        }
        int index=0;
        for (int i=0;i<max-min+1;i++)
        {
            while (countArray[i]>0)
            {
                sortedArray[index++]=i+min;
                countArray[i]--;
            }
        }
        return sortedArray;
    }

}
