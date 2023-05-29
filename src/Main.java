import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        printArr(parseInegersFromFile("100.txt"));
//        printArr(parseFromFile("100.txt"));

//        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(9,3,1,4,10,14,11,8,12));
//        PriorityQueue h = new PriorityQueue(arr);
//        h.printArr();
//        h.insert(100);
//        h.printArr();
//        h.extract();
//        h.printArr();
//        h.extract();
//        h.printArr();
//        h.insert(2);
//        h.printArr();
//        CommandLine cl = new CommandLine();
//        cl.UserInterface();
    }
    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println( arr[i]);
        }
    }
    public static int [] parseInegersFromFile(String file_path) {
        File file = new File(file_path);
        ArrayList<Integer> arr = new ArrayList<>();
        try {
            java.util.Scanner sc = new java.util.Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] strArray = line.split(",");
                for (int i = 0; i < strArray.length; i++) {
                    arr.add(Integer.parseInt(strArray[i]));
                }
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("\u001B[31mAn ERROR occurred opening file\u001B[0m ");
        }
        int[] arr2 = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            arr2[i] = arr.get(i);
        }
        return arr2;
    }
    public static int [] parseFromFile(String filePath){
        List<String> keys = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
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
        int[] arr2 = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            arr2[i] = arr.get(i);
        }
        return arr2;
    }
}