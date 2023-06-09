import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertTrue;

public class Junit {
    public String file = "100k.txt";
    SortArray sortArray1 = new SortArray("100.txt");
    SortArray sortArray2 = new SortArray("1k.txt");
    SortArray sortArray3 = new SortArray("10k.txt");
    SortArray sortArray4 = new SortArray("100k.txt");
    SortArray sortArray5 = new SortArray("bestCounting.txt");
    SortArray sortArray6 = new SortArray("test1.txt");
    SortArray sortArray7 = new SortArray("Counting.txt");
    SortArray sortArray8 = new SortArray("2.txt");
    SortArray sortArray9 = new SortArray("50k.txt");
    SortArray sortArray10 = new SortArray("1M.txt");
    SortArray sortArray11 = new SortArray("empty.txt");
    SortArray sortArray12 = new SortArray("sameValue.txt");
    SortArray sortArray13 = new SortArray("reverse.txt");
    SortArray sortArray14 = new SortArray("sorted.txt");

    @Test
    public void Time_Comparison_sort() {
        long start1 = System.currentTimeMillis();
        sortArray4.simpleSort(false);
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1);

        long start2 = System.currentTimeMillis();
        sortArray4.EfficientSort(false);
        long end2 = System.currentTimeMillis();
        long duration2 = (end2 - start2);

        long start3 = System.currentTimeMillis();
        sortArray4.Non_Comparison_Sort(false);
        long end3 = System.currentTimeMillis();
        long duration3 = (end3 - start3);

        long start4 = System.currentTimeMillis();
        sortArray4.heapSort(false);
        long end4 = System.currentTimeMillis();
        long duration4 = (end4 - start4);

