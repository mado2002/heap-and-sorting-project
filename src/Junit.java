import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class Junit {
SortArray sortArray1=new SortArray("100.txt");
    SortArray sortArray2=new SortArray("1000.txt");
    SortArray sortArray3=new SortArray("10,000.txt");
    SortArray sortArray4=new SortArray("100,000.txt");
    SortArray sortArray5=new SortArray("bestCounting.txt");
    SortArray sortArray6=new SortArray("test1.txt");
    SortArray sortArray7=new SortArray("Counting.txt");
    SortArray sortArray8=new SortArray("2.txt");
    @Test
    public void Test_Simple_sort(){
     ArrayList<int []> result=sortArray1.simpleSort(false);
      int [] arr=sortArray1.getArr();
      //sorting the array with built-in java sort
        Arrays.sort(arr);
     boolean equals=(Arrays.toString(result.get(0)).equals(Arrays.toString(arr)));
     assertTrue(equals);
    }
    @Test
    public void Test_Efficient_sort()
    {
        ArrayList<int []> result=sortArray1.EfficientSort(false);

        int [] arr=sortArray1.getArr();
        //sorting the array with built-in java sort
        Arrays.sort(arr);
        boolean equals=(Arrays.toString(result.get(0)).equals(Arrays.toString(arr)));
        assertTrue(equals);
    }
    @Test
    public void Non_Comparison_sort()
    {
        ArrayList<int []> result=sortArray1.Non_Comparison_Sort(false);
        int [] arr=sortArray1.getArr();
        //sorting the array with built-in java sort
        Arrays.sort(arr);
        boolean equals=(Arrays.toString(result.get(0)).equals(Arrays.toString(arr)));
        assertTrue(equals);
    }
    @Test
    public void Time_Comparison_sort()
    { //100,000 words
      long start1=System.currentTimeMillis();
      sortArray3.simpleSort(false);
      long end1=System.currentTimeMillis();
      long duration1=(end1-start1);

        long start2=System.currentTimeMillis();
        sortArray3.EfficientSort(false);
        long end2=System.currentTimeMillis();
        long duration2=(end2-start2);

        long start3=System.currentTimeMillis();
        sortArray3.Non_Comparison_Sort(false);
        long end3=System.currentTimeMillis();
        long duration3=(end3-start3);

        long start4=System.currentTimeMillis();
        sortArray3.heapSort(false);
        long end4=System.currentTimeMillis();
        long duration4=(end4-start4);

        System.out.println("Time to sort the array with:");
        System.out.println("\u001B[35m[Simple Sort] = (" + duration1 + ") ms\u001B[0m");
        System.out.println("\u001B[34m[Efficient Sort] = (" + duration2 + ") ms\u001B[0m");
        System.out.println("\u001B[33m[Non Comparison Sort] = (" + duration3 + ") ms\u001B[0m");
        System.out.println("\u001B[36m[Heap sort] = (" + duration4 + ") ms\u001B[0m");
    }
    @Test
    public void Time_Comparison_with_respect_to_CountingSort()
    { //2 words!
        long start1=System.nanoTime();
        sortArray8.simpleSort(false);
        long end1=System.nanoTime();
        long duration1=(end1-start1);

        long start2=System.nanoTime();
        sortArray8.EfficientSort(false);
        long end2=System.nanoTime();
        long duration2=(end2-start2);

        long start3=System.nanoTime();
        sortArray8.Non_Comparison_Sort(false);
        long end3=System.nanoTime();
        long duration3=(end3-start3);

        System.out.println("Time to sort the array with:");
        System.out.println("\u001B[35m[Simple Sort] = (" + duration1 + ") ns\u001B[0m");
        System.out.println("\u001B[34m[Efficient Sort] = (" + duration2 + ") ns\u001B[0m");
        System.out.println("\u001B[33m[Non Comparison Sort] = (" + duration3 + ") ns\u001B[0m");
    }
    @Test
    public void Best_Case_NonComparisonSort()
    {
        long start=System.nanoTime();
        sortArray5.Non_Comparison_Sort(false);
        long end=System.nanoTime();
        long duration=(end-start);
        System.out.println("Time to sort the array with:");
        System.out.println("\u001B[33m[Non Comparison Sort] = (" + duration+ ") ns\u001B[0m");
    }
    @Test
    public void Worst_Case_NonComparisonSort()
    {
        long start=System.nanoTime();
        sortArray8.Non_Comparison_Sort(false);
        long end=System.nanoTime();
        long duration=(end-start);
        System.out.println("Time to sort the array with:");
        System.out.println("\u001B[33m[Non Comparison Sort] = (" + duration+ ") ns\u001B[0m");
    }

}