        System.out.println("Time to sort the array with :");
        System.out.println("\u001B[35m[Simple Sort] = (" + duration1 + ") ms\u001B[0m");
        System.out.println("\u001B[34m[Efficient Sort] = (" + duration2 + ") ms\u001B[0m");
        System.out.println("\u001B[33m[Non Comparison Sort] = (" + duration3 + ") ms\u001B[0m");
        System.out.println("\u001B[36m[Heap sort] = (" + duration4 + ") ms\u001B[0m");
    }

    @Test
    public void Test_Simple_sort() {
        ArrayList<int[]> result = sortArray1.simpleSort(false);
        int[] arr = sortArray1.getArr();
        //sorting the array with built-in java sort
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(result.get(0)));
        boolean isEqual = (Arrays.toString(result.get(0)).equals(Arrays.toString(arr)));
        assertTrue(isEqual);
    }

    @Test
    public void Test_Heap_sort() {
        ArrayList<int[]> result = sortArray6.heapSort(false);
        ArrayList<int[]> steps = sortArray6.heapSort(true);
        int[] arr = sortArray6.getArr();
        //sorting the array with built-in java sort
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(result.get(0)));
        for (int i = 0; i < steps.size(); i++) {
            System.out.println("\u001B[34m" + Arrays.toString(steps.get(i)) + "\u001B[0m");
        }
        boolean isEquals = (Arrays.toString(result.get(0)).equals(Arrays.toString(arr)));
        assertTrue(isEquals);
    }


    @Test
    public void Test_Efficient_sort() {
        ArrayList<int[]> result = sortArray1.EfficientSort(false);
        int[] arr = sortArray1.getArr();
        //sorting the array with built-in java sort
        Arrays.sort(arr);
        boolean isEquals = (Arrays.toString(result.get(0)).equals(Arrays.toString(arr)));
        assertTrue(isEquals);
    }

    @Test
    public void Test_Non_Comparison_sort() {
        ArrayList<int[]> result = sortArray1.Non_Comparison_Sort(false);
        int[] arr = sortArray1.getArr();
        //sorting the array with built-in java sort
        Arrays.sort(arr);
        boolean isEquals = (Arrays.toString(result.get(0)).equals(Arrays.toString(arr)));
        assertTrue(isEquals);
    }

    @Test
    public void best_and_worst_bubble() {

        long start1 = System.currentTimeMillis();
        sortArray14.simpleSort(false);
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1);

        long start2 = System.currentTimeMillis();
        sortArray13.simpleSort(false);
        long end2 = System.currentTimeMillis();
        long duration2 = (end2 - start2);


        System.out.println("Bubble sort with 10k :");
        System.out.println("\u001B[35m[Best case] = (" + duration1 + ") ms\u001B[0m");
        System.out.println("\u001B[34m[worst case] = (" + duration2 + ") ms\u001B[0m");
    }

    @Test
    public void best_and_worst_NonComparison() {
        long start1 = System.currentTimeMillis();
        sortArray5.Non_Comparison_Sort(false);
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1);

        long start2 = System.currentTimeMillis();
        sortArray8.Non_Comparison_Sort(false);
        long end2 = System.currentTimeMillis();
        long duration2 = (end2 - start2);

        System.out.println("Time to sort the array with non comparison sort:");
        System.out.println("\u001B[33m[Best case] = (" + duration1 + ") ms\u001B[0m");
        System.out.println("\u001B[34m[Worst case] = (" + duration2 + ") ms\u001B[0m");
    }


    @Test
    public void empty_file_case() {

        long end1, start1 = System.currentTimeMillis();
        sortArray11.simpleSort(false);
        end1 = System.currentTimeMillis();
        end1 = (end1 - start1);

        long end2, start2 = System.currentTimeMillis();
        sortArray11.EfficientSort(false);
        end2 = System.currentTimeMillis();
        end2 = (end2 - start2);

        long end3, start3 = System.currentTimeMillis();
        sortArray11.Non_Comparison_Sort(false);
        end3 = System.currentTimeMillis();
        end3 = (end3 - start3);

        long end4, start4 = System.currentTimeMillis();
        sortArray11.heapSort(false);
        end4 = System.currentTimeMillis();
        end4 = (end4 - start4);

        System.out.println("Time to sort the array with :");
        System.out.println("\u001B[35m[Simple Sort] = (" + end1 + ") ms\u001B[0m");
        System.out.println("\u001B[34m[Efficient Sort] = (" + end2 + ") ms\u001B[0m");
        System.out.println("\u001B[33m[Non Comparison Sort] = (" + end3 + ") ms\u001B[0m");
        System.out.println("\u001B[36m[Heap sort] = (" + end4 + ") ms\u001B[0m");

    }


    @Test
    public void same_file_case() {

        long end1, start1 = System.currentTimeMillis();
        sortArray12.simpleSort(false);
        end1 = System.currentTimeMillis();
        end1 = (end1 - start1);

        long end2, start2 = System.currentTimeMillis();
        sortArray12.EfficientSort(false);
        end2 = System.currentTimeMillis();
        end2 = (end2 - start2);

        long end3, start3 = System.currentTimeMillis();
        sortArray12.Non_Comparison_Sort(false);
        end3 = System.currentTimeMillis();
        end3 = (end3 - start3);

        long end4, start4 = System.currentTimeMillis();
        sortArray12.heapSort(false);
        end4 = System.currentTimeMillis();
        end4 = (end4 - start4);

        System.out.println("Time to sort the array with :");
        System.out.println("\u001B[35m[Simple Sort] = (" + end1 + ") ms\u001B[0m");
        System.out.println("\u001B[34m[Efficient Sort] = (" + end2 + ") ms\u001B[0m");
        System.out.println("\u001B[33m[Non Comparison Sort] = (" + end3 + ") ms\u001B[0m");
        System.out.println("\u001B[36m[Heap sort] = (" + end4 + ") ms\u001B[0m");

    }

    @Test
    public void worst_case_heap_merge_bubble() {

        long end1, start1 = System.currentTimeMillis();
        sortArray13.simpleSort(false);
        end1 = System.currentTimeMillis();
        end1 = (end1 - start1);

        long end2, start2 = System.currentTimeMillis();
        sortArray13.EfficientSort(false);
        end2 = System.currentTimeMillis();
        end2 = (end2 - start2);


        long end4, start4 = System.currentTimeMillis();
        sortArray13.heapSort(false);
        end4 = System.currentTimeMillis();
        end4 = (end4 - start4);

        System.out.println("Time to sort the array with :");
        System.out.println("\u001B[35m[Simple Sort] = (" + end1 + ") ms\u001B[0m");
        System.out.println("\u001B[34m[Efficient Sort] = (" + end2 + ") ms\u001B[0m");
        System.out.println("\u001B[36m[Heap sort] = (" + end4 + ") ms\u001B[0m");

    }

    @Test
    public void best_case_heap_merge_bubble() {

        long end1, start1 = System.currentTimeMillis();
        sortArray14.simpleSort(false);
        end1 = System.currentTimeMillis();
        end1 = (end1 - start1);

        long end2, start2 = System.currentTimeMillis();
        sortArray14.EfficientSort(false);
        end2 = System.currentTimeMillis();
        end2 = (end2 - start2);

        long end4, start4 = System.currentTimeMillis();
        sortArray14.heapSort(false);
        end4 = System.currentTimeMillis();
        end4 = (end4 - start4);


        System.out.println("Time to sort the array with :");
        System.out.println("\u001B[35m[Simple Sort] = (" + end1 + ") ms\u001B[0m");
        System.out.println("\u001B[34m[Efficient Sort] = (" + end2 + ") ms\u001B[0m");
        System.out.println("\u001B[36m[Heap sort] = (" + end4 + ") ms\u001B[0m");

    }

    @Test
    public void bestCaseComparision() {
        Long start1 = System.nanoTime();
        sortArray14.simpleSort(false);
        Long end1 = System.nanoTime();
        Long duration1 = (end1 - start1);
        Long start2 = System.nanoTime();
        sortArray14.EfficientSort(false);
        Long end2 = System.nanoTime();
        Long duration2 = (end2 - start2);
        Long start3 = System.nanoTime();
        sortArray14.Non_Comparison_Sort(false);
        Long end3 = System.nanoTime();
        Long duration3 = (end3 - start3);
        Long start4 = System.nanoTime();
        sortArray14.heapSort(false);
        Long end4 = System.nanoTime();
        Long duration4 = (end4 - start4);
        System.out.println("Time to sort the array with :");
        System.out.println("\u001B[35m[Simple Sort] = (" + duration1 + ") ns\u001B[0m");
        System.out.println("\u001B[34m[Efficient Sort] = (" + duration2 + ") ns\u001B[0m");
        System.out.println("\u001B[33m[Non Comparison Sort] = (" + duration3 + ") ns\u001B[0m");
        System.out.println("\u001B[36m[Heap sort] = (" + duration4 + ") ns\u001B[0m");
    }

    @Test
    public void heavyTestForAllAlgorithms() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        SortArray sortArray = new SortArray(list.toArray(new Integer[list.size()]));
        SortArray sortArray2 = new SortArray(list.toArray(new Integer[list.size()]));
        SortArray sortArray3 = new SortArray(list.toArray(new Integer[list.size()]));
        SortArray sortArray4 = new SortArray(list.toArray(new Integer[list.size()]));
        Long start1 = System.nanoTime();
        sortArray.simpleSort(false);
        Long end1 = System.nanoTime();
        Long duration1 = (end1 - start1);
        Long start2 = System.nanoTime();
        sortArray2.EfficientSort(false);
        Long end2 = System.nanoTime();
        Long duration2 = (end2 - start2);
        Long start3 = System.nanoTime();
        sortArray3.Non_Comparison_Sort(false);
        Long end3 = System.nanoTime();
        Long duration3 = (end3 - start3);
        Long start4 = System.nanoTime();
        sortArray4.heapSort(false);
        Long end4 = System.nanoTime();
        Long duration4 = (end4 - start4);

        for (int i = 0; i < 100000; i++) {
            assertTrue(sortArray.result.get(0)[i] == i);
            assertTrue(sortArray2.result.get(0)[i] == i);
            assertTrue(sortArray3.result.get(0)[i] == i);
            assertTrue(sortArray4.result.get(0)[i] == i);

        }
        System.out.println("Time to sort the array with :");
        System.out.println("\u001B[35m[Simple Sort] = (" + duration1 + ") ns\u001B[0m");
        System.out.println("\u001B[34m[Efficient Sort] = (" + duration2 + ") ns\u001B[0m");
        System.out.println("\u001B[33m[Non Comparison Sort] = (" + duration3 + ") ns\u001B[0m");
        System.out.println("\u001B[36m[Heap sort] = (" + duration4 + ") ns\u001B[0m");
    }

    @Test
    public void exportTimesToBePlotted() throws IOException {
        String[] fileNames = {"2.txt", "100.txt", "1k.txt", "10k.txt", "50k.txt", "100k.txt"};
        for (String fileName : fileNames) {
            String str = new String(fileName);
            FileWriter fileWriter = new FileWriter("data.txt", true);
            SortArray sortArray;
            Long start1, end1, duration1;
            Long start2, end2, duration2;
            Long start3, end3, duration3;
            Long start4, end4, duration4;
            ArrayList<Long> simpleSort = new ArrayList<>();
            ArrayList<Long> efficientSort = new ArrayList<>();
            ArrayList<Long> nonComparisonSort = new ArrayList<>();
            ArrayList<Long> heapSort = new ArrayList<>();

            for (int i = 0; i < 5; i++) {
                sortArray = new SortArray(str);
                start1 = System.nanoTime();
                sortArray.simpleSort(false);
                end1 = System.nanoTime();
                duration1 = (end1 - start1);
                start2 = System.nanoTime();
                sortArray.EfficientSort(false);
                end2 = System.nanoTime();
                duration2 = (end2 - start2);
                start3 = System.nanoTime();
                sortArray.Non_Comparison_Sort(false);
                end3 = System.nanoTime();
                duration3 = (end3 - start3);
                start4 = System.nanoTime();
                sortArray.heapSort(false);
                end4 = System.nanoTime();
                duration4 = (end4 - start4);
                simpleSort.add(duration1);
                efficientSort.add(duration2);
                nonComparisonSort.add(duration3);
                heapSort.add(duration4);
            }
            Long simpleSortAverage = 0L;
            Long efficientSortAverage = 0L;
            Long nonComparisonSortAverage = 0L;
            Long heapSortAverage = 0L;
            for (int i = 0; i < 5; i++) {
                simpleSortAverage += simpleSort.get(i);
                efficientSortAverage += efficientSort.get(i);
                nonComparisonSortAverage += nonComparisonSort.get(i);
                heapSortAverage += heapSort.get(i);
            }
            simpleSortAverage /= 5000;
            efficientSortAverage /= 5000;
            nonComparisonSortAverage /= 5000;
            heapSortAverage /= 5000;
            System.out.println("Average time to sort the array with file size==>" + str);
            System.out.println("\u001B[35m[Simple Sort] = (" + simpleSortAverage + ") ns\u001B[0m");
            System.out.println("\u001B[34m[Efficient Sort] = (" + efficientSortAverage + ") ns\u001B[0m");
            System.out.println("\u001B[33m[Non Comparison Sort] = (" + nonComparisonSortAverage + ") ns\u001B[0m");
            System.out.println("\u001B[36m[Heap sort] = (" + heapSortAverage + ") ns\u001B[0m");
            fileWriter.write("Average time to sort the array with file size==>" + str + "\n");
            fileWriter.write(simpleSortAverage + "\n");
            fileWriter.write(efficientSortAverage + "\n");
            fileWriter.write(nonComparisonSortAverage + "\n");
            fileWriter.write(heapSortAverage + "\n");
            fileWriter.close();
        }
    }

    @Test
    public void testTimeComplexityBestCaseNonComparisonSort() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        SortArray sortArray = new SortArray(list.toArray(new Integer[list.size()]));
        Long start1 = System.currentTimeMillis();
        sortArray.Non_Comparison_Sort(false);
        Long end1 = System.currentTimeMillis();
        Long duration1 = (end1 - start1);
        System.out.println("Time to sort the array with :");
        System.out.println("\u001B[33m[Non Comparison Sort] = (" + duration1 + ") ns\u001B[0m");
        for (int i = 0; i < 100000; i++) {
            assertTrue(sortArray.result.get(0)[i] == i);
        }
    }

    @Test
    public void testTimeComplexityBestCaseHeapSort() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        SortArray sortArray = new SortArray(list.toArray(new Integer[list.size()]));
        Long start1 = System.currentTimeMillis();
        sortArray.heapSort(false);
        Long end1 = System.currentTimeMillis();
        Long duration1 = (end1 - start1);
        System.out.println("Time to sort the array with :");
        System.out.println("\u001B[36m[Heap sort] = (" + duration1 + ") ns\u001B[0m");
        for (int i = 0; i < 100000; i++) {
            assertTrue(sortArray.result.get(0)[i] == i);
        }
    }

    //test time Complexity worst case for all algorithms
    @Test
    public void testTimeComplexityWorstCaseSimpleSort() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 100000; i > 0; i--) {
            list.add(i);
        }
        SortArray sortArray = new SortArray(list.toArray(new Integer[list.size()]));
        Long start1 = System.currentTimeMillis();
        sortArray.simpleSort(false);
        Long end1 = System.currentTimeMillis();
        Long duration1 = (end1 - start1);
        System.out.println("Time to sort the array with :");
        System.out.println("\u001B[35m[Simple Sort] = (" + duration1 + ") ns\u001B[0m");
        for (int i = 0; i < 100000; i++) {
            assertTrue(sortArray.result.get(0)[i] == i + 1);
        }
    }

    @Test
    public void testTimeComplexityWorstCaseEfficientSort() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 100000; i > 0; i--) {
            list.add(i);
        }
        SortArray sortArray = new SortArray(list.toArray(new Integer[list.size()]));
        Long start1 = System.currentTimeMillis();
        sortArray.EfficientSort(false);
        Long end1 = System.currentTimeMillis();
        Long duration1 = (end1 - start1);
        System.out.println("Time to sort the array with :");
        System.out.println("\u001B[34m[Efficient Sort] = (" + duration1 + ") ns\u001B[0m");
        for (int i = 0; i < 100000; i++) {
            assertTrue(sortArray.result.get(0)[i] == i + 1);
        }
    }

    @Test
    public void testTimeComplexityWorstCaseNonComparisonSort() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 100000; i > 0; i--) {
            list.add(i);
        }
        SortArray sortArray = new SortArray(list.toArray(new Integer[list.size()]));
        Long start1 = System.currentTimeMillis();
        sortArray.Non_Comparison_Sort(false);
        Long end1 = System.currentTimeMillis();
        Long duration1 = (end1 - start1);
        System.out.println("Time to sort the array with :");
        System.out.println("\u001B[33m[Non Comparison Sort] = (" + duration1 + ") ns\u001B[0m");
        for (int i = 0; i < 100000; i++) {
            assertTrue(sortArray.result.get(0)[i] == i + 1);
        }
    }

    @Test
    public void testTimeComplexityWorstCaseHeapSort() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 100000; i > 0; i--) {
            list.add(i);
        }
        SortArray sortArray = new SortArray(list.toArray(new Integer[list.size()]));
        Long start1 = System.currentTimeMillis();
        sortArray.heapSort(false);
        Long end1 = System.currentTimeMillis();
        Long duration1 = (end1 - start1);
        System.out.println("Time to sort the array with :");
        System.out.println("\u001B[36m[Heap sort] = (" + duration1 + ") ns\u001B[0m");
        for (int i = 0; i < 100000; i++) {
            assertTrue(sortArray.result.get(0)[i] == i + 1);
        }
    }

    //test time Complexity average case for all algorithms
    @Test
    public void testTimeComplexityAverageCaseSimpleSort() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            list.add((int) (Math.random() * 100000));
        }
        SortArray sortArray = new SortArray(list.toArray(new Integer[list.size()]));
        Long start1 = System.currentTimeMillis();
        sortArray.simpleSort(false);
        Long end1 = System.currentTimeMillis();
        Long duration1 = (end1 - start1);
        System.out.println("Time to sort the array with :");
        System.out.println("\u001B[35m[Simple Sort] = (" + duration1 + ") ns\u001B[0m");
    }

    @Test
    public void testTimeComplexityAverageCaseEfficientSort() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            list.add((int) (Math.random() * 100000));
        }
        SortArray sortArray = new SortArray(list.toArray(new Integer[list.size()]));
        Long start1 = System.currentTimeMillis();
        sortArray.EfficientSort(false);
        Long end1 = System.currentTimeMillis();
        Long duration1 = (end1 - start1);
        System.out.println("Time to sort the array with :");
        System.out.println("\u001B[34m[Efficient Sort] = (" + duration1 + ") ns\u001B[0m");
    }

    @Test
    public void testTimeComplexityAverageCaseNonComparisonSort() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            list.add((int) (Math.random() * 100000));
        }
        SortArray sortArray = new SortArray(list.toArray(new Integer[list.size()]));
        Long start1 = System.currentTimeMillis();
        sortArray.Non_Comparison_Sort(false);
        Long end1 = System.currentTimeMillis();
        Long duration1 = (end1 - start1);
        System.out.println("Time to sort the array with :");
        System.out.println("\u001B[33m[Non Comparison Sort] = (" + duration1 + ") ns\u001B[0m");
    }

    @Test
    public void testTimeComplexityAverageCaseHeapSort() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            list.add((int) (Math.random() * 100000));
        }
        SortArray sortArray = new SortArray(list.toArray(new Integer[list.size()]));
        Long start1 = System.currentTimeMillis();
        sortArray.heapSort(false);
        Long end1 = System.currentTimeMillis();
        Long duration1 = (end1 - start1);
        System.out.println("Time to sort the array with :");
        System.out.println("\u001B[36m[Heap sort] = (" + duration1 + ") ns\u001B[0m");
    }
}


